package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.BaseUserExample;
import com.briup.apps.cms.bean.BaseUserRole;
import com.briup.apps.cms.bean.BaseUserRoleExample;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.dao.BaseUserMapper;
import com.briup.apps.cms.dao.BaseUserRoleMapper;
import com.briup.apps.cms.dao.extend.BaseUserExtendMapper;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class BaseUserServiceImpl implements IBaseUserService{
	@Resource
	private BaseUserMapper baseUserMapper;
	@Resource
	private BaseUserExtendMapper baseUserExtendMapper;
	@Resource
	private BaseUserRoleMapper baseUserRoleMapper;
	@Override
	public List<BaseUser> findByAll() {
		
		return baseUserMapper.selectByExample(new BaseUserExample());
	}
	@Override
	public List<BaseUserExtend> cascadeRoleFindAll() {
		
		return baseUserExtendMapper.selectAll();
	}
	@Override
	public BaseUserExtend findById(long id) {
		
		return baseUserExtendMapper.selectById(id);
	}
	@Override
	public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
		if(baseUser.getId()!=null) {
			baseUserMapper.updateByPrimaryKey(baseUser);
			
		}else {
			// 判断用户名是否被占用
            BaseUserExample example = new BaseUserExample();
            example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
            List<BaseUser> list = baseUserMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化
            baseUser.setRegisterTime(new Date().getTime());
            baseUser.setStatus(BaseUserExtend.STATUS_NORMAL);
            baseUserMapper.insert(baseUser);
        }
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		BaseUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        baseUserMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public void changeStatus(long id, String status) throws CustomerException {
		BaseUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        baseUserMapper.updateByPrimaryKey(user);
		
	}
	@Override
	public void setRoles(long id, List<Long> roles) {
		//根据userId查询自己的角色
		BaseUserRoleExample example = new BaseUserRoleExample();
		example.createCriteria().andUserIdEqualTo(id);
		//获取老的角色
		List<BaseUserRole> list = baseUserRoleMapper.selectByExample(example);
		List<Long> oldRoles =new ArrayList<Long>();
		Iterator<BaseUserRole> iterator = list.iterator();
		while (iterator.hasNext()) {
			oldRoles.add(iterator.next().getRoleId());
		}
		/*
		 * [1,2,3]->[3,4] 添加1,2 => [1,2,3,4] 
		 * 依次判断新角色是否存在于list中，如果不存在则添加
		 */
		for (Long roleId : roles) {
			if(!oldRoles.contains(roleId)) {
				BaseUserRole userRole = new BaseUserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(id);
				baseUserRoleMapper.insert(userRole);
			}
		}
		/*
		 * [1,2,3]->[1,2,3,4] 删除1,2 => [3,4] 
		 * 依次判断老的角色是否存在与roles，如果不存在，则删除
		 * 
		 */
		for (BaseUserRole userRole:list) {
			if(!roles.contains(userRole.getRoleId())) {
				//根据主键id 删除
				baseUserRoleMapper.deleteByPrimaryKey(userRole.getId());
			}
			
		}
	
	}
	
}
