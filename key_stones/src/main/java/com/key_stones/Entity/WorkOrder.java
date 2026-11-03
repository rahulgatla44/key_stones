package com.key_stones.Entity;


import java.time.LocalDateTime;

import com.key_stones.ENUM.Priority;
import com.key_stones.ENUM.WorkStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="work_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	@Column(length=5000)
	private String description;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private WorkStatus workStatus;
	
	@Column(name="customer_Id",nullable=false)
	private Long customerId;
	
	@Column(name="site_id",nullable=false)
	private Long siteId;
	
	@Column(name="technician_id",nullable=false)
	private Long technicianId;
	
	private LocalDateTime createdAt;
	private LocalDateTime slaDueDate;
	private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public WorkStatus getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(Long technicianId) {
		this.technicianId = technicianId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getSlaDueDate() {
		return slaDueDate;
	}
	public void setSlaDueDate(LocalDateTime slaDueDate) {
		this.slaDueDate = slaDueDate;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}
