package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.repository.deck.CardRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService extends CrudService<Card>
{
  @Autowired
  public CardService(CardRepository cardRepository)
  {
    super(cardRepository);
  }
}
