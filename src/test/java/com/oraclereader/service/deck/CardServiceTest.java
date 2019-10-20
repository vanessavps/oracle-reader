package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.repository.deck.CardRepository;
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
@ContextConfiguration(classes = CardService.class)
public class CardServiceTest
{
  @Autowired
  private CardService cardService;

  @MockBean
  private CardRepository cardRepository;

  @Test
  public void saveTest()
  {
    Card card = createCard(1, "The fool");
    cardService.save(card);

    verify(cardRepository, times(1)).save(card);
  }

  @Test
  public void findByIdTest()
  {
    Card card = createCard(2, "The magician");

    when(cardRepository.findById(card.getId())).thenReturn(Optional.of(card));
    cardService.findById(card.getId());

    verify(cardRepository, times(1)).findById(card.getId());
  }

  @Test
  public void findAllTest()
  {
    Card card1 = createCard(1, "The fool");
    Card card2 = createCard(2, "The magician");
    Card card3 = createCard(3, "The high priestess");

    List<Card> expectedResult = Arrays.asList(card1, card2, card3);
    when(cardRepository.findAll()).thenReturn(expectedResult);

    List<Card> result = cardService.findAll();

    verify(cardRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Card card = createCard(1, "The fool");
    cardService.deleteById(card.getId());

    verify(cardRepository, times(1)).deleteById(card.getId());
  }

  private Card createCard(Integer id, String name)
  {
    Card card = new Card();
    card.setId(id);
    card.setName(name);

    return card;
  }
}
