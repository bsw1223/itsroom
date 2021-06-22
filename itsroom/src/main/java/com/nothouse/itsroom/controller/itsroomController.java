package com.nothouse.itsroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class itsroomController {
	
	@GetMapping("itsroom")
	public String itsroomController() {

		return "itsroom";
	}
}
