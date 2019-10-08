package com.oraclereader.controller.user;


import com.oraclereader.entity.user.Customer;
import com.oraclereader.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService)
  {
    this.customerService = customerService;
  }

  @PostMapping
  public Customer create(@RequestBody Customer customer)
  {
    return customerService.save(customer);
  }

  @GetMapping
  public List<Customer> findAll()
  {
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  public Customer findById(@PathVariable("id") Integer id)
  {
    return customerService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    customerService.deleteById(id);
  }
}
