package com.oraclereader.service.session;

import com.oraclereader.entity.session.Reading;
import com.oraclereader.repository.session.ReadingRepository;
import com.oraclereader.service.Crud;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReadingService extends CrudService<Reading>
{
  @Autowired
  public ReadingService(ReadingRepository readingRepository)
  {
    super(readingRepository);
  }
}
