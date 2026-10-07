package com.key_stones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.key_stones.DTO.AuthResponse;
import com.key_stones.DTO.ForgotPasswordDTO;
import com.key_stones.DTO.LoginRequestDTO;
import com.key_stones.DTO.RegisterRequestDTO;
import com.key_stones.DTO.ResetPasswordDTO;
import com.key_stones.Service.UserAuthService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/user_auth")
@RequiredArgsConstructor
public class UserAuthController {
	
	@Autowired
	private UserAuthService userService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequestDTO register) {
		return ResponseEntity.ok(userService.register(register));
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String>login(@RequestBody LoginRequestDTO login) {
		String token= userService.login(login);
		return ResponseEntity.ok("Login Successful");
		
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<String>forgotPassword(@RequestBody ForgotPasswordDTO forgotPassword) {
		userService.forgotPassword(forgotPassword);
		return ResponseEntity.ok("Reset password link has sent over on your registered email");
		
	}
	@PostMapping("/reset-password")
	public ResponseEntity<String>resetPassword(@RequestBody ResetPasswordDTO resetPassword) {
		userService.resetPassword(resetPassword);
		return ResponseEntity.ok("Password reset successful");
	}
	@PostMapping("/logout")
	public ResponseEntity<String>logout(HttpServletRequest request) {
	return ResponseEntity.ok(userService.logout(request));
	}
	
	
}
	
	
	

