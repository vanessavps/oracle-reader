package com.oraclereader.entity.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Customer
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
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
    if (birthdate != null)
    {
      this.birthdate = birthdate.truncatedTo(ChronoUnit.SECONDS);
    }
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    if (this == obj)
      return true;

    Customer customer = (Customer) obj;

    return this.id.equals(customer.getId()) &&
        StringUtils.equals(this.name, customer.getName()) &&
        StringUtils.equals(this.email, customer.getEmail()) &&
        StringUtils.equals(this.phone, customer.getPhone()) &&
        this.birthdate.equals(customer.getBirthdate());
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(1, 3)
        .append(this.id)
        .append(this.name)
        .append(this.email)
        .append(this.phone)
        .append(this.birthdate)
        .toHashCode();
  }
}
