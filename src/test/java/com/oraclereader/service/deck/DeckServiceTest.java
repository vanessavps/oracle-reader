package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Deck;
import com.oraclereader.mock.deck.DeckMock;
import com.oraclereader.repository.deck.DeckRepository;
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
@ContextConfiguration(classes = DeckService.class)
public class DeckServiceTest
{
  @Autowired
  private DeckService deckService;

  @MockBean
  private DeckRepository deckRepository;

  @Test
  public void saveTest()
  {
    Deck deck = DeckMock.createTarotDeck();
    deckService.save(deck);

    verify(deckRepository, times(1)).save(deck);
  }

  @Test
  public void findByIdTest()
  {
    Deck deck = DeckMock.createTarotDeck();

    when(deckRepository.findById(deck.getId())).thenReturn(Optional.of(deck));
    deckService.findById(deck.getId());

    verify(deckRepository, times(1)).findById(deck.getId());
  }

  @Test
  public void findAllTest()
  {
    Deck deck1 = DeckMock.createTarotDeck();
    Deck deck2 = DeckMock.createMoonologyDeck();


    List<Deck> expectedResult = Arrays.asList(deck1, deck2);
    when(deckRepository.findAll()).thenReturn(expectedResult);

    List<Deck> result = deckService.findAll();

    verify(deckRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Deck deck = DeckMock.createTarotDeck();
    deckService.deleteById(deck.getId());

    verify(deckRepository, times(1)).deleteById(deck.getId());
  }
}
