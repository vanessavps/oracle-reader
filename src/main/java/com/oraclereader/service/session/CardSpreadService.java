package com.oraclereader.service.session;

import com.oraclereader.entity.session.CardSpread;
import com.oraclereader.repository.session.CardSpreadRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardSpreadService extends CrudService<CardSpread>
{
  @Autowired
  public CardSpreadService(CardSpreadRepository cardSpreadRepository)
  {
    super(cardSpreadRepository);
  }
}
