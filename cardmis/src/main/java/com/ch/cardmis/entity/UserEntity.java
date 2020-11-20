package com.ch.cardmis.entity;
import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "user_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class UserEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//主键
    private String uname;
    private String upwd;
    //名片列表，用户与名片是一对多的关系
    @OneToMany(
            mappedBy = "user",
            cascade=CascadeType.ALL,
            targetEntity = CardEntity.class,
            fetch=FetchType.LAZY
    )
    private List<CardEntity> cardEntityList;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public List<CardEntity> getCardEntityList() {
        return cardEntityList;
    }

    public void setCardEntityList(List<CardEntity> cardEntityList) {
        this.cardEntityList = cardEntityList;
    }
}
