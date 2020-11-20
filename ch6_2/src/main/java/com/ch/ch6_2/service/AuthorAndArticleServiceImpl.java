package com.ch.ch6_2.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch6_2.entity.Article;
import com.ch.ch6_2.entity.Author;
import com.ch.ch6_2.repository.ArticleRepository;
import com.ch.ch6_2.repository.AuthorRepository;
@Service
public class AuthorAndArticleServiceImpl implements AuthorAndArticleService{
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public void saveAll() {
		//保存作者（先保存一的一端）
		Author a1 = new Author();
		a1.setAname("陈恒1");
		Author a2 = new Author();
		a2.setAname("陈恒2");
		ArrayList<Author> allAuthor = new ArrayList<Author>();
		allAuthor.add(a1);
		allAuthor.add(a2);
		authorRepository.saveAll(allAuthor);
		//保存文章
		Article at1 = new Article();
		at1.setTitle("JPA的一对多111");
		at1.setContent("其实一对多映射关系很常见111。");
		//设置关系
		at1.setAuthor(a1);
		Article at2 = new Article();
		at2.setTitle("JPA的一对多222");
		at2.setContent("其实一对多映射关系很常见222。");
		//设置关系
		at2.setAuthor(a1);//文章2与文章1作者相同
		Article at3 = new Article();
		at3.setTitle("JPA的一对多333");
		at3.setContent("其实一对多映射关系很常见333。");
		//设置关系
		at3.setAuthor(a2);
		Article at4 = new Article();
		at4.setTitle("JPA的一对多444");
		at4.setContent("其实一对多映射关系很常见444。");
		//设置关系
		at4.setAuthor(a2);//文章3与文章4作者相同
		ArrayList<Article> allAt = new ArrayList<Article>();
		allAt.add(at1);
		allAt.add(at2);
		allAt.add(at3);
		allAt.add(at4);
		articleRepository.saveAll(allAt);
	}
	@Override
	public List<Article> findByAuthor_id(Integer id) {
		return articleRepository.findByAuthor_id(id);
	}
	@Override
	public List<Article> findByAuthor_aname(String aname) {
		return articleRepository.findByAuthor_aname(aname);
	}
	@Override
	public Author findByArticleList_titleContaining(String title) {
		return authorRepository.findByArticleList_titleContaining(title);
	}
	@Override
	public Author findAuthorByArticleListtitleContaining(String title) {
		return authorRepository.findAuthorByArticleListtitleContaining(title);
	}
	

}
