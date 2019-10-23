package com.stranger.camping.campingfegin.controller;

import com.stranger.camping.campingfegin.model.JsonResult;
import com.stranger.camping.campingfegin.service.BuyeresUserFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class BuyeresUserFeginController {
    @Autowired
    private BuyeresUserFeginService buyeresUserFeginService;

    @RequestMapping("/findName")
    public JsonResult findByName(@RequestParam(value = "loginName") String loginName){

        //到数据库里面去进行查询
       return buyeresUserFeginService.findByName(loginName);
    }


    @RequestMapping("/findById")
    public JsonResult findById(@RequestParam(value = "id") Integer id){
        JsonResult jsonResult = buyeresUserFeginService.findById(id);
        System.out.println("========================"+jsonResult+"=================================");
        return jsonResult;

    }



}
