package com.oraclereader.service.session;

import com.oraclereader.entity.session.Question;
import com.oraclereader.mock.session.QuestionMock;
import com.oraclereader.repository.session.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QuestionService.class)
public class QuestionServiceTest
{
  @Autowired
  private QuestionService questionService;

  @MockBean
  private QuestionRepository questionRepository;

  @Test
  public void saveTest()
  {
    Question question = QuestionMock.createStayQuestion();
    questionService.save(question);

    verify(questionRepository, times(1)).save(question);
  }

  @Test
  public void findByIdTest()
  {
    Question question = QuestionMock.createGoQuestion();

    when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
    questionService.findById(question.getId());

    verify(questionRepository, times(1)).findById(question.getId());
  }

  @Test
  public void findAllTest()
  {
    Question question1 = QuestionMock.createStayQuestion();
    Question question2 = QuestionMock.createGoQuestion();

    List<Question> expectedResult = Arrays.asList(question1, question2);
    when(questionRepository.findAll()).thenReturn(expectedResult);

    List<Question> result = questionService.findAll();

    verify(questionRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Question question = QuestionMock.createStayQuestion();
    questionService.deleteById(question.getId());

    verify(questionRepository, times(1)).deleteById(question.getId());
  }


}
