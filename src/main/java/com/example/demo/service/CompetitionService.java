package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.CompetitionRepository;
import com.example.demo.entity.Competition;
import com.example.demo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;

    public boolean saveCompetitionInfo(Competition competition){
        this.competitionRepository.save(competition);
        return true;
    }
    public String getCompetitionJsonInfoById(Integer id){
        Competition competition=this.competitionRepository.findCompetitionById(id);
        return JSON.toJSONString(competition);//返回json的字符串
    }
    public String getCompetitionImageBase64StringByImagePathInServer(String imagePath){
        //这个路径写的很不靠谱，需要修改
        String basePath="E:\\demo\\src\\main\\resources\\static\\competitionImages\\";
        return FileUtil.getImageBase64String(basePath+imagePath);
    }




}
