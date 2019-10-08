package com.oraclereader.controller.deck;

import com.oraclereader.entity.deck.Deck;
import com.oraclereader.service.deck.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController
{
  private final DeckService deckService;

  @Autowired
  public DeckController(DeckService deckService)
  {
    this.deckService = deckService;
  }

  @PostMapping
  public Deck create(@RequestBody Deck deck)
  {
    return deckService.save(deck);
  }

  @GetMapping
  public List<Deck> findAll()
  {
    return deckService.findAll();
  }

  @GetMapping("/{id}")
  public Deck findById(@PathVariable("id") Integer id)
  {
    return deckService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    deckService.deleteById(id);
  }
}
