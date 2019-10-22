package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@Table
public class Product {
@Id
  private Long id;
  private String productName;
  private String productAddress;
  private Double productPrice;
  private Long sellerId;
  private Long productState;
  private String productImg;
  private String pouductImg1;
  private String pouductImg2;
  private String productDesc;
  private Long typeId;
  private String businessDate;
  private String openingDate;
  private String precautions;
  private String campFeatures;
  @Transient
  private CampType campType;
@Transient
  private List<HouseType> list;

}
