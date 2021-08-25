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
    private String EMail;  /*eMail로 하면 에러남*/
	
    @Column( name = "CONNECTION_PATH" ,insertable=false, updatable=false )
	private String connectionPath;

	public ItsroomUserPK getIsroomUserPK() {
		return isroomUserPK;
	}

	public void setIsroomUserPK(ItsroomUserPK isroomUserPK) {
		this.isroomUserPK = isroomUserPK;
	}

	public String geteMail() {
		return EMail;
	}

	public void seteMail(String eMail) {
		this.EMail = eMail;
	}

	public String getConnectionPath() {
		return connectionPath;
	}

	public void setConnectionPath(String connectionPath) {
		this.connectionPath = connectionPath;
	}
    
    
}
