package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User,Integer>,
        CrudRepository<User,Integer>{
    public User findUserById(Integer id);
    public User findUserByNickName(String nickName);
    public User findUserByPassword(String password);
    public int countUsersByNickName(String nickname);
    public int countUsersByPassword(String password);
}
