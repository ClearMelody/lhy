package com.stranger.camping.campingusersclient.controller;


import com.stranger.camping.campingusersclient.model.BuyeresUser;
import com.stranger.camping.campingusersclient.model.JsonResult;
import com.stranger.camping.campingusersclient.service.BuyeresUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class BuyeresUserController {

    @Autowired
    private BuyeresUserService buyeresUserService;

    //根据用户名查询有没有账号
    @RequestMapping("/findName")
    public JsonResult findByName(@RequestParam(value = "loginName") String loginName) {
        //到数据库里面去进行查询
        BuyeresUser buyeresUser = buyeresUserService.findByUserName(loginName);
        if(buyeresUser != null){
            //正确消息
            return JsonResult.createSuccessJsonResult(buyeresUser);
        }else {
            //错误消息
            return JsonResult.createFailJsonResult("200100200","未找到该账号注册信息");
        }

    }

    @RequestMapping("/findById")
    public JsonResult findById(@RequestParam(value = "id") Integer id){

        BuyeresUser buyeresUser = buyeresUserService.findById(id);
        if(buyeresUser != null){
            //正确消息
            return JsonResult.createSuccessJsonResult(buyeresUser);
        }else {
            //错误消息
            return JsonResult.createFailJsonResult("200100200","未找到该账号注册信息");
        }
    }




}
