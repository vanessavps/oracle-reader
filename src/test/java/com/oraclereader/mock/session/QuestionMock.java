package com.oraclereader.mock.session;

import com.oraclereader.entity.session.Question;

public class QuestionMock
{

  public static Question createStayQuestion()
  {
    Question question = new Question();
    question.setId(0);
    question.setQuestion("Should I stay?");

    return question;
  }

  public static Question createGoQuestion()
  {
    Question question = new Question();
    question.setId(1);
    question.setQuestion("Should I go?");

    return question;
  }
}
