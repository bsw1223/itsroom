package com.nothouse.itsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;

public interface RoomRepository extends CrudRepository<Room, Long>{
	
	void save(RoomPK roomPK);                       //room 저장
                                                    
	List<Room> findByJibun(String jibun);           //지번으로 roolist 셀랙트
	
	List<Room> findByroomName(String roomName);     //지번으로 roolist 셀랙트

	@Query("select r from Room r where roomPK=:roomPK")
	Room findByPK(@Param("roomPK") RoomPK roomPK);  //pk로 room 셀랙트

	


}
