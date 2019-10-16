package com.stranger.camping.campingorderclient.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult {
    private String resultCode;
    private Object resultData;
    private String resultDesc;

    public static JsonResult createSuccessJsonResult(Object resultData){
        JsonResult result = new JsonResult();
        result.resultCode = "10000";
        result.resultDesc = "";
        result.resultData = resultData;
        return result;
    }

    public static JsonResult createFailJsonResult(String resultCode, String resultDesc){
        JsonResult result = new JsonResult();
        result.resultCode = resultCode;
        result.resultDesc = resultDesc;
        return result;
    }
}
