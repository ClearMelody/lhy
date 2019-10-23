package com.stranger.camping.campingproductclient.model;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

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


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getHouseName() {
    return houseName;
  }

  public void setHouseName(String houseName) {
    this.houseName = houseName;
  }


  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }


  public String getBreakfast() {
    return breakfast;
  }

  public void setBreakfast(String breakfast) {
    this.breakfast = breakfast;
  }


  public String getHousePrice() {
    return housePrice;
  }

  public void setHousePrice(String housePrice) {
    this.housePrice = housePrice;
  }


  public Long getPlayWay() {
    return playWay;
  }

  public void setPlayWay(Long playWay) {
    this.playWay = playWay;
  }


  public String getHouseImg() {
    return houseImg;
  }

  public void setHouseImg(String houseImg) {
    this.houseImg = houseImg;
  }


  public Long getProuductId() {
    return prouductId;
  }

  public void setProuductId(Long prouductId) {
    this.prouductId = prouductId;
  }

}
