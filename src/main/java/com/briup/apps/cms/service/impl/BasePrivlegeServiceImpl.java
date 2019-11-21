package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BasePrivilegeExample;
import com.briup.apps.cms.bean.extend.PrivilegeTree;
import com.briup.apps.cms.dao.BasePrivilegeMapper;
import com.briup.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.briup.apps.cms.service.IBasePrivlegeService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class BasePrivlegeServiceImpl implements IBasePrivlegeService{
	@Resource
	private BasePrivilegeMapper basePrivilegeMapper;
	@Resource
	private BasePrivilegeExtendMapper basePrivilegeExtendMapper;
	@Override
	public List<BasePrivilege> findAll() {
		
		return basePrivilegeMapper.selectByExample(new BasePrivilegeExample());
	}

	@Override
	public List<BasePrivilege> findByParentId(Long parentId) {
		 BasePrivilegeExample example = new BasePrivilegeExample();
		 if(parentId==null) {
			 //如果为空的话查询的是一级栏目
			 example.createCriteria().andParentIdIsNull();
		 }else {
			 //如果不为空的话查询的是二级栏目
			 example.createCriteria().andParentIdEqualTo(parentId);
		 }
		return basePrivilegeMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException {
		if(basePrivilege.getId() ==null) {
			basePrivilegeMapper.insert(basePrivilege);
		}else {
			basePrivilegeMapper.updateByPrimaryKeySelective(basePrivilege);
		}
		
	}

	@Override
	public List<PrivilegeTree> findPrivilegeTree() {
		
		return basePrivilegeExtendMapper.findAll();
	}
	
}
