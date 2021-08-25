package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "SCRAP" )
public class Scrap implements Serializable {
    
	@Id
	@Column( name = "JIBUN")
    private String jibun;  
	
	@Id
	@Column( name = "ROOM_NAME")
    private String roomName;   
	
	@Id
	@Column( name = "E_MAIL")
	private String eMail;

	@Column( name = "SCRAP_TIME")
    private String scrapTime;  
	
	
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
	public String getScrapTime() {
		return scrapTime;
	}
	public void setScrapTime(String scrapTime) {
		this.scrapTime = scrapTime;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
	
	
}
