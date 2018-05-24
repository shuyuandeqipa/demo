package com.example.demo.controller;

import com.example.demo.config.ApplicationConfig;
import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
import com.example.demo.utils.FileUtil;
import com.example.demo.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Controller
@Slf4j
public class CompetitionController {
    @Autowired
    private CompetitionService service;
    @ResponseBody
    @GetMapping("/competitionInfo")//返回一个赛事的json信息
    public String competitionInfo(@RequestParam(value = "id",defaultValue = "0")Integer id) {
      return this.service.getCompetitionJsonInfoById(id);
    }
    @ResponseBody
    @GetMapping("/competitionImage")//返回的是图片的base64编码，在Android端解析一下就可以了
    public String competitionImage(@RequestParam(value = "competitionImageName",defaultValue = "")String competitionImageName){
        return this.service.getCompetitionImageBase64StringByImagePathInServer(competitionImageName);
    }

    @ResponseBody
    @PostMapping("/uploadCompetitionInfo")
    public boolean uploadCompetitionInfo( @RequestParam(value = "competitionName",defaultValue = "")String competitionName,
                                         @RequestParam(value = "competitionDate",defaultValue = "")String competitionDate,
                                         @RequestParam(value = "competitionAbstract",defaultValue = "")String competitionAbstract,
                                         @RequestParam(value = "competitionImageName",defaultValue = "")String competitionImageName ,
                                         @RequestParam(value = "competitionImageBase64String",defaultValue = "")String competitionImageBase64String,
                                         @RequestParam(value = "competitionSponsor",defaultValue = "")String competitionSponsor,
                                         @RequestParam(value = "competitionRewards",defaultValue = "")String competitionRewards,
                                        @RequestParam(value = "competitionDemands",defaultValue = "")String competitionDemands) {
        Competition competition=new Competition();
        competition.setCompetitionName(competitionName);
        String[]dateParse=competitionDate.split("-");
        competition.setCompetitionDate(new Date(Integer.parseInt(dateParse[0])-1900,Integer.parseInt(dateParse[1])-1,Integer.parseInt(dateParse[2])));
        competition.setCompetitionAbstract(competitionAbstract);
        competition.setCompetitionImageName(competitionImageName);
        competition.setCompetitionSponsor(competitionSponsor);
        competition.setCompetitionRewards(competitionRewards);
        competition.setCompetitionDemands(competitionDemands);
       boolean isok=this.service.saveCompetitionInfo(competition);
       //把图片保存到指定的文件夹中
        String savePath= ApplicationConfig.competitionImageSavePath;
        //保存图片
//        String base64Image=FileUtil.getImageBase64String(savePath+"wjx2.jpg");
        //这里可以正常，正确的使用
       boolean saveSuccess= FileUtil.saveImage(competitionImageBase64String,savePath+competitionImageName);
       if(isok==true &&saveSuccess==true){
           return true;
       }else{
           return false;
       }
}
}
