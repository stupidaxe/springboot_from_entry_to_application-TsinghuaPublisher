package com.ch.ch6_4.service;
import java.util.List;
import org.springframework.ui.Model;
import com.ch.ch6_4.entity.Author;
public interface ArticleAndAuthorService {
	/**
	 * name代表作者名的一部分（模糊查询），sortColum代表排序列
	 */
	List<Author> findByAnameContaining(String aname,  String sortColum);
	/**
	 * 分页查询作者，page代表第几页
	 */
	public String findAllAuthorByPage(Integer page, Model model);
}
