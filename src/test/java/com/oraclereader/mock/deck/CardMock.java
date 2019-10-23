package com.oraclereader.mock.deck;

import com.oraclereader.entity.deck.Card;

/**
 * Cards to use on tests
 */
public class CardMock
{

  public static Card createTheFool()
  {
    Card theFool = new Card();
    theFool.setId(0);
    theFool.setName("The Fool");
    theFool.setDescription("Starting a new adventure");
    theFool.setDetail("All the meaning of the Fool card");

    return theFool;
  }


  public static Card createTheMagician()
  {
    Card theMagician = new Card();
    theMagician.setId(1);
    theMagician.setName("The Magician");
    theMagician.setDescription("New talents");
    theMagician.setDetail("All the meaning of the Magician card");

    return theMagician;
  }


  public static Card createTheEmpress()
  {
    Card theEmpress = new Card();
    theEmpress.setId(3);
    theEmpress.setName("The Empress");
    theEmpress.setDescription("Action!");
    theEmpress.setDetail("All the meaning of the Empress card");

    return theEmpress;
  }


}
