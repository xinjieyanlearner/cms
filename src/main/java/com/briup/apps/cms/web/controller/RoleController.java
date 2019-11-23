package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.service.IBaseRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/role")
public class RoleController {
	@Autowired
	public IBaseRoleService baseRoleService;
	@GetMapping(value = "findAll")
	@ApiOperation(value = "查询角色信息")
	public Message findAll(){
        List<BaseRole> list = baseRoleService.findAll();
        return MessageUtil.success(list);
    }
	@ApiOperation(value = "查询所有",notes = "级联权限")
	@GetMapping(value = "cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll(){
        List<BaseRoleExtend> list = baseRoleService.casadePrivlegeFindAll();
        return MessageUtil.success(list);
    }
	 @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
		 System.out.println(id);
        baseRoleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
	@ApiOperation(value ="保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(BaseRole role){
        baseRoleService.saveOrUpdate(role);
        return MessageUtil.success("更新成功");
    }

}
