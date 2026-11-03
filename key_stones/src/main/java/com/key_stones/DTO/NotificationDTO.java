package com.key_stones.DTO;

import java.util.Set;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
	
	public String eventType;
	public String subject;
	public Set<String> recepientEmail;
	public String message;
	

}
