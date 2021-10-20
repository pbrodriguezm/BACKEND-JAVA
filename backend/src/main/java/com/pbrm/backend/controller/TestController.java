package com.pbrm.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pbrm.backend.model.User;

@Controller
@RequestMapping("/app")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/test1")
	public ModelAndView user(Model model) {
		User user = new User("testUser", "12345");
		user.setName("pedrito");
		ModelAndView modelandview = new ModelAndView("test1");
		modelandview.addObject("user", user);
		return modelandview;
	}
	


}