package com.nothouse.itsroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class itsroomController {
	
	@GetMapping("itsroom")
	public String itsroomController(Model model) {
        model.addAttribute("data","itsroom");
		return "itsroom";
	}
}
