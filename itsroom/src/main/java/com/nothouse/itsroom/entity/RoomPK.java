package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table( name = "ROOM" )
public class RoomPK implements Serializable {
	
	@Column( name = "JIBUN" )
	private String jibun;      
	
	@Column( name = "ROOM_NAME" )
	private String roomName;

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
	
	

}
