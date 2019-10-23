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

  private List<HouseType> houseTypeList;
  @Transient
  private String typeName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductAddress() {
    return productAddress;
  }

  public void setProductAddress(String productAddress) {
    this.productAddress = productAddress;
  }


  public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }


  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }


  public Long getProductState() {
    return productState;
  }

  public void setProductState(Long productState) {
    this.productState = productState;
  }


  public String getProductImg() {
    return productImg;
  }

  public void setProductImg(String productImg) {
    this.productImg = productImg;
  }


  public String getPouductImg1() {
    return pouductImg1;
  }

  public void setPouductImg1(String pouductImg1) {
    this.pouductImg1 = pouductImg1;
  }


  public String getPouductImg2() {
    return pouductImg2;
  }

  public void setPouductImg2(String pouductImg2) {
    this.pouductImg2 = pouductImg2;
  }


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }


  public String getBusinessDate() {
    return businessDate;
  }

  public void setBusinessDate(String businessDate) {
    this.businessDate = businessDate;
  }


  public String getOpeningDate() {
    return openingDate;
  }

  public void setOpeningDate(String openingDate) {
    this.openingDate = openingDate;
  }


  public String getPrecautions() {
    return precautions;
  }

  public void setPrecautions(String precautions) {
    this.precautions = precautions;
  }


  public String getCampFeatures() {
    return campFeatures;
  }

  public void setCampFeatures(String campFeatures) {
    this.campFeatures = campFeatures;
  }

}
