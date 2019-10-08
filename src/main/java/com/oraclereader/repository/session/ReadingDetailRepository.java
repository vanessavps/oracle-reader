package com.oraclereader.repository.session;

import com.oraclereader.entity.session.ReadingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingDetailRepository extends JpaRepository<ReadingDetail,Integer>
{
}
