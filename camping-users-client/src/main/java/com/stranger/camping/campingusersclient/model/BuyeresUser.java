package com.stranger.camping.campingusersclient.model;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class BuyeresUser {
  @Id
  private Long id;
  private String relalmName;
  private String password;
  private String email;
  private String telephoneNumber;
  private Long integral;
  private String avator;
  private String nickName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getRelalmName() {
    return relalmName;
  }

  public void setRelalmName(String relalmName) {
    this.relalmName = relalmName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }


  public Long getIntegral() {
    return integral;
  }

  public void setIntegral(Long integral) {
    this.integral = integral;
  }


  public String getAvator() {
    return avator;
  }

  public void setAvator(String avator) {
    this.avator = avator;
  }


  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

}
