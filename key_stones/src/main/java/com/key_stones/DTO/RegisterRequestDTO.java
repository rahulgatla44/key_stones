package com.key_stones.DTO;

import com.key_stones.ENUM.Role;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDTO {
	
	public String firstName;
	public String lastName;
	public String userEmail;
	public String password;
	public String phone;
	public Role role;
	
	

}
