package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer teamNumber;//团队编号
    private String teamName;//团队名称
    private Integer numberOfTeamMembers;//团队成员的数量
    private ArrayList<String>memberNames;//团队成员的名称
}
