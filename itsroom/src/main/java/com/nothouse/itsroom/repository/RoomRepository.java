package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface RoomRepository extends CrudRepository<Room, Long>{
     
	
	List<Room> findByJibun(String jibun);            //지번으로 roomlist 셀랙트
	
	List<Room> findByroomName(String roomName);      //roomName으로 roomlist 셀랙트

	@Query("select r from Room r where roomPK=:roomPK")
	Room findRoom(@Param("roomPK") RoomPK roomPK);  //pk로 room 셀랙트

}
