package com.key_stones.Entity;


import java.util.Date;

import com.key_stones.ENUM.Role;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="user_auth")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAuth {
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 
 @Column(nullable=false)
 private String firstName;
 
 @Column(nullable=false)
 private String lastName;
 
 @Column(nullable=false,unique=true)
 private String userEmail;
 
 private String phone;
 
 @Column(nullable=false)
 private String password;
 
 @Enumerated(EnumType.STRING)
 private Role role;
 
 private String resetToken;
 
 private Date resetTokenExpire;
 
 
 //public UserAuth() {}
 //public UserAuth(Long id,
	//	 String firstName,
		// String lastName,
		 //String userEmail,
		 //String phone,
		 //String password,
		 //Role role) {
	 
	// this.id=id;
	 //this.firstName=firstName;
	 //this.lastName=lastName;
	 //this.userEmail=userEmail;
	 //this.phone=phone;
	 //this.password=password;
	 //this.role=role;
	 
 //}
 
 
 

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}
public String getResetToken() {
	return resetToken;
}
public void setResetToken(String resetToken) {
	this.resetToken = resetToken;
}
public Date getResetTokenExpire() {
	return resetTokenExpire;
}
public void setResetTokenExpire(Date resetTokenExpire) {
	this.resetTokenExpire = resetTokenExpire;
}

 
}
