package com.park.model;

import java.sql.Timestamp;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String customerId;
	private Space space;
	private String customerName;
	private String sex;
	private String telphone;
	private Double depositCash;
	private Timestamp arrivalTime;
	private Integer days;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String customerId, Space space, String customerName,
			String sex, String telphone, Double depositCash,
			Timestamp arrivalTime, Integer days) {
		this.customerId = customerId;
		this.space = space;
		this.customerName = customerName;
		this.sex = sex;
		this.telphone = telphone;
		this.depositCash = depositCash;
		this.arrivalTime = arrivalTime;
		this.days = days;
	}

	// Property accessors

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Space getSpace() {
		return this.space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Double getDepositCash() {
		return this.depositCash;
	}

	public void setDepositCash(Double depositCash) {
		this.depositCash = depositCash;
	}

	public Timestamp getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

}