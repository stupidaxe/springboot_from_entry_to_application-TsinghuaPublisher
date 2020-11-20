package com.ch.ch6_2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_2.entity.Article;
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	/**
	 * 根据作者id查询文章信息（关联查询，根据author属性的id）
	 * 相当于JPQL语句：select a from Article a where a.author.id = ?1
	 */
	public List<Article> findByAuthor_id(Integer id);
	/**
	 * 根据作者名查询文章信息（关联查询，根据author属性的aname）
	 * 相当于JPQL语句：select a from Article a where a.author.aname = ?1
	 */
	public List<Article> findByAuthor_aname(String aname);
}
