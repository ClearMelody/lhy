package com.stranger.camping.campingorderclient.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stranger.camping.campingorderclient.model.JsonResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.*;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "/index";
    }

    @RequestMapping("/preAdd")
    //@CookieValue(value = "loginUser", required = false)表示当前cookie中，值名叫loginuser的cookie的信息，此处取其token
    public String preAdd(@CookieValue(value = "loginUser", required = false) String token, Model model){
        // 原生的cookie获取方式
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println("产品模块的token为：" + cookie.getName() + "===" + cookie.getValue());
//        }
        System.out.println("产品模块的token为：" + token);
        if (token == null || token.equals("")){
            model.addAttribute("msg", "请先登录");
            return "/login";
        }else{
            // 远程url
            String url = "http://localhost:9901/auth";
            Map<String, String> paramMap = new HashMap<>();
//            将token存放到map
            paramMap.put("token", token);
//map和url作为参数传入post方法
            JsonResult json = post(url, paramMap);
            if(json == null) {
                model.addAttribute("msg", "请先登录");
                return "/login";
            }else {
                if(json.getResultCode().equals("10000")){
                    return "/add";
                }else{
                    model.addAttribute("msg", "请先登录");
                    return "/login";
                }
            }
        }
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpServletResponse resp){
        // 远程url
        String url = "http://localhost:9901/login";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);

        JsonResult json = post(url, paramMap);
        if(json == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "/login";
        }else {
            if(json.getResultCode().equals("10000")){
                System.out.println(json.getResultData());
                LinkedHashMap users = (LinkedHashMap) json.getResultData();
                // 在cookie中保存token
                Cookie cookie = new Cookie("loginUser", (String)users.get("token"));
                // 设置cookie的保存路径
                cookie.setPath("/");
                // 设置cookie的保存时间，单位为秒，0为立即失效，通常用来删除cookie，默认值为-1，表示浏览器关闭就失效
//                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);
                return "/index";
            }else{
                model.addAttribute("msg", "用户名或密码错误");
                return "/login";
            }
        }
    }

    private JsonResult post(String url, Map<String, String> paramMap){
        // 创建HttpClient来发送请求
        HttpClient httpClient = new DefaultHttpClient();
        // 创建一个post请求
        HttpPost httpPost = new HttpPost();
        // 创建参数集合
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        // 将map转成set
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            // 添加到list中
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        // 格式化请求参数：username=aaa&password=bbb
        String param = URLEncodedUtils.format(formparams, "UTF-8");
        // 使用?将参数拼接到url上，一般get请求如此  将token传入服务端
        httpPost.setURI(URI.create(url + "?" + param));
        try {
            // 发送请求，获得响应
            HttpResponse response = httpClient.execute(httpPost);
            // 得到请求结果
            HttpEntity entity = response.getEntity();
            // 将结果转换成字符串json格式
            String str = EntityUtils.toString(entity);
            ObjectMapper mapper = new ObjectMapper();
            // 将对象转成json
//            mapper.writeValueAsString(Object);
            // 将json转成对象
            JsonResult json = mapper.readValue(str, JsonResult.class);
            return json;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
