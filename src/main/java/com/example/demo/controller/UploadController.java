package com.example.demo.controller;

import com.example.demo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class UploadController {
    //可以上传任何需要上传的文件
    //跳转到上传文件的页面
    @GetMapping("/upload")
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
      return "html/uploadFiles";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("fileName") MultipartFile file,
                     @RequestParam("dirName")String dirName) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath ="E:\\demo\\src\\main\\resources\\static\\";
        if(dirName.trim().length()!=0){
            filePath+=dirName.trim()+"\\";
        }
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //返回json
        return "uploadimg success "+"文件名是："+filePath+fileName;
    }
}
