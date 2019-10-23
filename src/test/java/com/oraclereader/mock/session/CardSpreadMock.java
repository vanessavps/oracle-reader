package com.oraclereader.mock.session;

import com.oraclereader.entity.session.CardSpread;

public class CardSpreadMock
{

  public static CardSpread singleCardSpread()
  {
    CardSpread cardSpread = new CardSpread();
    cardSpread.setId(0);
    cardSpread.setName("Single card spread");

    return cardSpread;
  }

  public static CardSpread threeCardSpread()
  {
    CardSpread cardSpread = new CardSpread();
    cardSpread.setId(1);
    cardSpread.setName("Three card spread");

    return cardSpread;
  }
}
