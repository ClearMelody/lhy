package com.stranger.camping.campingzuul.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CodeConfig {

    public static final String RANDOMCODEKEY= "RANDOMREDISKEY";//放到session中的key

    public void Random(HttpServletRequest request, HttpServletResponse response){

        //创建session对象
        HttpSession session = request.getSession();

        int width = 114;
        int height = 31;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();
        //设置画笔颜色
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(0,0,width,height);
        //设置边框颜色
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width - 1,height - 1);

        //设置随机生成数
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        //创建随机生成对象
        Random ran = new Random();
        //循环生成4位字
        StringBuilder code = new StringBuilder();
        for(int i = 1;i <= 4;i++ ){
            //得到随机生成数的下标
            int index = ran.nextInt(str.length());

            char ch = str.charAt(index);
            //设置字体效果及大小
            graphics.setFont(new Font("tahoma", Font.BOLD,20));
            //设置显示位置
            graphics.drawString(ch + "",width/5*i,22);

            code.append(ch);
        }

        //每次进来保存到session中清除session中的数据
        session.removeAttribute(RANDOMCODEKEY);
        //把验证码保存到session中
        session.setAttribute(RANDOMCODEKEY,code);

        //设置干扰线颜色
        graphics.setColor(SystemColor.PINK);

        for(int i = 0;i < 10;i++){
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);
        }

        //输出到前端页面
        try {
            ImageIO.write(image,"jpg",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
