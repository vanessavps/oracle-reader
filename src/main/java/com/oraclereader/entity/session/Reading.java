package com.oraclereader.entity.session;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reading
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "card_spread_id")
  private Integer cardSpreadId;

  private LocalDateTime date;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getUserId()
  {
    return userId;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public Integer getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(Integer customerId)
  {
    this.customerId = customerId;
  }

  public LocalDateTime getDate()
  {
    return date;
  }

  public void setDate(LocalDateTime date)
  {
    this.date = date;
  }

  public Integer getCardSpreadId()
  {
    return cardSpreadId;
  }

  public void setCardSpreadId(Integer cardSpreadId)
  {
    this.cardSpreadId = cardSpreadId;
  }
}
