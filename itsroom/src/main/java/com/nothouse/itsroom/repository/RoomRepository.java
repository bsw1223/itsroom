package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface RoomRepository extends CrudRepository<Room, Long>{
                                                    
	List<Room> selByJibun(String jibun);            //�������� roomlist ����Ʈ
	
	List<Room> selByRoomName(String roomName);      //roomName���� roomlist ����Ʈ

	@Query("select r from Room r where roomPK=:roomPK")
	Room selRoomByPK(@Param("roomPK") RoomPK roomPK);  //pk�� room ����Ʈ

}
