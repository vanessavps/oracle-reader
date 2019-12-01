package com.oraclereader.entity.session;

import com.oraclereader.entity.deck.Card;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    if (this == obj)
      return true;

    Question question = (Question) obj;

    return this.id.equals(question.getId()) &&
        StringUtils.equals(this.question, question.getQuestion());
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(9, 7)
        .append(this.id)
        .append(this.question)
        .toHashCode();
  }
}
