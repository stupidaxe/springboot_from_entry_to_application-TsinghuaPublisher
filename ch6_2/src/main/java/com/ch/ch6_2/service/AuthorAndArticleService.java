package com.ch.ch6_2.service;
import java.util.List;
import com.ch.ch6_2.entity.Article;
import com.ch.ch6_2.entity.Author;
public interface AuthorAndArticleService {
	public void saveAll();
	public List<Article> findByAuthor_id(Integer id);
	public List<Article> findByAuthor_aname(String aname);
	public Author findByArticleList_titleContaining(String title);
	public Author findAuthorByArticleListtitleContaining(String title);
}
