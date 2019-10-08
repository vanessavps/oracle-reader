package com.oraclereader.controller.session;

import com.oraclereader.entity.session.Reading;
import com.oraclereader.service.session.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reading")
public class ReadingController
{
  private final ReadingService readingService;

  @Autowired
  public ReadingController(ReadingService readingService)
  {
    this.readingService = readingService;
  }

  @PostMapping
  public Reading create(@RequestBody Reading reading)
  {
    return readingService.save(reading);
  }

  @GetMapping
  public List<Reading> findAll()
  {
    return readingService.findAll();
  }

  @GetMapping("/{id}")
  public Reading findById(@PathVariable("id") Integer id)
  {
    return readingService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    readingService.deleteById(id);
  }
}
