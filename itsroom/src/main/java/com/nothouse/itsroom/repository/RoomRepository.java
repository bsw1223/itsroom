package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface RoomRepository extends CrudRepository<Room, Long>{
	
	void save(RoomPK roomPK);                       //room ÀúÀå
                                                    
	List<Room> findByRoomName(String getRoomName);  //Áö¹øÀ¸·Î roomlist ¼¿·¢Æ®
	
	List<Room> findByroomName(String roomName);     //roomNameÀ¸·Î roomlist ¼¿·¢Æ®

	@Query("select r from Room r where roomPK=:roomPK")
	Room findByPK(@Param("roomPK") RoomPK roomPK);  //pk·Î room ¼¿·¢Æ®

	


}
