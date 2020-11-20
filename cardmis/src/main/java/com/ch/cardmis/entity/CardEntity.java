package com.ch.cardmis.entity;
import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "card_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class CardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键
    private String name;
    private String telephone;
    private String email;
    private String company;
    private String post;
    private String address;
    private String logo;
    //所属用户，名片与用户是多对一的关系
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示用户不能为空。删除名片，不影响用户
    @JoinColumn(name="id_user_id")//设置在card_table表中的关联字段(外键)
    @JsonIgnore
    private UserEntity user;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
