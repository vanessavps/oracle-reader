package com.oraclereader.service.user;

import com.oraclereader.entity.user.Customer;
import com.oraclereader.repository.user.CustomerRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService implements CrudService<Customer>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository)
  {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer save(Customer customer)
  {
    return customerRepository.save(customer);
  }

  @Override
  public Customer findById(Integer id)
  {
    return customerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found"));
  }

  @Override
  public List<Customer> findAll()
  {
    return customerRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    customerRepository.deleteById(id);
  }
}
