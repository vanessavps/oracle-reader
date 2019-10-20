package com.oraclereader.entity.session;

import com.oraclereader.entity.deck.Card;

import javax.persistence.*;

@Entity
public class Answer
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne
  @JoinColumn(name = "deck_card_id")
  private Card card;
  private String meaning;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Card getCard()
  {
    return card;
  }

  public void setCard(Card card)
  {
    this.card = card;
  }

  public String getMeaning()
  {
    return meaning;
  }

  public void setMeaning(String meaning)
  {
    this.meaning = meaning;
  }
}
