package com.example.demo.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
    public static String getImageBase64String(String path){
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
    public static boolean saveImage(String imageString,String outputPath){

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
}
