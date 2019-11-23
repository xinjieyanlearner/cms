package com.briup.apps.cms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.Uservm;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserContraller {
	@Autowired
	private IBaseUserService baseUserService;
	@ApiOperation(value = "登录成功之后返回一个token")
	@PostMapping("login")
	public Message login(@ RequestBody Uservm userVm) {
		System.out.println(userVm.getUsername());
		System.out.println(userVm.getPassword());
		//1.认证用户的用户名和密码
		//2.如果登录成功产生token，将token缓存起来，返回
		//3.如果登录失败
		Map<String,String> map = new HashMap<String, String>();
		map.put("token", "admin-token");
		return MessageUtil.success(map);
		
		
	}
	@ApiOperation(value = "通过token获取用户的基本信息")
	@GetMapping("info")
	public Message info(String token) {
		//1.通过token获取用户信息,级联查询出用户的角色
		System.out.println("token:"+token);
		 BaseUserExtend baseUserExtend = baseUserService.findById(1);
		return MessageUtil.success(baseUserExtend);
	}
	
	@ApiOperation(value = "通过清除token数据,退出")
	@PostMapping("logout")
	public Message logout() {
		//1.将缓冲中的token移除
		return MessageUtil.success("success");
	}
}
