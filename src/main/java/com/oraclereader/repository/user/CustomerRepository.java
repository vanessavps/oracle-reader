package com.oraclereader.repository.user;

import com.oraclereader.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
}
