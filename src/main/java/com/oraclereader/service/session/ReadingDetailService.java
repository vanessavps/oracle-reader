package com.oraclereader.service.session;

import com.oraclereader.entity.session.ReadingDetail;
import com.oraclereader.repository.session.ReadingDetailRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReadingDetailService implements CrudService<ReadingDetail>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(ReadingDetailService.class);

  private final ReadingDetailRepository readingDetailRepository;

  @Autowired
  public ReadingDetailService(ReadingDetailRepository readingDetailRepository)
  {
    this.readingDetailRepository = readingDetailRepository;
  }

  @Override
  public ReadingDetail save(ReadingDetail readingDetail)
  {
    return readingDetailRepository.save(readingDetail);
  }

  @Override
  public ReadingDetail findById(Integer id)
  {
    return readingDetailRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Reading detail " + id + " not found"));
  }

  @Override
  public List<ReadingDetail> findAll()
  {
    return readingDetailRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    readingDetailRepository.deleteById(id);
  }
}
