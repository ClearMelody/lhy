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


}
