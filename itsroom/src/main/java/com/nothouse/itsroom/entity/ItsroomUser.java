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
}
