package com.key_stones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.key_stones.DTO.EmailLogsDTO;
import com.key_stones.Security.EmailService;

@RestController
@RequestMapping("/api/email")

public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/resetPsswordEmail")
	public ResponseEntity<String>sendResetPasswordEmail(@RequestParam String to,@PathVariable String token ){
		emailService.sentResetPasswordLink(to, token);
		return ResponseEntity.ok("Reset Password link sent over on yourEmail");
	
	}
	
	@PostMapping("/notify")
	public ResponseEntity<String>notification(@RequestBody EmailLogsDTO emailLog){
		String result= emailService.notify(emailLog);
		return ResponseEntity.ok(result);
	}

}