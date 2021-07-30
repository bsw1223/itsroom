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
		//ROOM테이블 INSERT 예시
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		tx.begin();                                           //트랜젝션 시작
				
		Room room     = new Room();     //room entity      
		RoomPK roomPK = new RoomPK();   //roomPK
		
		roomPK.setJibun("정릉로");         
		roomPK.setRoomName("중앙하이츠");    
		room.setRoomPK(roomPK);         //PK SET

		em.persist(room);
		
		tx.commit();  //트랜젝션 닫기
		em.close();   //엔티티매니저 닫기
		emf.close();  //엔티티매니저 팩토리 닫기
		
        model.addAttribute("data","itsroom");
		return "itsroom";
	}
}
