
package com.briup.apps.cms.web.controller;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@Api("文章接口")
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	@ApiOperation(value="查询文章信息")
	@GetMapping(value = "findAll")
	public Message findAll() {
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping(value = "findById")
	@ApiOperation(value="根据id查询")
	public Message findById(Long id) {
		//?查出来是集合还是对象
		ArticleExtend articleById = articleService.finById(id);
		return MessageUtil.success(articleById);
	}
	/*
	 * 级联查询 查询article时，级联查询出category跟article下的评论 article跟category 对1 article跟comment
	 * 1对多
	 */
	@ApiOperation(value="级联查询")
	@GetMapping(value = "findArticleAndCategoryAndComments")
	public Message findArticleAndCategoryAndComments() {
		List<ArticleExtend> ArticleAndComments = articleService.findArticleAndComments();
		return MessageUtil.success(ArticleAndComments);
	}
	@ApiOperation(value="保存或更新")
	@PostMapping(value = "saveAndUpdate")
	@ApiImplicitParams({
		@ApiImplicitParam(name="title",value="标题",required = true,paramType ="form"),
		@ApiImplicitParam(name="content",value="内容",required = true,paramType = "form"),
		@ApiImplicitParam(name="source",value="源内容",required = true,paramType = "form"),
		@ApiImplicitParam(name="categoryId",value="栏目i",required = true,paramType = "form"),
		@ApiImplicitParam(name="authorId",value="作者id",required = true,paramType = "form")    
	})
	public Message saveAndUpdate(
			Long id, 
			String title,
			String content,
			String source,
			Long categoryId,
			Long authorId) {
		System.out.println(content);
		System.out.println(title);
		System.out.println(source);
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setAuthorId(authorId);
		article.setCategoryId(categoryId);
		articleService.saveAndUpdate(article);
		return MessageUtil.success("更新成功!");
	}
	@ApiOperation(value="根据id删除")
	@GetMapping("deleteById")
	@ApiImplicitParams(
			@ApiImplicitParam(name="id",value="编号",required = true,paramType = "query")
			)
	public Message deleteByid(Long id) {
		System.out.println(id);
		articleService.deleteByid(id);
		return MessageUtil.success("删除成功！");
		
	}
}
 
