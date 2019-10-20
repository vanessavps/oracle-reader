package com.oraclereader.controller.session;

import com.oraclereader.entity.session.CardSpread;
import com.oraclereader.service.session.CardSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-spread")
public class CardSpreadController
{
  private final CardSpreadService cardSpreadService;

  @Autowired
  public CardSpreadController(CardSpreadService cardSpreadService)
  {
    this.cardSpreadService = cardSpreadService;
  }

  @PostMapping
  public CardSpread create(@RequestBody CardSpread cardSpread)
  {
    return cardSpreadService.save(cardSpread);
  }

  @GetMapping
  public List<CardSpread> findAll()
  {
    return cardSpreadService.findAll();
  }

  @GetMapping("/{id}")
  public CardSpread findById(@PathVariable("id") Integer id)
  {
    return cardSpreadService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    cardSpreadService.deleteById(id);
  }
}
