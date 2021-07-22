package com.nothouse.itsroom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table( name = "ITSROOMUSER" )
public class ItsroomUserPK implements Serializable {
	
	@Column( name = "E_MAIL" )
    private String eMail;
	
    @Column( name = "CONNECTION_PATH" )
	private String connectionPath;

}
