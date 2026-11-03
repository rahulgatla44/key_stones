package com.key_stones.Entity;

import java.time.LocalDateTime;

import com.key_stones.ENUM.WorkStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="work_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long workOrderId;
	private WorkStatus fromStatus;
	private WorkStatus toStatus;
	private String changedBy;
	private LocalDateTime changedAt;
	@Column(length=10000)
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(Long workOrderId) {
		this.workOrderId = workOrderId;
	}
	public WorkStatus getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(WorkStatus fromStatus) {
		this.fromStatus = fromStatus;
	}
	public WorkStatus getToStatus() {
		return toStatus;
	}
	public void setToStatus(WorkStatus toStatus) {
		this.toStatus = toStatus;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public LocalDateTime getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	

}
