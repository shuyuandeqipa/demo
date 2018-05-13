package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Setter
@Getter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //用户的基本信息
    private String name;
    private String sex;
    private String smartPhoneNumber;
    private String nickName; //用户昵称
    private String password;//密码
    private String email;//邮箱
    private String avatar;//用户头像
    private String individualitySignature;//个性签名

    //用户的详细信息
    private String educationBackground;//教育背景：专科，本科，硕士，博士
    private String schoolName;//目前所在院校名称，或者毕业院校
    private String major;//专业
    private Date enrollmentYear;//入学年份
    private Date graduationYear;//毕业年份

    public User(String name, String sex, String smartPhoneNumber, String nickName, String password, String email, String avatar, String individualitySignature, String educationBackground, String schoolName, String major, Date enrollmentYear, Date graduationYear) {
        this.name = name;
        this.sex = sex;
        this.smartPhoneNumber = smartPhoneNumber;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.individualitySignature = individualitySignature;
        this.educationBackground = educationBackground;
        this.schoolName = schoolName;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
    }
}
/**
 *
 *  @Getter和@Setter注解：注解在属性上，会自动在class字节码文件生成getter和setter方法
 @Data注解：注解在类上，会自动在字节码文件中为类所有的属性生成getter和setter方法，
 以及equals，canEquals,hashCode和toString方法
 除了以上介绍的@Getter，@Setter和@Data注解外，还提供如下注解：
 @NonNull：帮助我们避免空指针异常
 @ToString：自动生成toString方法
 @EqualsAndHashCode:自动生成equals和hashCode方法
 @Cleanup：自动帮我们调用close方法
 @Synchronized:自动给方法添加synchronize关键字
 @NoArgsConstructor：自动生成无参数构造函数
 @AllArgsConstructor：自动生成全参数构造函数
 */