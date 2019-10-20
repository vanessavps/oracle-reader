package com.oraclereader.controller.session;

import com.oraclereader.entity.session.ReadingDetail;
import com.oraclereader.service.session.ReadingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reading-detail")
public class ReadingDetailController
{
  private final ReadingDetailService readingDetailService;

  @Autowired
  public ReadingDetailController(ReadingDetailService readingDetailService)
  {
    this.readingDetailService = readingDetailService;
  }

  @PostMapping
  public ReadingDetail create(@RequestBody ReadingDetail readingDetail)
  {
    return readingDetailService.save(readingDetail);
  }

  @GetMapping
  public List<ReadingDetail> findAll()
  {
    return readingDetailService.findAll();
  }

  @GetMapping("/{id}")
  public ReadingDetail findById(@PathVariable("id") Integer id)
  {
    return readingDetailService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    readingDetailService.deleteById(id);
  }
}
