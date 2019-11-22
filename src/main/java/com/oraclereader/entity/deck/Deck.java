package com.oraclereader.entity.deck;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
public class Deck
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String author;
  private String illustrator;
  private String publisher;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "deck_card",
      joinColumns = @JoinColumn(name = "deck_id"),
      inverseJoinColumns = @JoinColumn(name = "card_id")
  )
  @Cascade(ALL)
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

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
      return false;

    if (this == obj)
      return true;

    Deck deck = (Deck) obj;

    return this.id.equals(deck.getId()) &&
        StringUtils.equals(this.name, deck.getName()) &&
        StringUtils.equals(this.author, deck.getAuthor()) &&
        StringUtils.equals(this.illustrator, deck.getIllustrator()) &&
        StringUtils.equals(this.publisher, deck.getPublisher()) &&
        CollectionUtils.isEmpty(this.cards) ? CollectionUtils.isEmpty(deck.getCards()) : this.cards.equals(deck.getCards());
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder(5, 3)
        .append(this.id)
        .append(this.name)
        .append(this.author)
        .append(this.illustrator)
        .append(this.publisher)
        .append(this.cards)
        .toHashCode();
  }
}
