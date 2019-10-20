package com.oraclereader.repository.session;

import com.oraclereader.entity.session.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>
{
}
