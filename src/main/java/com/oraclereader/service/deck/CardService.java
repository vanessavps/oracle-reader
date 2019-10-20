package com.oraclereader.service.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.repository.deck.CardRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CardService implements CrudService<Card>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(CardService.class);

  private final CardRepository cardRepository;

  @Autowired
  public CardService(CardRepository cardRepository)
  {
    this.cardRepository = cardRepository;
  }

  @Override
  public Card save(Card card)
  {
    return cardRepository.save(card);
  }

  @Override
  public Card findById(Integer id)
  {
    return cardRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Card " + id + " not found"));
  }

  @Override
  public List<Card> findAll()
  {
    return cardRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    cardRepository.deleteById(id);
  }
}
