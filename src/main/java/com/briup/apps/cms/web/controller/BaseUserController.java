package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.BaseUser;

import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/baseUser")
public class BaseUserController {
    @Autowired
    private IBaseUserService baseUserService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<BaseUser> list = baseUserService.findByAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value = "根据id查询")
    @GetMapping(value = "findById")
    public Message findById(Long id){
        BaseUserExtend findById = baseUserService.findById(id);
        return MessageUtil.success(findById);
    }
    @ApiOperation(value = "查询所有",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<BaseUserExtend> list = baseUserService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(BaseUser baseUser){
        baseUserService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
    	System.out.println(id);
        baseUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value = "通过用户id给用户设置角色")
    @PostMapping("setRoles")
    public Message setRoles(long id,List<Long> roles ){
    	baseUserService.setRoles(id, roles);
        return MessageUtil.success("设置成功!");
    }
}
