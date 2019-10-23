package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class CampType {
  @Id
  private Long id;
  private String campName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getCampName() {
    return campName;
  }

  public void setCampName(String campName) {
    this.campName = campName;
  }

}
