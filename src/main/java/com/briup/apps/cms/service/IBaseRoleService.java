package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IBaseRoleService {
	// 查询所有角色
	List<BaseRole> findAll();
	//级联查询出所有角色以及权限
	List<BaseRoleExtend> casadePrivlegeFindAll();
	//保存或更改角色信息
	void saveOrUpdate(BaseRole baseRole) throws CustomerException;
	//通过id删除角色信息
	void deleteById(long id) throws CustomerException;
}


