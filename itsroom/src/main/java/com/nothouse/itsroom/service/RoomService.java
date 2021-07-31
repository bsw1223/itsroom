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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮

	@Autowired
	RoomRepository roomRepository;
	
	//param : RoomPK, ROOM���̺� INSERT
    public void createRoom(RoomPK roomPK) {
		//ROOM���̺� INSERT
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		try {
			tx.begin();                                           //Ʈ������ ����
		    Room room     = new Room();     //room entity      
		    room.setRoomPK(roomPK);         //PK SET
		    em.persist(room);
		    tx.commit();  //Ʈ������ �ݱ�
		}catch (Exception e) {
            System.out.println("createRoom error :::  "+e.getMessage().toString());
		}
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
    }

    //param : RoomPK, ROOM���̺� select
    public Room selectRoom(RoomPK roomPK) {
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
        Room room = new Room();
		try {
        	tx.begin();     
        	room = roomRepository.selRoomByPK(roomPK);
        	tx.commit();  //Ʈ������ �ݱ�
        }catch (Exception e) {
        	System.out.println("selectRoom error :::  "+e.getMessage().toString());
		}
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
		
        return room;
    }
    
    //param : roomName, ROOM���̺� select list
    public List<Room> selByRoomName(String getRoomName) {
    	EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx     = em.getTransaction();       //Ʈ������
    	List<Room> roomList      = null;
    	try {
    	    tx.begin();   //Ʈ������ ����  
    	    roomList = roomRepository.selByRoomName(getRoomName);
    	    tx.commit();  //Ʈ������ �ݱ�
    	}catch (Exception e) {
			System.out.println("selectRoomList error :::  "+e.getMessage().toString());
		}
    	
    	em.close();   //��ƼƼ�Ŵ��� �ݱ�
    	
    	return roomList;
    }
    
    //param : jibun, ROOM���̺� select list
    public List<Room> selByJibun(String jibun) {
    	EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx     = em.getTransaction();       //Ʈ������
    	List<Room> roomList      = null;
    	try {
    		tx.begin();   //Ʈ������ ����  
    		roomList = roomRepository.selByJibun(jibun);
    		tx.commit();  //Ʈ������ �ݱ�
    	}catch (Exception e) {
    		System.out.println("selectRoomList error :::  "+e.getMessage().toString());
    	}
    	
    	em.close();   //��ƼƼ�Ŵ��� �ݱ�
    	
    	return roomList;
    }
    
}
