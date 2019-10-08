package com.oraclereader.service.session;

import com.oraclereader.entity.session.CardSpread;
import com.oraclereader.repository.session.CardSpreadRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CardSpreadService implements CrudService<CardSpread>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(CardSpreadService.class);

  private final CardSpreadRepository cardSpreadRepository;

  @Autowired
  public CardSpreadService(CardSpreadRepository cardSpreadRepository)
  {
    this.cardSpreadRepository = cardSpreadRepository;
  }

  @Override
  public CardSpread save(CardSpread cardSpread)
  {
    return cardSpreadRepository.save(cardSpread);
  }

  @Override
  public CardSpread findById(Integer id)
  {
    return cardSpreadRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("CardSpread " + id + " not found"));
  }

  @Override
  public List<CardSpread> findAll()
  {
    return cardSpreadRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    cardSpreadRepository.deleteById(id);
  }
}
