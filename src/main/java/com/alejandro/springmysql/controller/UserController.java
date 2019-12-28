package com.alejandro.springmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alejandro.springmysql.model.User;
import com.alejandro.springmysql.service.IUserService;
import com.alejandro.springmysql.util.paginator.PageRender;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userservice")
	private IUserService userService;
	
	@GetMapping("/")
	public String UserList(@RequestParam(name = "page", defaultValue = "0")int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<User> users = userService.listAllUsers(pageRequest);
		PageRender<User> pageRender = new PageRender<>("/", users);
		model.addAttribute("users", users);
		model.addAttribute("page", pageRender);
		
		return "userlist";
	}
	

}
