package com.ch.ch6_4.entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "article_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Article  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//标题
	@NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50) 
    private String title;
	//文章内容
    @Lob  //大对象，映射 为MySQL的Long文本类型
    @Basic(fetch = FetchType.LAZY) 
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false) 
    private String content;
    //所属作者，文章与作者是多对一的关系
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="id_author_id")//设置在article表中的关联字段(外键)
    @JsonIgnore
    private Author author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
