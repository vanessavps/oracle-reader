package com.oraclereader.controller.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.service.deck.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController
{
  private final CardService cardService;

  @Autowired
  public CardController(CardService cardService)
  {
    this.cardService = cardService;
  }

  @PostMapping
  public Card create(@RequestBody Card card)
  {
    return cardService.save(card);
  }

  @GetMapping
  public List<Card> findAll()
  {
    return cardService.findAll();
  }

  @GetMapping("/{id}")
  public Card findById(@PathVariable("id") Integer id)
  {
    return cardService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    cardService.deleteById(id);
  }
}
