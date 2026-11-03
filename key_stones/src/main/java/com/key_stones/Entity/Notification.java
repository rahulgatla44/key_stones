package com.key_stones.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="notification")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String recepientEmail;
	private String subject;
	private String message;
	private String eventType;
	private LocalDateTime sentAt=LocalDateTime.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecepientEmail() {
		return recepientEmail;
	}
	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	

}
