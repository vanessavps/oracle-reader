package com.oraclereader.service.session;

import com.oraclereader.entity.session.Answer;
import com.oraclereader.repository.session.AnswerRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService extends CrudService<Answer>
{
  @Autowired
  public AnswerService(AnswerRepository answerRepository)
  {
    super(answerRepository);
  }
}
