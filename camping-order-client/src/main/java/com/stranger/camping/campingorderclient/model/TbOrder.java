package com.stranger.camping.campingorderclient.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table
public class TbOrder {
  @Id
  private Long id;
  private String orderNumber;
  private String houseNumber;
  private Date startTime;
  private Date endTime;
  private String reservationNumber;
  private Date reservationTime;
  private Long allDay;
  private Double orderPrice;
  private String reservationType;
  private String contactName;
  private String contactTelephone;
  private String orderDesc;
  private Long orderState;
  private Long userId;
  private String email;
  private String scheduledMeals;
  private Long sellerId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }


  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }


  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }


  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }


  public String getReservationNumber() {
    return reservationNumber;
  }

  public void setReservationNumber(String reservationNumber) {
    this.reservationNumber = reservationNumber;
  }


  public Date getReservationTime() {
    return reservationTime;
  }

  public void setReservationTime(Date reservationTime) {
    this.reservationTime = reservationTime;
  }


  public Long getAllDay() {
    return allDay;
  }

  public void setAllDay(Long allDay) {
    this.allDay = allDay;
  }


  public Double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(Double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getReservationType() {
    return reservationType;
  }

  public void setReservationType(String reservationType) {
    this.reservationType = reservationType;
  }


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }


  public String getContactTelephone() {
    return contactTelephone;
  }

  public void setContactTelephone(String contactTelephone) {
    this.contactTelephone = contactTelephone;
  }


  public String getOrderDesc() {
    return orderDesc;
  }

  public void setOrderDesc(String orderDesc) {
    this.orderDesc = orderDesc;
  }


  public Long getOrderState() {
    return orderState;
  }

  public void setOrderState(Long orderState) {
    this.orderState = orderState;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getScheduledMeals() {
    return scheduledMeals;
  }

  public void setScheduledMeals(String scheduledMeals) {
    this.scheduledMeals = scheduledMeals;
  }


  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

}
