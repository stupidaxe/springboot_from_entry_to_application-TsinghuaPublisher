package com.ch.cardmis.repository;

import com.ch.cardmis.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    /**
     * 查询用户名是否已存在
     */
    public UserEntity findByUname(String uname);

    /**
     *登录
     */
    public UserEntity  findByUnameAndUpwd(String uname, String upwd);
}
