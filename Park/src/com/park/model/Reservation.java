package com.park.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */

public class Reservation implements java.io.Serializable {

	// Fields

	private Timestamp dateTime;
	private Space space;
	private String rname;
	private String rtel;
	private String spaceType;
	private Date arrivalTime;
	private Integer days;

	// Constructors

	/** default constructor */
	public Reservation() {
	}

	/** full constructor */
	public Reservation(Timestamp dateTime, Space space, String rname,
			String rtel, String spaceType, Date arrivalTime, Integer days) {
		this.dateTime = dateTime;
		this.space = space;
		this.rname = rname;
		this.rtel = rtel;
		this.spaceType = spaceType;
		this.arrivalTime = arrivalTime;
		this.days = days;
	}

	// Property accessors

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Space getSpace() {
		return this.space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtel() {
		return this.rtel;
	}

	public void setRtel(String rtel) {
		this.rtel = rtel;
	}

	public String getSpaceType() {
		return this.spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

}