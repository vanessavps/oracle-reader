package com.oraclereader.service.user;

import com.oraclereader.entity.user.Customer;
import com.oraclereader.repository.user.CustomerRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends CrudService<Customer>
{
  @Autowired
  public CustomerService(CustomerRepository customerRepository)
  {
    super(customerRepository);
  }
}
