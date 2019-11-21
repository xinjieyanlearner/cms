package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.extend.PrivilegeTree;
import com.briup.apps.cms.utils.CustomerException;

public interface IBasePrivlegeService {
	List<BasePrivilege> findAll();
	
	List<BasePrivilege> findByParentId(Long parentId);
	
	void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException;
	
	
	List<PrivilegeTree> findPrivilegeTree();
	
	
	
}
