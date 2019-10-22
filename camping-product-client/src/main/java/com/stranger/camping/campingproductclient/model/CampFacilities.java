package com.stranger.camping.campingproductclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@Table
public class CampFacilities {
@Id
  private Long id;
  private String name;
@Transient
  private List<CampFacilitiesSon> campFacilitiesSons;


}
