package com.stranger.camping.campingorderclient.controller;

import com.stranger.camping.campingorderclient.model.JsonResult;
import com.stranger.camping.campingorderclient.model.TbOrder;
import com.stranger.camping.campingorderclient.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class TbOrderController {
    @Autowired
    private TbOrderService tbOrderService;

    @RequestMapping("/findByUserId")
    public JsonResult findByUserId(@RequestParam(value = "id") Integer id){

        List<TbOrder> tbOrderList = tbOrderService.findByUserId(id);

        if(tbOrderList.size() > 0){
            return JsonResult.createSuccessJsonResult(tbOrderList);
        }else {
            return JsonResult.createFailJsonResult("200100300","您的用户名下未找到订单");
        }
    }
}
