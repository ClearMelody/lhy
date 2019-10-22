package com.stranger.camping.campingorderclient.model;


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
  private Long productId;
}
