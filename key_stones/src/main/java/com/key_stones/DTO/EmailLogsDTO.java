package com.key_stones.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailLogsDTO {
	
	public String recipientEmail;
	public String subject;
	public String body;
	public boolean sentStatus;
	

}
