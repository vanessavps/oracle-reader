package com.oraclereader.mock.session;

import com.oraclereader.entity.session.Question;

public class QuestionMock
{

  public static Question createStayQuestion()
  {
    Question question = new Question();
    question.setQuestion("Should I stay?");

    return question;
  }

  public static Question createGoQuestion()
  {
    Question question = new Question();
    question.setQuestion("Should I go?");

    return question;
  }

  public static Question createEverythingQuestion()
  {
    Question question = new Question();
    question.setQuestion("What is the answer to the ultimate question of life, the universe, and everything?");

    return question;
  }
}
