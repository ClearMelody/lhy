package com.stranger.camping.campingorderclient.model;

import lombok.Data;

@Data
public class Util  {
    private String name;
    private  Long id;
    public static Util createUtil(String name,Long id){
        Util util = new Util();
        util.name = name;
        util.id = id;
        return util;
    }
}
