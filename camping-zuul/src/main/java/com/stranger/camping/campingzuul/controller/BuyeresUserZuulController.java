package com.stranger.camping.campingzuul.controller;

import com.stranger.camping.campingzuul.model.JsonResult;
import com.stranger.camping.campingzuul.service.BuyeresUserZuulService;
import com.stranger.camping.campingzuul.util.CodeConfig;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class BuyeresUserZuulController {
    //用户信息service层
    @Autowired
    private BuyeresUserZuulService buyeresUserZuulService;
    //用户订单service层
//    @Autowired
//    private TbOrderZuulService tbOrderZuulService;
    //根据cookie里面id去进行拿值
    @RequestMapping("/findById")
    public String findById(Model model){
        //默认用户id为1
        Integer id = 1;
        //通过id到查询
        JsonResult jsonResult = buyeresUserZuulService.findById(id);
        //通过用户id查询订单
        JsonResult order = buyeresUserZuulService.findByUserId(id);

        if(jsonResult.getResultCode().equals("10000") && order.getResultCode().equals("10000")){
            //把用户信息返回到页面
            model.addAttribute("user",jsonResult.getResultData());
            //把当前用户订单到页面
            model.addAttribute("order",order.getResultData());

            System.out.println(jsonResult.getResultData());
            return "usertenbae";
        }else {
            return "erro";
        }
    }
    //根据用户名判断用户是否有账号
    @RequestMapping("/findName")
    @ResponseBody
    public JsonResult findByName(@RequestParam(value = "loginName") String loginName){

        //到数据库里面去进行查询
        return buyeresUserZuulService.findByName(loginName);
    }

    //找回密码跳转到第二步
    @RequestMapping("/verify")
    public String Verify(String loginName,Model model){

        return "pass2";
    }

    //发送邮箱验证码  izyhjiblivrhhhga
    @RequestMapping("/IsVerify")
    @ResponseBody
    public void  IsVerify(){
        try {
            HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
            email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
            email.setCharset("utf-8");//设置发送的字符类型
            email.addTo("373568974@qq.com");//设置收件人
            email.setFrom("1109917832@qq.com","Mr Zhou");//发送人的邮箱为自己的，用户名可以随便填
            //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            email.setAuthentication("1109917832@qq.com","izyhjiblivrhhhga");
            email.setSubject("去露营网");//设置发送主题
            //生成五位数的随机数
            int a = new Random().nextInt(100000);//生成随机数
//           int ran2 = 0;
//            for(int i =0;i<10000;i++){
//                int ran1 = r.nextInt();
//
//                if(ran1 != ran2){
//                    break;
//                }
//                ran2 = ran1;
//            }

            email.setMsg("你的找回密码的验证友是"+ a);//设置发送内容
            int b =a ;
            email.send();//进行发送
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }



    //发送验证码图片
    @RequestMapping("/createImg")
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            CodeConfig codeConfig = new CodeConfig();
            codeConfig.Random(request, response);//输出验证码图片
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //验证验证码
    @RequestMapping("/code")
    public JsonResult Code(String checkcode ,HttpServletRequest request){
        HttpSession session = request.getSession();

        StringBuilder builder = (StringBuilder) session.getAttribute("RANDOMREDISKEY");

        String s = builder + "";

        if(s.equals(checkcode)){
            return JsonResult.createSuccessJsonResult("ok");
        }else {
            return JsonResult.createFailJsonResult("200100300","验证码错误");
        }
    }
}
