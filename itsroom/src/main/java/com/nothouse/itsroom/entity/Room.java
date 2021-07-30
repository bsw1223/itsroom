package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ROOM" )
public class Room implements Serializable {

	@EmbeddedId
	private RoomPK roomPK;
	
	@Column( name = "JIBUN" ,insertable=false, updatable=false)
	private String jibun;      
	
	@Column( name = "ROOM_NAME" ,insertable=false, updatable=false )
	private String roomName;  
	
	@Column( name = "SCRAP_COUNT" )
	private String scrapCount;
	
	@Column( name = "BUILD_YEAR" )
	private String buildYear;

    	
	public RoomPK getRoomPK() {
		return roomPK;
	}

	public void setRoomPK(RoomPK roomPK) {
		this.roomPK = roomPK;
	}

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

	public String getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(String scrapCount) {
		this.scrapCount = scrapCount;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	} 

}
