package com.park.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Space entity. @author MyEclipse Persistence Tools
 */

public class Space implements java.io.Serializable {

	// Fields

	private String spaceId;
	private String spaceState;
	private String spaceType;
	private Integer spacePrice;
	private String spaceTel;
	private Set customers = new HashSet(0);
	private Set reservations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Space() {
	}

	/** minimal constructor */
	public Space(String spaceId, String spaceState, String spaceType,
			Integer spacePrice, String spaceTel) {
		this.spaceId = spaceId;
		this.spaceState = spaceState;
		this.spaceType = spaceType;
		this.spacePrice = spacePrice;
		this.spaceTel = spaceTel;
	}

	/** full constructor */
	public Space(String spaceId, String spaceState, String spaceType,
			Integer spacePrice, String spaceTel, Set customers, Set reservations) {
		this.spaceId = spaceId;
		this.spaceState = spaceState;
		this.spaceType = spaceType;
		this.spacePrice = spacePrice;
		this.spaceTel = spaceTel;
		this.customers = customers;
		this.reservations = reservations;
	}

	// Property accessors

	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getSpaceState() {
		return this.spaceState;
	}

	public void setSpaceState(String spaceState) {
		this.spaceState = spaceState;
	}

	public String getSpaceType() {
		return this.spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public Integer getSpacePrice() {
		return this.spacePrice;
	}

	public void setSpacePrice(Integer spacePrice) {
		this.spacePrice = spacePrice;
	}

	public String getSpaceTel() {
		return this.spaceTel;
	}

	public void setSpaceTel(String spaceTel) {
		this.spaceTel = spaceTel;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getReservations() {
		return this.reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

}