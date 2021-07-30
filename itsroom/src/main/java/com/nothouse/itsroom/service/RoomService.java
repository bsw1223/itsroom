package com.nothouse.itsroom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;
import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;
import com.nothouse.itsroom.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	
    public void createRoom(RoomPK roomPK) {

//        roomRepository.save(roomPK);    
        System.out.println("roomRepository :::: "+roomRepository.findByJibunAndRoomName(roomPK));	
        
    }
    
    
    
    
}
