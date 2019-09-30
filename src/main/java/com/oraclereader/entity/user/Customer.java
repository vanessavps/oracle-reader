package com.oraclereader.entity.user;

import javax.persistence.Entity;
import java.time.LocalDateTime;

//@Entity
public class Customer
{
  private Integer id;
  private String email;
  private String phone;
  private LocalDateTime birthdate;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public LocalDateTime getBirthdate()
  {
    return birthdate;
  }

  public void setBirthdate(LocalDateTime birthdate)
  {
    this.birthdate = birthdate;
  }
}
