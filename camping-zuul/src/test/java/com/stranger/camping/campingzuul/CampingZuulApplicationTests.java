package com.stranger.camping.campingzuul;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampingZuulApplicationTests {

    @Test
    public void contextLoads() {
        for(int i = 0;i<100;i++){
            try {
                HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
                email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
                email.setCharset("utf-8");//设置发送的字符类型
                email.addTo("ylz16581@163.com");//设置收件人
                email.setFrom("1109917832@qq.com","Mr Zhou");//发送人的邮箱为自己的，用户名可以随便填
                //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
                email.setAuthentication("1109917832@qq.com","izyhjiblivrhhhga");
                email.setSubject("去露营网");//设置发送主题
                //生成五位数的随机数
                int a = new Random().nextInt(100000);//生成随机数

                email.setMsg("你的找回密码的验证码是"+ a);//设置发送内容
                email.send();//进行发送
                System.out.println("发送成功");
            } catch (EmailException e) {
                e.printStackTrace();
            }
        }
    }

}
