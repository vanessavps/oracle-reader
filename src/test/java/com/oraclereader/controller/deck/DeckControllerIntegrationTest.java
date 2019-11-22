package com.oraclereader.controller.deck;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oraclereader.Application;
import com.oraclereader.entity.deck.Deck;
import com.oraclereader.mock.deck.DeckMock;
import com.oraclereader.repository.deck.DeckRepository;
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

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DeckControllerIntegrationTest
{
  @Autowired
  private DeckRepository deckRepository;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Deck deck1;
  private Deck deck2;

  @Before
  public void setUp()
  {
    deck1 = DeckMock.createTarotDeck();
    deckRepository.save(deck1);

    deck2 = DeckMock.createMoonologyDeck();
    deckRepository.save(deck2);
  }

  @Test
  public void createTest() throws Exception
  {
    Deck deck = DeckMock.createMythicTarotDeck();
    String deckJson = ObjectConverter.convertObjectToJson(mapper, deck);

    String resultJson = mvc.perform(post("/deck")
        .contentType(MediaType.APPLICATION_JSON)
        .content(deckJson))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Deck resultObject = ObjectConverter.convertJsonToObject(mapper, resultJson, Deck.class);

    Deck savedDeck = deckRepository.findById(resultObject.getId())
        .orElse(null);
    assertNotNull(savedDeck);
    assertEquals(resultObject, savedDeck);
  }

  @Test
  public void findAllTest() throws Exception
  {
    String result = mvc.perform(get("/deck"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Deck> decks = ObjectConverter.convertJsonToObjectList(mapper, result, new TypeReference<List<Deck>>() {});
    assertEquals(2, decks.size());
  }

  @Test
  public void findByIdTest() throws Exception
  {
    String result = mvc.perform(get("/deck/{id}", deck2.getId()))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Deck deck = ObjectConverter.convertJsonToObject(mapper, result, Deck.class);
    assertEquals(deck2, deck);
  }

  @Test
  public void findByIdInvalidIdTest() throws Exception
  {
    thrown.expect(EntityNotFoundException.class);
    thrown.expectMessage("Object 25 not found");

    try
    {
      mvc.perform(get("/deck/{id}", 25));
    } catch (NestedServletException e)
    {
      throw (Exception) e.getCause();
    }
  }

  @Test
  public void deleteByIdTest() throws Exception
  {
    int id = 2;

    mvc.perform(delete("/deck/{id}", id))
        .andExpect(status().isOk());

    Deck deck = deckRepository.findById(id)
        .orElse(null);
    assertNull(deck);
  }
}
