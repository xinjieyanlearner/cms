package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.service.IcategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("栏目相关接口")
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private IcategoryService categoryService;
	
	@ApiOperation(value="查询所有栏目信息")
	@GetMapping(value = "findAll")
	public Message findAll() {
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@PostMapping(value = "saveAndUpdate")
	@ApiOperation(value="增加或更新")
	public Message saveOrUpdata(Category category) {
		categoryService.saveOrUpdata(category);
		return MessageUtil.success("更新成功!");
	}
	
	@ApiOperation(value="根据栏目id删除")
	@GetMapping("deleteById")
	@ApiImplicitParams(
			@ApiImplicitParam(name="id",value="编号",required = true,paramType = "query")
			)
	public Message deleteByid(Long id) {
		System.out.println(id);
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功！");
		
	}
	
	@ApiOperation(value="批量删除")
	@PostMapping("batchDelete")
	public Message batchDelete(@RequestBody Long[] ids) {
		System.out.println(ids);
		System.out.println();
		categoryService.batchDelete(ids);
		return MessageUtil.success("删除成功！");
		
	}
}
