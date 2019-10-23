package com.stranger.camping.campingfegin.controller;

import com.stranger.camping.campingfegin.model.JsonResult;
import com.stranger.camping.campingfegin.service.TbOrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TbOrderFeignController {

    @Autowired
    private TbOrderFeignService tbOrderFeignService;

      @RequestMapping("/order/findByUserId")
      public JsonResult findByUserId(@RequestParam(value = "id") Integer id){
          return tbOrderFeignService.findByUserId(id);
      }
}
