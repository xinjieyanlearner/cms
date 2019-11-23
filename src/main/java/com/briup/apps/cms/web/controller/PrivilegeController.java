package com.briup.apps.cms.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.extend.PrivilegeTree;
import com.briup.apps.cms.service.IBasePrivlegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	@Autowired
	private IBasePrivlegeService basePrivlegeService;
	@ApiOperation(value="查询所有权限信息")
	@GetMapping(value = "findAll")
	public Message findAll() {
		List<BasePrivilege> findAll = basePrivlegeService.findAll();
		return MessageUtil.success(findAll);
	}
	@PostMapping(value = "saveOrUpdate")
	@ApiOperation(value="增加或更新")
	public Message saveOrUpdate(BasePrivilege basePrivilege) {
		basePrivlegeService.saveOrUpdate(basePrivilege);
		return MessageUtil.success("更新成功 !");
	}
	@ApiOperation(value="根据parentId查")
	@GetMapping(value = "findByParentId")
	public Message findByParentId(Long parentId) {
		System.out.println("parentId："+parentId);
		List<BasePrivilege> findAll = basePrivlegeService.findByParentId(parentId);
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="查询树" )
	@GetMapping(value = "findByPrivilegeTree")
	public Message findByPrivilegeTree() {
		List<PrivilegeTree> findPrivilegeTree = basePrivlegeService.findPrivilegeTree();
		return MessageUtil.success(findPrivilegeTree);
	}
	
}
