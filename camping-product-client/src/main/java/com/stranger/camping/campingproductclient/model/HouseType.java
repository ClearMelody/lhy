package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table
public class HouseType {
@Id
  private Long id;
  private String houseName;
  private String standard;
  private String breakfast;
  private String housePrice;
  private Long playWay;
  private String houseImg;
  private Long prouductId;
@Transient
  private  String[] playWays={"微信","支付宝","微信和支付宝"};
public String getPlayWay() {
  {
    return playWays[playWay.intValue() ];
  }
}
}
