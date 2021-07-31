package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;
import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface ItsroomUserRepository extends CrudRepository<Room, Long>{
	
	List<ItsroomUser> selByEmail(String eMail);                            //eMail ItsroomUserList ºø∑¢∆Æ
	
	List<ItsroomUser> selByConnection(String connectionPath);              //roomName¿∏∑Œ ItsroomUserList ºø∑¢∆Æ

	@Query("select r from ItsroomUser r where isroomUserPK=:isroomUserPK")
	ItsroomUser selItsroomUserByPK(@Param("isroomUserPK") ItsroomUserPK isroomUserPK); //pk∑Œ ItsroomUser ºø∑¢∆Æ

}
