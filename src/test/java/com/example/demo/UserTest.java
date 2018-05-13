package com.example.demo;

import com.example.demo.DemoApplication;
import com.example.demo.controller.UserController;
import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserController controller;

    @Test
    public void testUserHasBeenUsed() {
        String nickname = "wjw";
        System.out.println(this.userRepository.countUsersByNickName(nickname));
    }

    @Test
    public void testUserController() {

        boolean isok = this.controller.fullInfoRegister("9527", "男", "10086",
                "9527", "10086", "1228436902@qq.com", "wjx.jpg",
                "我是最帅的", "硕士", "ZJU", "CS",
                new Date(2019, 9, 1), new Date(2012, 6, 1));
        if (isok == true) {
            System.out.println("register successfully!");
            ;
        } else {
            System.out.println("register fail!");
        }
    }
}
