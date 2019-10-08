package com.oraclereader.service.session;

import com.oraclereader.entity.session.Reading;
import com.oraclereader.repository.session.ReadingRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReadingService implements CrudService<Reading>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(ReadingService.class);

  private final ReadingRepository readingRepository;

  @Autowired
  public ReadingService(ReadingRepository readingRepository)
  {
    this.readingRepository = readingRepository;
  }

  @Override
  public Reading save(Reading answer)
  {
    return readingRepository.save(answer);
  }

  @Override
  public Reading findById(Integer id)
  {
    return readingRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Reading " + id + " not found"));
  }

  @Override
  public List<Reading> findAll()
  {
    return readingRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    readingRepository.deleteById(id);
  }

}
