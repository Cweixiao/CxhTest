package com.es.es_server4.util;


import org.apache.tomcat.util.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 * ，MD5是通过哈希算法，将字符串转化成一种密文，并且从算法角度是无法通过密文进行反推的，因此不能称之为加密算法，因为无法解密，所以具有安全性
 * ，但是相同字符串经过加密得到的密文是相同的，所以为了防止有人使用穷举法，将明文试了出来
 * ，则需要在明文后加一段复杂的字符串(盐值)，用于大幅增加被试出来的难度
 */
public class MD5Util {

    public static final String SALT = "BZYk/Y5UVn5kmdnt3ZZW5w";    //加密盐值   Aniu(->)love(<-)Xiaotu 的MD5

    public static String getMD5Str(String srcValue) throws NoSuchAlgorithmException {

        //构造一个MD5加密实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //执行加密需将String转为byte,,结果转为Base64格式便于存储
        String desValue = Base64.encodeBase64String(md5.digest((srcValue + SALT).getBytes()));

        return desValue;
    }

    /**
     * 测试MD5加密的效果
     */
//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        System.out.println(getMD5Str("12345"));
//    }

}
