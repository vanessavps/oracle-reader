package com.oraclereader.service.session;

import com.oraclereader.entity.session.Answer;
import com.oraclereader.repository.session.AnswerRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AnswerService implements CrudService<Answer>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(AnswerService.class);

  private final AnswerRepository answerRepository;

  @Autowired
  public AnswerService(AnswerRepository answerRepository)
  {
    this.answerRepository = answerRepository;
  }

  @Override
  public Answer save(Answer answer)
  {
    return answerRepository.save(answer);
  }

  @Override
  public Answer findById(Integer id)
  {
    return answerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Answer " + id + " not found"));
  }

  @Override
  public List<Answer> findAll()
  {
    return answerRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    answerRepository.deleteById(id);
  }
}
