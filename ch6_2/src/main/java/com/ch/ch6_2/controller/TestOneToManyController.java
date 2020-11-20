package com.ch.ch6_2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_2.entity.Article;
import com.ch.ch6_2.entity.Author;
import com.ch.ch6_2.service.AuthorAndArticleService;
@RestController
public class TestOneToManyController {
	@Autowired 
	private AuthorAndArticleService authorAndArticleService;
	@RequestMapping("/saveOneToMany")
	public String save() {
		authorAndArticleService.saveAll();
		return "作者和文章保存成功！";
	}
	@RequestMapping("/findArticleByAuthor_id")
	public List<Article> findByAuthor_id(Integer id) {
		return authorAndArticleService.findByAuthor_id(id);
	}
	@RequestMapping("/findArticleByAuthor_aname")
	public List<Article> findByAuthor_aname(String aname){
		return authorAndArticleService.findByAuthor_aname(aname);
	}
	@RequestMapping("/findByArticleList_titleContaining")
	public Author findByArticleList_titleContaining(String title) {
		return authorAndArticleService.findByArticleList_titleContaining(title);
	}
	@RequestMapping("/findAuthorByArticleListtitleContaining")
	public Author findAuthorByArticleListtitleContaining(String title) {
		return authorAndArticleService.findAuthorByArticleListtitleContaining(title);
	}
}
