package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "ITSROOMUSER" )
public class ItsroomUser implements Serializable {
	
	@EmbeddedId
    private ItsroomUserPK isroomUserPK;
	
	@Column( name = "E_MAIL" ,insertable=false, updatable=false)
    private String eMail;
	
    @Column( name = "CONNECTION_PATH" ,insertable=false, updatable=false )
	private String connectionPath;

	public ItsroomUserPK getIsroomUserPK() {
		return isroomUserPK;
	}

	public void setIsroomUserPK(ItsroomUserPK isroomUserPK) {
		this.isroomUserPK = isroomUserPK;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getConnectionPath() {
		return connectionPath;
	}

	public void setConnectionPath(String connectionPath) {
		this.connectionPath = connectionPath;
	}
    
    
}
