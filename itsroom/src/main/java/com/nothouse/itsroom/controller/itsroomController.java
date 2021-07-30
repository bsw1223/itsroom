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
        roomPK.setJibun("������34");
        roomPK.setRoomName("�߾�������");
        roomService.createRoom(roomPK);                //room save
        
        Room selRoom = roomService.selectRoom(roomPK); //����Ʈ room
        System.out.println("selRoom getJibun    :::   " + selRoom.getJibun()   .toString());
        System.out.println("selRoom getRoomName :::   " + selRoom.getRoomName().toString());
        
        List<Room> listRoom = roomService.selectRoomList(selRoom.getRoomName().toString()); //���̸����� ����Ʈ �˻�
        
        System.out.println("listRoom size ::: " + listRoom.size());
        for(int i = 0; i < listRoom.size(); i++) {
            System.out.println("selRoomList :::   " + listRoom.get(i).getRoomName().toString());
        }
        
        String getJibun    = selRoom.getJibun()   .toString();
        String getRoomName = selRoom.getRoomName().toString();
        
        model.addAttribute("data",getRoomName);
		return "itsroom";
	}
}

