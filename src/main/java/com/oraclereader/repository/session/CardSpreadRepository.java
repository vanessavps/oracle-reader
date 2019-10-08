package com.oraclereader.repository.session;

import com.oraclereader.entity.session.CardSpread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardSpreadRepository extends JpaRepository<CardSpread,Integer>
{
}
