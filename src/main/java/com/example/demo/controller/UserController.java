package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;


@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/simpleRegister")
    public Boolean simpleRegister(@RequestParam(value = "email", defaultValue = "") String email,
                                  @RequestParam(value = "nickname", defaultValue = "") String nickname,
                                  @RequestParam(value = "password", defaultValue = "") String password) {
        if (this.userService.userHasBeenUsed(nickname) == false) {
            String md5Password = MD5Utils.encoderByMd5(password);
            return this.userService.createUser(email, nickname, md5Password);
        } else {
            return false;
        }
    }

    @ResponseBody
    @GetMapping("/fullInfoRegister")
    public Boolean fullInfoRegister(@RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "sex", defaultValue = "") String sex,
                                    @RequestParam(value = "smartPhoneNumber", defaultValue = "") String smartPhoneNumber,
                                    @RequestParam(value = "nickname", defaultValue = "") String nickname,
                                    @RequestParam(value = "password", defaultValue = "") String password,
                                    @RequestParam(value = "email", defaultValue = "") String email,
                                    @RequestParam(value = "avatar", defaultValue = "") String avatar,
                                    @RequestParam(value = "individualSignature", defaultValue = "") String individualSignature,
                                    @RequestParam(value = "educationBackground", defaultValue = "") String educationBackground,
                                    @RequestParam(value = "schoolName", defaultValue = "") String schoolName,
                                    @RequestParam(value = "major", defaultValue = "") String major,
                                    @RequestParam(value = "enrollmentYear", defaultValue = "") Date enrollmentYear,
                                    @RequestParam(value = "graduateYear", defaultValue = "") Date graduateYear) {
        if (this.userService.userHasBeenUsed(nickname) == false) {
            User user = new User(name, sex, smartPhoneNumber, nickname, MD5Utils.encoderByMd5(password), email
                    , avatar, individualSignature, educationBackground,
                    schoolName, major, enrollmentYear, graduateYear);
            if (this.userService.saveUser(user) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    @ResponseBody
    @GetMapping("/login")
    public boolean login(@RequestParam(value = "nickname", defaultValue = "") String nickname,
                         @RequestParam(value = "password",defaultValue = "")String password){
        if(this.userService.userHasBeenUsed(nickname)==true){//有这个nickname
            // 检查密码是否符合
            String md5Password=this.userService.getPasswordByUserNickname(nickname);
            if(md5Password.equals(MD5Utils.encoderByMd5(password))){
                return true;//通过
            }else{
                return false;
            }
        }else{//nickname检查不通过
            return false;
        }
    }

}
