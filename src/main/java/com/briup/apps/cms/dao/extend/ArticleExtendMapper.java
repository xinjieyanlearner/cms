package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.extend.ArticleExtend;

public interface ArticleExtendMapper {
	//级联查询
	List<ArticleExtend> selectAll();
	//根据id查
	ArticleExtend selectById(Long id);
	
}
