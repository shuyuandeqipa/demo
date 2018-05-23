package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String competitionName;
    private String competitionDate;
    private String competitionAbstract;//赛事的简介
    private String competitionImageName;//默认放在数据库的static下面的competitionImages下面
    private Integer competitionAmountOfThumbUp;//赛事的点赞量
    private String competitionSponsor;//赛事的举办方
    private String competitionRewards;//奖励
    private String competitionDemands;//赛事参加的要求

}
