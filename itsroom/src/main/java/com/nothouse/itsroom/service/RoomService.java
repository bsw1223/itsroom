package com.nothouse.itsroom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;
import com.nothouse.itsroom.repository.RoomRepository;

@Service
public class RoomService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리

	@Autowired
	RoomRepository roomRepository;
	
	//param : RoomPK, ROOM테이블 INSERT
    public void createRoom(RoomPK roomPK) {
		//ROOM테이블 INSERT
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		try {
			tx.begin();                                           //트랜젝션 시작
		    Room room     = new Room();     //room entity      
		    room.setRoomPK(roomPK);         //PK SET
		    em.persist(room);
		    tx.commit();  //트랜젝션 닫기
		}catch (Exception e) {
            System.out.println("createRoom error :::  "+e.getMessage().toString());
		}
		em.close();   //엔티티매니저 닫기
    }

    //param : RoomPK, ROOM테이블 select
    public Room selectRoom(RoomPK roomPK) {
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
        Room room = new Room();
		try {
        	tx.begin();     
        	room = roomRepository.findRoom(roomPK);
        	tx.commit();  //트랜젝션 닫기
        }catch (Exception e) {
        	System.out.println("selectRoom error :::  "+e.getMessage().toString());
		}
		em.close();   //엔티티매니저 닫기
		
        return room;
    }
    
    //param : roomName, ROOM테이블 select list
    public List<Room> selByRoomName(String getRoomName) {
    	EntityManager em         = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx     = em.getTransaction();       //트랜젝션
    	List<Room> roomList      = null;
    	try {
    	    tx.begin();   //트랜젝션 시작  
    	    roomList = roomRepository.findByroomName(getRoomName);
    	    tx.commit();  //트랜젝션 닫기
    	}catch (Exception e) {
			System.out.println("selectRoomList error :::  "+e.getMessage().toString());
		}
    	
    	em.close();   //엔티티매니저 닫기
    	
    	return roomList;
    }
    
    //param : jibun, ROOM테이블 select list
    public List<Room> selByJibun(String jibun) {
    	EntityManager em         = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx     = em.getTransaction();       //트랜젝션
    	List<Room> roomList      = null;
    	try {
    		tx.begin();   //트랜젝션 시작  
    		roomList = roomRepository.findByJibun(jibun);
    		tx.commit();  //트랜젝션 닫기
    	}catch (Exception e) {
    		System.out.println("selectRoomList error :::  "+e.getMessage().toString());
    	}
    	
    	em.close();   //엔티티매니저 닫기
    	
    	return roomList;
    }
    
}
