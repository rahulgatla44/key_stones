package com.key_stones.Security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.key_stones.ENUM.Permissions;
import com.key_stones.Entity.UserAuth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTTokenUtil {
	
	private final Key key;
	private final long validToken= 12*60*60*1000L;
	
	public JWTTokenUtil() {
		String secret= System.getenv("JWT_SECRET");
		if(secret==null || secret.isEmpty() ) {
			secret="Replace this place with some secret";
		}
		
		key=Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(UserAuth user) {
		
		Map<String,Object>claim= new HashMap<>();
		claim.put("role", user.getRole().name());
		
		Set<Permissions>perm= RoleBasedPermission.getRoleBasedPermissions().get(user.getRole().name());
		
		
		Date now= new Date();
		Date expire= new Date(now.getTime()+validToken);
		
		return Jwts.builder()
				.setClaims(claim)
				.setSubject(user.getUserEmail())
				.setIssuedAt(now)
				.setExpiration(expire)
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String getUserEmail(String token) {
		return getClaims(token).getSubject();
	}
	
	
	public String extractToken(String header) {
		if(header!=null && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		return null;
	}

}


