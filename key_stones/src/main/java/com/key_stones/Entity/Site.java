package com.key_stones.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="site_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Site {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String siteName;
	private Long lanNo;
	private String buildingName;
	private Long buildingNo;
	private Long floorNo;
	private Long roomNo;
	private String cityName;
	private String stateName;
	private String landMark;
	private String countryName;
	private Long zipCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Long getLanNo() {
		return lanNo;
	}
	public void setLanNo(Long lanNo) {
		this.lanNo = lanNo;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public Long getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(Long buildingNo) {
		this.buildingNo = buildingNo;
	}
	public Long getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(Long floorNo) {
		this.floorNo = floorNo;
	}
	public Long getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Long roomNo) {
		this.roomNo = roomNo;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
