package com.oraclereader.entity.deck;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String description;
  private String detail;

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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getDetail()
  {
    return detail;
  }

  public void setDetail(String detail)
  {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    if (this == obj)
      return true;

    Card card = (Card) obj;

    return this.id.equals(card.getId()) &&
        StringUtils.equals(this.name, card.getName()) &&
        StringUtils.equals(this.description, card.getDescription()) &&
        StringUtils.equals(this.detail, card.getDetail());
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(3, 3)
        .append(this.id)
        .append(this.name)
        .append(this.description)
        .append(this.detail)
        .toHashCode();
  }
}
