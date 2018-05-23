package com.example.demo.controller;

import com.example.demo.service.CompetitionService;
import com.example.demo.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
