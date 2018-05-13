package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getUserNameById(Integer id){
        User user=this.userRepository.findUserById(id);
        return user.getName();
    }
    public String getPasswordById(Integer id){
        User user=this.userRepository.findUserById(id);
        return user.getPassword();
    }
    public String getPasswordByUserNickname(String nickname){
        User user=this.userRepository.findUserByNickName(nickname);
        return user.getPassword();
    }
    public boolean createUser(String email,String nickname,String password){
        User user=new User();
        user.setEmail(email);
        user.setNickName(nickname);
        user.setPassword(password);
        this.userRepository.save(user);//保存到数据库中去
        return true;
    }
    public boolean userHasBeenUsed(String nickname){
      int count=this.userRepository.countUsersByNickName(nickname);
      if(count>0){
          return true;
      }else{
          return false;
      }
    }
    public User saveUser(User user){
       return this.userRepository.save(user);
    }


}
