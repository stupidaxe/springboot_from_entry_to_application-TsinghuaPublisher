package com.ch.ch6_3.service;
import java.util.List;
import java.util.Map;
import com.ch.ch6_3.entity.Article;
import com.ch.ch6_3.entity.Author;
public interface AuthorAndArticleService {
	public List<Map<String, Object>> findTitleAndContentByAuthorId(Integer id);
	public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id);
	public Author findAuthorByArticleListtitleContaining(String title);
	public int deleteAuthorByAuthorId(int id);
}
