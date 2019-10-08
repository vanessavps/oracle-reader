package com.oraclereader.controller.session;

import com.oraclereader.entity.session.Question;
import com.oraclereader.service.session.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController
{
  private final QuestionService questionService;

  @Autowired
  public QuestionController(QuestionService questionService)
  {
    this.questionService = questionService;
  }

  @PostMapping
  public Question create(@RequestBody Question question)
  {
    return questionService.save(question);
  }

  @GetMapping
  public List<Question> findAll()
  {
    return questionService.findAll();
  }

  @GetMapping("/{id}")
  public Question findById(@PathVariable("id") Integer id)
  {
    return questionService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    questionService.deleteById(id);
  }
}
