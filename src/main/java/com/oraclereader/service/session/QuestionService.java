package com.oraclereader.service.session;

import com.oraclereader.entity.session.Question;
import com.oraclereader.repository.session.QuestionRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuestionService implements CrudService<Question>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);

  private final QuestionRepository questionRepository;

  @Autowired
  public QuestionService(QuestionRepository questionRepository)
  {
    this.questionRepository = questionRepository;
  }

  @Override
  public Question save(Question question)
  {
    return questionRepository.save(question);
  }

  @Override
  public Question findById(Integer id)
  {
    return questionRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Question " + id + " not found"));
  }

  @Override
  public List<Question> findAll()
  {
    return questionRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    questionRepository.deleteById(id);
  }
}
