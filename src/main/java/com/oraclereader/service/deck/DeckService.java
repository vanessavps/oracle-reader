package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Deck;
import com.oraclereader.repository.deck.DeckRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DeckService implements CrudService<Deck>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(CardService.class);

  private final DeckRepository deckRepository;

  @Autowired
  public DeckService(DeckRepository deckRepository)
  {
    this.deckRepository = deckRepository;
  }

  @Override
  public Deck save(Deck deck)
  {
    return deckRepository.save(deck);
  }

  @Override
  public Deck findById(Integer id)
  {
    return deckRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));
  }

  @Override
  public List<Deck> findAll()
  {
    return deckRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    deckRepository.deleteById(id);
  }
}
