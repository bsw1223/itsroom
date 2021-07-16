package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ROOMSELL" )
public class RoomSell implements Serializable {
    
	@Id
	@Column( name = "JIBUN" )
    private String jibun;           
	
	@Id
	@Column( name = "ROOM_NAME" )
    private String roomName;       
	
	@Id
	@Column( name = "CONTRACT_DATE" )
    private String contractDate;   
	
	@Id
	@Column( name = "DEPOSIT" )
    private String deposit;         
	
	@Id
	@Column( name = "MONTHLY_RENT" )
    private String monthlyRent;    
	
	@Id
	@Column( name = "PRIVATE_AREA" )
    private String privateArea;    
	
	@Id
	@Column( name = "FLOOR" )
    private String floor;

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public String getPrivateArea() {
		return privateArea;
	}

	public void setPrivateArea(String privateArea) {
		this.privateArea = privateArea;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}           
	
	
}
