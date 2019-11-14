package com.oraclereader.entity.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String email;
  private String password;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    if (this == obj)
      return true;

    User user = (User) obj;

    return this.id.equals(user.getId()) &&
        StringUtils.equals(this.name, user.getName()) &&
        StringUtils.equals(this.email, user.getEmail()) &&
        StringUtils.equals(this.password, user.getPassword());
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(1, 3)
        .append(id)
        .append(name)
        .append(email)
        .append(password)
        .toHashCode();
  }
}
