package io.zhi.springbootmybatisdruid.controller;

import io.zhi.springbootmybatisdruid.pojo.User;
import io.zhi.springbootmybatisdruid.service.UserService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/add")
	public String addUser(Model model) throws Exception{
		String id = UUID.randomUUID().toString().replace("-", "");
		String name = "lisi";
		int age = 20;
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		userService.inserUser(user);
		model.addAttribute("user", user);
		return "/user";
	}
	
	@RequestMapping("/all")
	public String findUsers(Model model) throws Exception{
		List<User> users = userService.findUsers();
		model.addAttribute("users", users);
		return "/all";
	}
	
	@RequestMapping("/user/{name}")
	public String findUserByName(Model model, @PathVariable("name") String username) throws Exception{
		User user = userService.findUserByName("tom");
		model.addAttribute("user", user);
		return "/user";
	}
	
	@RequestMapping("/users/{pageNo}")
	public String findAll(Model model, @PathVariable("pageNo") String pageNo) throws Exception{
		
		PageInfo<User> users = userService.findAll(Integer.parseInt(pageNo), 5);
		System.out.println(users);
		model.addAttribute("users", users);
		return "/users";
	}
	
}
