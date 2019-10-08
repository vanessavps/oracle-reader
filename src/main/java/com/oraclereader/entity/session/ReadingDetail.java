package com.oraclereader.entity.session;

import javax.persistence.*;

@Entity
public class ReadingDetail
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="read_id")
  private Integer readingId;

  @OneToOne
  @JoinColumn(name = "answer_id")
  private Answer answer;

  @OneToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @Column(name="question_number")
  private Integer questionNumber;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getReadingID()
  {
    return readingId;
  }

  public void setReadingId(Integer readingId)
  {
    this.readingId = readingId;
  }

  public Answer getAnswer()
  {
    return answer;
  }

  public void setAnswer(Answer answer)
  {
    this.answer = answer;
  }

  public Question getQuestion()
  {
    return question;
  }

  public void setQuestion(Question question)
  {
    this.question = question;
  }

  public Integer getQuestionNumber()
  {
    return questionNumber;
  }

  public void setQuestionNumber(Integer questionNumber)
  {
    this.questionNumber = questionNumber;
  }
}
