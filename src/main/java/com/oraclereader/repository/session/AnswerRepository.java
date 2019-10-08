package com.oraclereader.repository.session;

import com.oraclereader.entity.session.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>
{
}
