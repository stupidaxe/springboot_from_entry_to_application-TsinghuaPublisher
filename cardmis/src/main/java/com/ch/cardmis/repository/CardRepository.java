package com.ch.cardmis.repository;

import com.ch.cardmis.entity.CardEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {
    //根据用户id查询该用户的名片
    public List<CardEntity>  findByUser_id(Integer id, Sort sort);
}
