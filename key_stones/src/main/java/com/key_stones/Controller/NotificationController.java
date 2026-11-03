package com.key_stones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.key_stones.DTO.NotificationDTO;
import com.key_stones.Service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/send")
	public ResponseEntity<String>sendNotification(@RequestBody NotificationDTO notification) {
		notificationService.notification(notification);
		return ResponseEntity.ok("Notification sent successfully");
	}
	
}

