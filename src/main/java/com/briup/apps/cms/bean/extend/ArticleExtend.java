package com.briup.apps.cms.bean.extend;

import java.util.ArrayList;
import java.util.List;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;


public class ArticleExtend extends Article{
	public static final String STATUS_UNCHECK="未审核";
	public static final String STATUS_CHECK_PASS="审核通过";
	public static final String STATUS_CHECK_NOPASS="审核未通过";
	private Category category;
	
	private List<Comment> comments ;
	public ArticleExtend() {}
	
	public ArticleExtend(Category category, List<Comment> comments) {
		super();
		this.category = category;
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
