package com.oraclereader.controller.deck;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oraclereader.Application;
import com.oraclereader.entity.deck.Card;
import com.oraclereader.mock.deck.CardMock;
import com.oraclereader.repository.deck.CardRepository;
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
public class CardControllerIntegrationTest
{
  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Card card1;
  private Card card2;

  @Before
  public void setUp()
  {
    card1 = CardMock.createTheFool();
    cardRepository.save(card1);

    card2 = CardMock.createTheEmpress();
    cardRepository.save(card2);
  }

  @Test
  public void createTest() throws Exception
  {
    Card card = CardMock.createTheMagician();
    String deckJson = ObjectConverter.convertObjectToJson(mapper, card);

    String resultJson = mvc.perform(post("/card")
        .contentType(MediaType.APPLICATION_JSON)
        .content(deckJson))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Card resultObject = ObjectConverter.convertJsonToObject(mapper, resultJson, Card.class);

    Card savedCard = cardRepository.findById(resultObject.getId())
        .orElse(null);
    assertNotNull(savedCard);
    assertEquals(resultObject, savedCard);
  }

  @Test
  public void findAllTest() throws Exception
  {
    String result = mvc.perform(get("/card"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Card> cards = ObjectConverter.convertJsonToObjectList(mapper, result, new TypeReference<List<Card>>() {});
    assertEquals(2, cards.size());
  }

  @Test
  public void findByIdTest() throws Exception
  {
    String result = mvc.perform(get("/card/{id}", card2.getId()))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Card card = ObjectConverter.convertJsonToObject(mapper, result, Card.class);
    assertEquals(card2, card);
  }

  @Test
  public void findByIdInvalidIdTest() throws Exception
  {
    thrown.expect(EntityNotFoundException.class);
    thrown.expectMessage("Object 25 not found");

    try
    {
      mvc.perform(get("/card/{id}", 25));
    } catch (NestedServletException e)
    {
      throw (Exception) e.getCause();
    }
  }

  @Test
  public void deleteByIdTest() throws Exception
  {
    int id = 2;

    mvc.perform(delete("/card/{id}", id))
        .andExpect(status().isOk());

    Card card = cardRepository.findById(id)
        .orElse(null);
    assertNull(card);
  }

}
