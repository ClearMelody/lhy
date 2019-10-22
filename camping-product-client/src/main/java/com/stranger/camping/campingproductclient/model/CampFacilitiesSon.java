package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class CampFacilitiesSon {
@Id
  private Long id;
  private String nameSon;
  private Long fatherId;
  private Long productId;



}
