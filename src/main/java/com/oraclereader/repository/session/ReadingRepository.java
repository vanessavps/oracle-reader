package com.oraclereader.repository.session;

import com.oraclereader.entity.session.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ReadingRepository extends JpaRepository<Reading,Integer>
{
}
