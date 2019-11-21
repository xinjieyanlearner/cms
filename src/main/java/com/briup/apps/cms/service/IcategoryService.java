package com.briup.apps.cms.service;

import java.util.List;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

public interface IcategoryService {
	//查
	List<Category> findAll();
	//保存或修改
	void saveOrUpdata(Category category) throws CustomerException;
	//删除
	void deleteById(Long id);
	//批量删除
	 void batchDelete(Long[] ids) throws CustomerException;
	
}
