package com.oraclereader.controller.session;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oraclereader.Application;
import com.oraclereader.entity.session.Question;
import com.oraclereader.mock.session.QuestionMock;
import com.oraclereader.repository.session.QuestionRepository;
import com.oraclereader.util.ObjectConverter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class QuestionControllerIntegrationTest
{
  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Question question1;
  private Question question2;

  @Before
  public void setUp()
  {
    question1 = QuestionMock.createStayQuestion();
    questionRepository.save(question1);

    question2 = QuestionMock.createGoQuestion();
    questionRepository.save(question2);
  }

  @Test
  public void createTest() throws Exception
  {
    Question question = QuestionMock.createEverythingQuestion();
    String deckJson = ObjectConverter.convertObjectToJson(mapper, question);

    String resultJson = mvc.perform(post("/question")
        .contentType(MediaType.APPLICATION_JSON)
        .content(deckJson))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Question resultObject = ObjectConverter.convertJsonToObject(mapper, resultJson, Question.class);

    Question savedQuestion = questionRepository.findById(resultObject.getId())
        .orElse(null);
    assertNotNull(savedQuestion);
    assertEquals(resultObject, savedQuestion);
  }

  @Test
  public void findAllTest() throws Exception
  {
    String result = mvc.perform(get("/question"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Question> questions = ObjectConverter.convertJsonToObjectList(mapper, result, new TypeReference<List<Question>>() {});
    assertEquals(2, questions.size());
  }

  @Test
  public void findByIdTest() throws Exception
  {
    String result = mvc.perform(get("/question/{id}", question2.getId()))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Question question = ObjectConverter.convertJsonToObject(mapper, result, Question.class);
    assertEquals(question2, question);
  }

  @Test
  public void findByIdInvalidIdTest() throws Exception
  {
    thrown.expect(EntityNotFoundException.class);
    thrown.expectMessage("Object 51 not found");

    try
    {
      mvc.perform(get("/question/{id}", 51));
    } catch (NestedServletException e)
    {
      throw (Exception) e.getCause();
    }
  }

  @Test
  public void deleteByIdTest() throws Exception
  {
    int id = 2;

    mvc.perform(delete("/question/{id}", id))
        .andExpect(status().isOk());

    Question question = questionRepository.findById(id)
        .orElse(null);
    assertNull(question);
  }

}
