package com.oraclereader.service.session;

import com.oraclereader.entity.session.CardSpread;
import com.oraclereader.mock.session.CardSpreadMock;
import com.oraclereader.repository.session.CardSpreadRepository;
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
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CardSpreadService.class)
public class CardSpreadServiceTest
{

  @Autowired
  private CardSpreadService cardSpreadService;

  @MockBean
  private CardSpreadRepository cardSpreadRepository;

  @Test
  public void saveTest()
  {
    CardSpread cardSpread = CardSpreadMock.singleCardSpread();
    cardSpreadService.save(cardSpread);

    verify(cardSpreadRepository, times(1)).save(cardSpread);
  }

  @Test
  public void findByIdTest()
  {
    CardSpread cardSpread = CardSpreadMock.threeCardSpread();

    when(cardSpreadRepository.findById(cardSpread.getId())).thenReturn(Optional.of(cardSpread));
    cardSpreadService.findById(cardSpread.getId());

    verify(cardSpreadRepository, times(1)).findById(cardSpread.getId());
  }

  @Test
  public void findAllTest()
  {
    CardSpread cardSpread1 = CardSpreadMock.singleCardSpread();
    CardSpread cardSpread2 = CardSpreadMock.threeCardSpread();

    List<CardSpread> expectedResult = Arrays.asList(cardSpread1, cardSpread2);
    when(cardSpreadRepository.findAll()).thenReturn(expectedResult);

    List<CardSpread> result = cardSpreadService.findAll();

    verify(cardSpreadRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    CardSpread question = CardSpreadMock.threeCardSpread();
    cardSpreadService.deleteById(question.getId());

    verify(cardSpreadRepository, times(1)).deleteById(question.getId());
  }
}
