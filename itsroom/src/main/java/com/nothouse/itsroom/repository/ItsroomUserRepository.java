package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;
import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface ItsroomUserRepository extends CrudRepository<ItsroomUser, Long>{
	
	List<ItsroomUser> findByEMail(String eMail);                            //eMail ItsroomUserList 셀랙트
	
	List<ItsroomUser> findByConnectionPath(String connectionPath);              //roomName으로 ItsroomUserList 셀랙트

	@Query("select r from ItsroomUser r where isroomUserPK=:isroomUserPK")
	ItsroomUser finItsroomUser(@Param("isroomUserPK") ItsroomUserPK isroomUserPK); //pk로 ItsroomUser 셀랙트

}
