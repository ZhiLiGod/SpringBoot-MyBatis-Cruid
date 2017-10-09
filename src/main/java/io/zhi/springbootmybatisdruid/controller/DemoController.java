package io.zhi.springbootmybatisdruid.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest req){
		req.setAttribute("hello", "你好");
		return "index";
	}
	
}
