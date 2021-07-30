package com.nothouse.itsroom.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;
import com.nothouse.itsroom.service.RoomService;

@Controller
public class itsroomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("itsroom")
	public String itsroomController(Model model) {
		//ROOM���̺� INSERT ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		tx.begin();                                           //Ʈ������ ����
				
		Room room     = new Room();     //room entity      
		RoomPK roomPK = new RoomPK();   //roomPK
		
		roomPK.setJibun("������");         
		roomPK.setRoomName("�߾�������");    
		room.setRoomPK(roomPK);         //PK SET

		em.persist(room);
		
		tx.commit();  //Ʈ������ �ݱ�
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
		emf.close();  //��ƼƼ�Ŵ��� ���丮 �ݱ�
		
        model.addAttribute("data","itsroom");
		return "itsroom";
	}
}
