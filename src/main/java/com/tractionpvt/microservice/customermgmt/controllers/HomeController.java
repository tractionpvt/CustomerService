package com.tractionpvt.microservice.customermgmt.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/controller/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("dateAndTime", new Date());
		return "home";
	}
	
}
