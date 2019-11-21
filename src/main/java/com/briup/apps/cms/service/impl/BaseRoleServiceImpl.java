package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.BaseRoleExample;
import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.BaseUserExample;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.dao.BaseRoleMapper;
import com.briup.apps.cms.dao.extend.BaseRoleExtendMapper;
import com.briup.apps.cms.service.IBaseRoleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class BaseRoleServiceImpl implements IBaseRoleService{
	@Resource
	private BaseRoleMapper baseRoleMapper;
	@Resource
	private BaseRoleExtendMapper baseRoleExtendMapper;

	@Override
	public List<BaseRole> findAll() {
		
		return baseRoleMapper.selectByExample(new BaseRoleExample());
	}

	@Override
	public List<BaseRoleExtend> casadePrivlegeFindAll() {
		List<BaseRoleExtend> selectAll = baseRoleExtendMapper.selectAll();
		return selectAll;
	}

	@Override
	public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
		if(baseRole.getId()!=null) {
			baseRoleMapper.updateByPrimaryKey(baseRole);
			
		}else {
			baseRoleMapper.insert(baseRole);
        }
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		if(baseRoleMapper.selectByPrimaryKey(id)==null) {
			throw new CustomerException("该角色不存在！");
		}else {
			baseRoleMapper.deleteByPrimaryKey(id);
		}
		
	}
	
}
