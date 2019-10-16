package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.entity.deck.Deck;
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
    Deck deck = createDeck(1, "Tarot", "Waite", "Colman", "Tarot Publisher");
    deckService.save(deck);

    verify(deckRepository, times(1)).save(deck);
  }

  @Test
  public void findByIdTest()
  {
    Deck deck = createDeck(2, "Tarot 2", "Waite", "Colman", "Tarot Publisher");

    when(deckRepository.findById(deck.getId())).thenReturn(Optional.of(deck));
    deckService.findById(deck.getId());

    verify(deckRepository, times(1)).findById(deck.getId());
  }

  @Test
  public void findAllTest()
  {
    Deck deck1 = createDeck(1, "Tarot", "Waite", "Colman", "Tarot Publisher");
    Deck deck2 = createDeck(2, "Tarot 2", "Waite 2", "Colman 2", "Card Publisher");
    Deck deck3 = createDeck(3, "Tarot 3", "Waite 3", "Colman 3", "Tarot Publisher House");

    List<Deck> expectedResult = Arrays.asList(deck1, deck2, deck3);
    when(deckRepository.findAll()).thenReturn(expectedResult);

    List<Deck> result = deckService.findAll();

    verify(deckRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Deck deck = createDeck(3, "Tarot 3", "Waite 3", "Colman 3", "Tarot Publisher House");
    deckService.deleteById(deck.getId());

    verify(deckRepository, times(1)).deleteById(deck.getId());
  }

  private Deck createDeck(Integer id, String name, String author, String illustrator, String publisher)
  {
    Deck deck = new Deck();
    deck.setId(id);
    deck.setName(name);
    deck.setAuthor(author);
    deck.setIllustrator(illustrator);
    deck.setPublisher(publisher);

    List<Card> cards = createCardList();
    deck.setCards(cards);

    return deck;
  }

  private List<Card> createCardList()
  {
    Card card1 = new Card();
    card1.setName("fake card 1");

    Card card2 = new Card();
    card2.setName("fake card 2");

    return Arrays.asList(card1, card2);
  }
}
