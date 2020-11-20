package com.ch.ch6_4.repository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ch.ch6_4.entity.Author;
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	/**
	 * 查询作者名含有name的作者列表，并排序
	 */
	List<Author> findByAnameContaining(String aname, Sort sort);
}
