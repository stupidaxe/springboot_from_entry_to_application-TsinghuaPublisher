package com.ch.ch6_3.repository;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ch.ch6_3.entity.Article;
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	/**
	 * 根据作者id查询文章信息（标题和内容）
	 */
	@Query("select new Map(a.title as title, a.content as content) from Article a where a.author.id = ?1 ")
	public List<Map<String, Object>> findTitleAndContentByAuthorId(Integer id);
	/**
	 * 根据作者名和作者id查询文章信息
	 */
	@Query("select a from Article a where a.author.aname = :aname1 and a.author.id = :id1 ")
	public List<Article> findArticleByAuthorAnameAndId(@Param("aname1") String aname, @Param("id1") Integer id);
	
}
