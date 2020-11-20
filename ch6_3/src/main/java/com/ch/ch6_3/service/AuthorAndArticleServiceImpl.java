package com.ch.ch6_3.service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ch.ch6_3.entity.Article;
import com.ch.ch6_3.entity.Author;
import com.ch.ch6_3.repository.ArticleRepository;
import com.ch.ch6_3.repository.AuthorRepository;
@Service
@Transactional
public class AuthorAndArticleServiceImpl implements AuthorAndArticleService{
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public List<Map<String, Object>> findTitleAndContentByAuthorId(Integer id) {
		return articleRepository.findTitleAndContentByAuthorId(id);
	}
	@Override
	public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id) {
		return articleRepository.findArticleByAuthorAnameAndId(aname, id);
	}
	@Override
	public Author findAuthorByArticleListtitleContaining(String title) {
		return authorRepository.findAuthorByArticleListtitleContaining(title);
	}
	@Override
	public int deleteAuthorByAuthorId(int id) {
		return authorRepository.deleteAuthorByAuthorId(id);
	}
}
