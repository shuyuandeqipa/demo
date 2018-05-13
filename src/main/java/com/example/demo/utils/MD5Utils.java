package com.example.demo.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**利用MD5进行加密*/
    public static String encoderByMd5(String str){
        //确定计算方法
        String newString="";
        try{
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newString=base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newString;
        }catch (Exception e){
            e.printStackTrace();
        }
      return newString;
    }


}
