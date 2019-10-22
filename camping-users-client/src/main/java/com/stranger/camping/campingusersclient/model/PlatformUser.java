package com.stranger.camping.campingusersclient.model;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table
public class PlatformUser {
@Id
  private Long id;
  private String name;
  private String account;
  private String password;
  private String reservedField;
  private String telephoneNumber;
  private Long role;


}
