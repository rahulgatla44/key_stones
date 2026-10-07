package com.key_stones.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public abstract class JWTAuthenticationFilter extends OncePerRequestFilter {

	
	
	private JWTTokenUtil jwtUtil;
	private final CustomerUserDetailsService customUserDetailsService;
	public JWTAuthenticationFilter(JWTTokenUtil jwtUtil, CustomerUserDetailsService customUserDetailsService) {
		this.customUserDetailsService= customUserDetailsService;
		this.jwtUtil=jwtUtil;
	}
	@Autowired
	private TokenKillService tokenKillService;
	
	public void doFilter(HttpServletRequest request,
			            HttpServletResponse response,
			            FilterChain filterChain) throws Exception {
		
		String header =request.getHeader("Authorization");
		String token=null;
		
		
		if(StringUtils.hasText(header) && header.startsWith("Bearer ")) {
			
			token= header.substring(7);
		}
		
		
		String tokenKill= jwtUtil.extractToken(request.getHeader("Authorization"));
		if(tokenKill !=null) {
			if(tokenKillService.isBlockedToken(tokenKill)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}
		 
		
		if(token !=null && jwtUtil.validateToken(token)) {
			
			String userEmail=jwtUtil.getUserEmail(token);
			UserDetails userDetail= customUserDetailsService.loadUserByUsername(userEmail);
			
			UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());
			
			
			auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(auth);
			
		}
		filterChain.doFilter(request, response);
		
	}

	
	
}