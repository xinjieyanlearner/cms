package com.briup.apps.cms.service;

import java.util.List;


import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IBaseUserService {

	//查询所有用户信息
	List<BaseUser> findByAll();
	//级联查询所有
	List<BaseUserExtend> cascadeRoleFindAll();
	//通过id查询
	BaseUserExtend findById(long id);
	// 保存或更新
	void saveOrUpdate(BaseUser baseUser) throws CustomerException;
	//通过id删除
	void deleteById(long id) throws CustomerException;
	//更新状态
	void changeStatus(long id,String status) throws CustomerException;
	//设置角色
	void setRoles(long id, List<Long> roles);
	
}
