package com.oraclereader.service.session;

import com.oraclereader.entity.session.Question;
import com.oraclereader.repository.session.QuestionRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends CrudService<Question>
{
  @Autowired
  public QuestionService(QuestionRepository questionRepository)
  {
    super(questionRepository);
  }
}
