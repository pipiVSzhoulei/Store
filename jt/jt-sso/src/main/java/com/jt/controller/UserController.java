package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.service.UserService;
import com.jt.vo.SysResult;

//要求返回的是JSON数据
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getMsg")
	public String getMsg() {
		
		return "单点登陆系统配置成功!!!!";
	}
	
	/**
	 * 根据web中传递的参数,实现数据校验
	 * url:http://sso.jt.com/user/check/{param}/{type}
	 *   参数:param/type
	 *   返回值: SysResult对象
	 * JSONP跨域访问 需要数据的封装
	 */
	@RequestMapping("/check/{param}/{type}")
	public JSONPObject checkUser(@PathVariable String param,
								 @PathVariable Integer type,
								 String callback) {
		
		//查询后台数据库,检查数据是否存在.
		Boolean flag = userService.checkUser(param,type);
		//封装返回值结果
		SysResult sysResult = SysResult.success(flag);
		return new JSONPObject(callback, sysResult);
	}
	
}
