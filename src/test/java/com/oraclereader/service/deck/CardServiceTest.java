package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.mock.deck.CardMock;
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
    Card card = CardMock.createTheFool();
    cardService.save(card);

    verify(cardRepository, times(1)).save(card);
  }

  @Test
  public void findByIdTest()
  {
    Card card = CardMock.createTheMagician();

    when(cardRepository.findById(card.getId())).thenReturn(Optional.of(card));
    cardService.findById(card.getId());

    verify(cardRepository, times(1)).findById(card.getId());
  }

  @Test
  public void findAllTest()
  {
    Card card1 = CardMock.createTheFool();
    Card card2 = CardMock.createTheMagician();
    Card card3 = CardMock.createTheEmpress();

    List<Card> expectedResult = Arrays.asList(card1, card2, card3);
    when(cardRepository.findAll()).thenReturn(expectedResult);

    List<Card> result = cardService.findAll();

    verify(cardRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Card card = CardMock.createTheFool();
    cardService.deleteById(card.getId());

    verify(cardRepository, times(1)).deleteById(card.getId());
  }

}
