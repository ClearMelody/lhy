package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class SplikeMerchangise {
@Id
  private Long id;
  private String name;
  private String img;
  private Long total;
  private Long state;
  private  long sellerId;

}
