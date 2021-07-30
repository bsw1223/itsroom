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
        RoomPK roomPK = new RoomPK();
        roomPK.setJibun("Á¤¸ª·Î30");
        roomPK.setRoomName("Áß¾ÓÇÏÀÌÃ÷");
        roomService.createRoom(roomPK); //room ÀúÀå
        
        Room selRoom = roomService.selectRoom(roomPK); //¼¿·ºÆ® room
        System.out.println("selRoom getJibun    :::   " + selRoom.getJibun()   .toString());
        System.out.println("selRoom getRoomName :::   " + selRoom.getRoomName().toString());
        
        String getJibun    = selRoom.getJibun()   .toString();
        String getRoomName = selRoom.getRoomName().toString();
        
        model.addAttribute("data",getRoomName);
		return "itsroom";
	}
}

