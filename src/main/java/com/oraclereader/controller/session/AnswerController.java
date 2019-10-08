package com.oraclereader.controller.session;

import com.oraclereader.entity.session.Answer;
import com.oraclereader.service.session.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController
{
  private final AnswerService answerService;

  @Autowired
  public AnswerController(AnswerService answerService)
  {
    this.answerService = answerService;
  }

  @PostMapping
  public Answer create(@RequestBody Answer answer)
  {
    return answerService.save(answer);
  }

  @GetMapping
  public List<Answer> findAll()
  {
    return answerService.findAll();
  }

  @GetMapping("/{id}")
  public Answer findById(@PathVariable("id") Integer id)
  {
    return answerService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    answerService.deleteById(id);
  }
}
