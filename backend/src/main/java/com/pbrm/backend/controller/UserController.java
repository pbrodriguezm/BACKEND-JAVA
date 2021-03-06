package com.pbrm.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pbrm.backend.component.TestComponent;
import com.pbrm.backend.model.User;
import com.pbrm.backend.service.TestService;

/**
 * Patrick Rodriguez
 * */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final String MODEL_USER_VIEW="test2";
	
	@Autowired //indica que vamos a usar un componente de su memoria
	@Qualifier("testComponent") //nombre del bean de su memoria
	private TestComponent testComponent;
	
	@Autowired
	@Qualifier("testService")
	private TestService testservice;
	

	@GetMapping("/test2")
	public ModelAndView users(Model model) {
		ModelAndView modelandview = new ModelAndView(MODEL_USER_VIEW);
		modelandview.addObject("users", testservice.getUsers());
		return modelandview;
	}

	
	
	/**
	 * REQUEST ANTES Y DESPUES
	 * */
	
	@GetMapping("/request")
	public ModelAndView userreques(Model model) {
		ModelAndView modelandview = new ModelAndView(MODEL_USER_VIEW);
		modelandview.addObject("users", testservice.getUsers());
		return modelandview;
	}

	
	/*
	 * GET list Value
	 * http://localhost:8080/user/list?username=User
	 */
	
	@GetMapping("/list")
	public ModelAndView users(@RequestParam("username") String username) {
		testComponent.test();
		ModelAndView modelandview = new ModelAndView(MODEL_USER_VIEW);
		List<User> userfilter = testservice.getUsers()
								.stream()
								.filter(data -> data.getUser().equals(username))
								.collect(Collectors.toList());
		modelandview.addObject("userslist", userfilter);
				
		return modelandview;
	}
	
	/*
	 * GET list Value of password
	 * http://localhost:8080/user/listbypass/password
	 */

	@GetMapping("/listbypass/{password}")
	public ModelAndView usersbypass(@PathVariable("password") String username) {
		ModelAndView modelandview = new ModelAndView(MODEL_USER_VIEW);
		List<User> userfilter = testservice.getUsers()
								.stream()
								.filter(data -> data.getPassword().equals(username))
								.collect(Collectors.toList());
		modelandview.addObject("users", userfilter);
				
		return modelandview;
	}
	
	
	@GetMapping("/newuser")
	public String formnewuser(Model model) {
		model.addAttribute("user", new User());
		return MODEL_USER_VIEW;
	}

	@PostMapping("/adduser")
	public RedirectView adduser(@ModelAttribute("user") User user) {
		return new RedirectView(MODEL_USER_VIEW);
	}
	

}
