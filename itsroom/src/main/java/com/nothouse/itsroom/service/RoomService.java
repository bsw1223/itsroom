package com.nothouse.itsroom.service;

import java.util.List;

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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리

	@Autowired
	RoomRepository roomRepository;
	
	//ROOM테이블 INSERT
    public void createRoom(RoomPK roomPK) {
		//ROOM테이블 INSERT
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		tx.begin();                                           //트랜젝션 시작
				
		Room room     = new Room();     //room entity      
		room.setRoomPK(roomPK);         //PK SET

		em.persist(room);
		tx.commit();  //트랜젝션 닫기
		em.close();   //엔티티매니저 닫기
//		emf.close();  //엔티티매니저 팩토리 닫기
//        System.out.println("roomRepository :::: "+roomRepository.findByJibunAndRoomName(roomPK));	
        
    }
  //ROOM테이블 select
    public Room selectRoom(RoomPK roomPK) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		tx.begin();     
        
		Room room = roomRepository.findByPK(roomPK);
        
//		em.persist(room);
		
		tx.commit();  //트랜젝션 닫기
		em.close();   //엔티티매니저 닫기
//		emf.close();  //엔티티매니저 팩토리 닫기
		
        return room;
    
    }
    //ROOM테이블 select
    public List<Room> selectRoomList(String getRoomName) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리
    	EntityManager em         = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx     = em.getTransaction();       //트랜젝션
    	tx.begin();     
    	
    	List<Room> roomList = roomRepository.findByroomName(getRoomName);
    	
//		em.persist(room);
    	
    	tx.commit();  //트랜젝션 닫기
    	em.close();   //엔티티매니저 닫기
    	emf.close();  //엔티티매니저 팩토리 닫기
    	
    	return roomList;
    	
    }
    
}
