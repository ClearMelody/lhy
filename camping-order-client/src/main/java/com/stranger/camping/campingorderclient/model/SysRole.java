package com.stranger.camping.campingorderclient.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class SysRole {
@Id
  private String roleCode;
  private String roleName;
  private String roleDesc;
  private long roleOrder;
  private long roleType;


}
