package com.key_stones.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.key_stones.DTO.AuthResponse;
import com.key_stones.DTO.ForgotPasswordDTO;
import com.key_stones.DTO.LoginRequestDTO;
import com.key_stones.DTO.RegisterRequestDTO;
import com.key_stones.DTO.ResetPasswordDTO;
import com.key_stones.Entity.UserAuth;
import com.key_stones.Repository.UserAuthRepository;
import com.key_stones.Security.EmailService;
import com.key_stones.Security.JWTTokenUtil;
import com.key_stones.Security.TokenKillService;

import jakarta.servlet.http.HttpServletRequest;

@Service

public class UserAuthService {
	
	@Autowired
	private UserAuthRepository userRepo;
	@Autowired
	private JWTTokenUtil jwtUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmailService emailService;
	@Autowired
	private TokenKillService tokenKillService;
	
	public AuthResponse register(RegisterRequestDTO register) {
		
		Optional<UserAuth>existingUser= userRepo.findByUserEmail(register.userEmail);
		if(existingUser.isPresent()) {
			throw new RuntimeException("User already exist");
		}
		UserAuth user= new UserAuth();
		
		user.setFirstName(register.firstName);
		user.setLastName(register.lastName);
		user.setUserEmail(register.userEmail);
		user.setPassword(passwordEncoder.encode(register.password));
		user.setPhone(register.phone);
		user.setRole(register.role);
		userRepo.save(user);
		
		String token= jwtUtil.generateToken(user);
		
		return new AuthResponse(token,"User register successfully");
		
		
	}
	
	public String login(LoginRequestDTO login) {
		
		UserAuth user=userRepo.findByUserEmail(login.userEmail)
				.orElseThrow(()-> new RuntimeException("User not found"));
		if(!passwordEncoder.matches(login.password, user.getPassword())) {
			throw new RuntimeException("Invalid credential");
		}
		
		
		return jwtUtil.generateToken(user);
		
	}
	
	public void forgotPassword(ForgotPasswordDTO forgotPassword) {
		
		UserAuth user= userRepo.findByUserEmail(forgotPassword.userEmail)
				.orElseThrow(()-> new RuntimeException("User not found"));
		String token= UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpire(new Date(System.currentTimeMillis()+ 10*60*1000));
		
		userRepo.save(user);
		System.out.println("Reset password:"+token);
		
		String resetPasswordLink="http://localhost:8080/auth/reset-password?token="+token;
		
	}
	
	public void resetPassword(ResetPasswordDTO resetPassword) {
		
		UserAuth user=userRepo.findByResetToken(resetPassword.token)
				.orElseThrow(()-> new RuntimeException("Invalid password"));
	
		if(user.getResetTokenExpire().before(new Date())) {
			throw new RuntimeException("Reset Password link Expired");
		}
		user.setPassword(passwordEncoder.encode(resetPassword.newPassword));
		user.setResetToken(null);
		user.setResetTokenExpire(null);
		
		userRepo.save(user);
		
	}
	
	public String logout(HttpServletRequest request) {
		
		String header= request.getHeader("Authorization");
		String token=jwtUtil.extractToken(header);
		
		if(token != null) {
			tokenKillService.blockListToken(token);
		}
		return "Logged out successfully";
	}

}
