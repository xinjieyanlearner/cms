package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.service.IcategoryService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class CategoryServiceImpl implements IcategoryService{
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAll() {
		 
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdata(Category category) throws CustomerException {
		
		if(category.getId()!=null) {
			categoryMapper.updateByPrimaryKey(category);
		}else {
			//栏目重名，则不能插入
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("栏目不能重名!");
			}else {
			categoryMapper.insert(category);
			}
		}
		
	}

	@Override
	public void deleteById(Long id) throws CustomerException{
		Category category = categoryMapper.selectByPrimaryKey(id);
		if(category==null) {
			throw new CustomerException("栏目不存在!");
		}else {
			categoryMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void batchDelete(Long[] ids) throws CustomerException {
		if(ids.length==0) {
			throw new CustomerException("请选择需要删除的栏目!");
		}else {
			for (Long id : ids) {
				this.deleteById(id);
			}
		}
	}
	 
	

	

}
