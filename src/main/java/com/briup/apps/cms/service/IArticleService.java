package com.briup.apps.cms.service;

import java.util.List;



import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {
	
	  //查询出所有文章信息 
	  List<Article> findAll();
	  
	  //级联查询栏目跟评论 
	  List<ArticleExtend> findArticleAndComments();
	  
	  //根据id查
	  ArticleExtend finById(Long id);
	  
	  //保存或更新
	  void saveAndUpdate(Article articel) throws CustomerException;
	  
	  //删除
	  void deleteByid(Long id) throws CustomerException;
	  
	  
	  
}
