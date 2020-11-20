package com.ch.ch6_3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.ch.ch6_3.entity.Author;
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	/**
	 * 根据文章标题包含的内容，查询作者（关联查询）
	 */
	@Query("select a from Author a  inner join  a.articleList t where t.title like %?1%" )
	public Author findAuthorByArticleListtitleContaining(String title);
	/**
	 * 根据作者id删除作者
	 */
	@Modifying
	@Query("delete from Author a where a.id = ?1")
	public int deleteAuthorByAuthorId(int id);
}
