package com.example.demo;

import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
import com.mysql.jdbc.util.Base64Decoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class CompetitionTest {
    @Autowired
    private CompetitionService service;

    // 开发中禁止把图片存放到数据库中去
    public String readImage(String path){
        File file = new File(path);
        FileInputStream fis;
        byte[] data=null;
        try {
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
           data = temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64Encoder=new BASE64Encoder();
        return base64Encoder.encode(data);
    }
    public boolean saveImage(String imageString,String outputPath){

        //对字节数组字符串进行Base64解码并生成图片
        if (imageString == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imageString);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //保存图片
            OutputStream out = new FileOutputStream(outputPath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    @Test
    public void testSave(){
        Competition competition=new Competition();
        competition.setCompetitionName("大家来编程");
        competition.setCompetitionAbstract("一场毫无节操的编程大赛");
        competition.setCompetitionImageName("wjx2.jpg");
        competition.setCompetitionAmountOfThumbUp(100);
        this.service.saveCompetitionInfo(competition);
    }

    @Test
    public void testGetJson(){
      String s=  this.service.getCompetitionJsonInfoById(1);
        System.out.println(s);
    }
    @Test
    public void getImage(){
        String imageString=readImage("E:\\demo\\src\\main\\resources\\static\\wjx.jpg");
        saveImage(imageString,"E:\\demo\\src\\main\\resources\\static\\wjx2.jpg");
    }

    @Test
    public void testService(){
        String s=this.service.getCompetitionImageBase64StringByImagePathInServer("wjx2.jpg");
        System.out.println(s);

    }

}
