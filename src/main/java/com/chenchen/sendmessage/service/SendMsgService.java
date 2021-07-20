package com.chenchen.sendmessage.service;

import com.chenchen.sendmessage.domain.SendMsgVo;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/7/139:44
 */
@Service
public class SendMsgService {
    //数字随机常量
    static final String SYMBOLS_code = "0123456789";
    //数字+字母随机常量
    static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random random = new SecureRandom();

    public static void main(String[] args) {

        sendcode(new SendMsgVo());
    }

    public static void  sendcode(SendMsgVo sendMsgVo){
        StringBuffer result = new StringBuffer();//buffer是线程安全的
        //获取6位随机数
        for (int i=0;i<6;i++){
            result.append(random.nextInt(10));
        }
        System.out.println("随机6位数为："+result.toString());
        //获取PC端的验证码,含有字母
        String array = "0192837465asdfghjk";
        StringBuffer flag = new StringBuffer();
        for(int i=0;i<6;i++){
            flag.append(array.charAt(random.nextInt(18))+"");
        }
        System.out.println("随机6位数为："+flag.toString());
        String dxyzm = Dxyzm();

    }

    private static String Dxyzm(){
        char[] nonceChars = new char[6];
        for(int index=0;index<nonceChars.length;++index){
            nonceChars[index] = SYMBOLS_code.charAt(random.nextInt(SYMBOLS_code.length()));
        }
        String aaa = new String(nonceChars);
        System.out.println("随机六位码为16:33---"+aaa);
        return aaa;
    }
}
