package com.oraclereader.mock.deck;

import com.oraclereader.entity.deck.Card;
import com.oraclereader.entity.deck.Deck;

import java.util.Arrays;
import java.util.List;

/**
 * Decks to use on test
 */
public class DeckMock
{

  public static Deck createTarotDeck()
  {
    Deck deck = new Deck();
    deck.setCards(createCards());
    deck.setName("Simple Tarot");

    return deck;
  }

  public static Deck createMoonologyDeck()
  {
    Deck deck = new Deck();
    deck.setName("Moonology Oracle without cards");
    return deck;
  }


  private static List<Card> createCards()
  {
    Card theFool = CardMock.createTheFool();
    Card theMagician = CardMock.createTheMagician();
    Card theEmpress = CardMock.createTheEmpress();

    return Arrays.asList(theFool, theMagician, theEmpress);
  }

}
