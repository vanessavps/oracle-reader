package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Deck;
import com.oraclereader.repository.deck.DeckRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckService extends CrudService<Deck>
{
  @Autowired
  public DeckService(DeckRepository deckRepository)
  {
    super(deckRepository);
  }
}
