package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "administer")
public class Administer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String administerAccount;//管理员账号
    private String administerPassword;//管理员密码
    private String administerName;//管理员姓名

}
