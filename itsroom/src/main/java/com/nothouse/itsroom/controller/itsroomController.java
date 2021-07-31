package com.nothouse.itsroom.controller;

import java.util.List;

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
        roomPK.setJibun("¡§∏™∑Œ36");
        roomPK.setRoomName("¡ﬂæ”«œ¿Ã√˜");
        roomService.createRoom(roomPK);                //room save
        
        Room selRoom = roomService.selectRoom(roomPK); //ºø∑∫∆Æ room
        System.out.println("selRoom getJibun    :::   " + selRoom.getJibun().toString());
        System.out.println("selRoom getRoomName :::   " + selRoom.getRoomName().toString());
        
        List<Room> listRoom = roomService.selByRoomName(selRoom.getRoomName().toString()); //∑Î¿Ã∏ß¿∏∑Œ ∏ÆΩ∫∆Æ ºø∑∫∆Æ
        
        System.out.println("listRoom size ::: " + listRoom.size());
        for(int i = 0; i < listRoom.size(); i++) {
            System.out.println("selRoomList getRoomName:::   " + listRoom.get(i).getRoomName().toString());
            System.out.println("selRoomList getJibun   :::   " + listRoom.get(i).getJibun().toString());
        }
        
        String getJibun    = selRoom.getJibun()   .toString();
        String getRoomName = selRoom.getRoomName().toString();
        
        model.addAttribute("data",getRoomName);
		return "itsroom";
	}

	@GetMapping("itsroom2")
	public String itsroom2(Model model) {
		return "itsroom2";
	}
}

