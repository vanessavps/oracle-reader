package com.oraclereader.repository.deck;

import com.oraclereader.entity.deck.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck,Integer>
{
}
