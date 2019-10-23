package com.oraclereader.service.session;

import com.oraclereader.entity.session.ReadingDetail;
import com.oraclereader.repository.session.ReadingDetailRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingDetailService extends CrudService<ReadingDetail>
{
  @Autowired
  public ReadingDetailService(ReadingDetailRepository readingDetailRepository)
  {
    super(readingDetailRepository);
  }
}
