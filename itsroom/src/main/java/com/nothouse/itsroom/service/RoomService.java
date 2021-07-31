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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮

	@Autowired
	RoomRepository roomRepository;
	
	//ROOM���̺� INSERT
    public void createRoom(RoomPK roomPK) {
		//ROOM���̺� INSERT
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		tx.begin();                                           //Ʈ������ ����
				
		Room room     = new Room();     //room entity      
		room.setRoomPK(roomPK);         //PK SET

		em.persist(room);
		tx.commit();  //Ʈ������ �ݱ�
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
//		emf.close();  //��ƼƼ�Ŵ��� ���丮 �ݱ�
//        System.out.println("roomRepository :::: "+roomRepository.findByJibunAndRoomName(roomPK));	
        
    }
  //ROOM���̺� select
    public Room selectRoom(RoomPK roomPK) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		tx.begin();     
        
		Room room = roomRepository.findByPK(roomPK);
        
//		em.persist(room);
		
		tx.commit();  //Ʈ������ �ݱ�
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
//		emf.close();  //��ƼƼ�Ŵ��� ���丮 �ݱ�
		
        return room;
    
    }
    //ROOM���̺� select
    public List<Room> selectRoomList(String getRoomName) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮
    	EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx     = em.getTransaction();       //Ʈ������
    	tx.begin();     
    	
    	List<Room> roomList = roomRepository.findByroomName(getRoomName);
    	
//		em.persist(room);
    	
    	tx.commit();  //Ʈ������ �ݱ�
    	em.close();   //��ƼƼ�Ŵ��� �ݱ�
    	emf.close();  //��ƼƼ�Ŵ��� ���丮 �ݱ�
    	
    	return roomList;
    	
    }
    
}
