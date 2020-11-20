package com.ch.ch6_3.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch6_3.entity.Article;
import com.ch.ch6_3.entity.Author;
import com.ch.ch6_3.service.AuthorAndArticleService;
@RestController
public class TestOneToManyController {
	@Autowired 
	private AuthorAndArticleService authorAndArticleService;
	@RequestMapping("/findTitleAndContentByAuthorId")
	public List<Map<String, Object>> findTitleAndContentByAuthorId(Integer id){
		return authorAndArticleService.findTitleAndContentByAuthorId(id);
	}
	@RequestMapping("/findArticleByAuthorAnameAndId")
	public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id){
		return authorAndArticleService.findArticleByAuthorAnameAndId(aname, id);
	}
	@RequestMapping("/findAuthorByArticleListtitleContaining")
	public Author findAuthorByArticleListtitleContaining(String title) {
		return authorAndArticleService.findAuthorByArticleListtitleContaining(title);
	}
	@RequestMapping("/deleteAuthorByAuthorId")
	public int deleteAuthorByAuthorId(int id) {
		return authorAndArticleService.deleteAuthorByAuthorId(id);
	}
}
