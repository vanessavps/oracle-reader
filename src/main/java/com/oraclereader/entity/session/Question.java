package com.oraclereader.entity.session;

import javax.persistence.Entity;

//@Entity
public class Question
{
  private Integer id;
  private String question;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getQuestion()
  {
    return question;
  }

  public void setQuestion(String question)
  {
    this.question = question;
  }
}
