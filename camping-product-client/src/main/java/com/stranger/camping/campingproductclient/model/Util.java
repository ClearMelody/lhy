package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Util implements Serializable {
    private String name;
    private  Integer id;
    public static Util createUtil(String name,Integer id){
        Util util = new Util();
        util.name = name;
        util.id = id;
        return util;
    }
}
