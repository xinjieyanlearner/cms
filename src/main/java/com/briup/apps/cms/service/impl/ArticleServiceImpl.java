package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;


import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.ArticleExample.Criteria;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;


@Service
public class ArticleServiceImpl implements IArticleService{
	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Override
	public List<Article> findAll() {
		ArticleExample example = new ArticleExample();
		return articleMapper.selectByExample(example);
	}
	
	@Override
	public List<ArticleExtend> findArticleAndComments() {
		
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend finById(Long id) {
		return articleExtendMapper.selectById(id);
	}

	@Override
	public void saveAndUpdate(Article articel) throws CustomerException {
		
		if(articel.getId() !=null) {
			articleMapper.updateByPrimaryKey(articel);
		}else {
			/*
			 * 标题名重复的话不能存入
			 * 
			 */
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(articel.getTitle());
			List<Article> listByName = articleMapper.selectByExample(example);
			if(listByName.size()>0) {
				/*
				 * 异常的处理
				 * 自定义异常 运行时异常，不需要调用者try catch
				 */
				//throw new RuntimeException();
				throw new CustomerException("标题不能重复！");
			}
			
			//初始化
			articel.setStatus(ArticleExtend.STATUS_UNCHECK);
			articel.setThumpDown(0l);
			articel.setThumpUp(0l);
			articel.setPublishTime(new Date().getTime());
			articleMapper.insert(articel);
		}
	}

	@Override
	public void deleteByid(Long id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article==null) {
			throw new CustomerException("文章不存在，无法删除！");
		}else {
			articleMapper.deleteByPrimaryKey(id);
		}
	}

	

	
    
	
	

}
