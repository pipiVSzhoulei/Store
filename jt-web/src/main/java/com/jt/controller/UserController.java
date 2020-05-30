package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//需要跳转页面
@Controller
@RequestMapping("/user")
public class UserController {
	
	//实现页面跳转  http://www.jt.com/user/register.html
	//				http://www.jt.com/user/login.html
	
	//实现页面通用跳转
	@RequestMapping("/{moduleName}")
	public String register(@PathVariable String moduleName) {
		
		return moduleName;
	}
}
