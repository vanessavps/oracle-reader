package com.oraclereader.entity.deck;

import javax.persistence.Entity;
import java.util.List;

//@Entity
public class Deck
{
  private Integer id;
  private String name;
  private String author;
  private String illustrator;
  private String publisher;
  private List<Card> cards;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getIllustrator()
  {
    return illustrator;
  }

  public void setIllustrator(String illustrator)
  {
    this.illustrator = illustrator;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }

  public List<Card> getCards()
  {
    return cards;
  }

  public void setCards(List<Card> cards)
  {
    this.cards = cards;
  }
}
