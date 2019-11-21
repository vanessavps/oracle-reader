package com.oraclereader.mock.user;

import com.oraclereader.entity.user.Customer;

import java.time.LocalDateTime;

public class CustomerMock
{
  public static Customer create(Integer id, String name, String email, String phone)
  {
    Customer customer = new Customer();
    customer.setId(id);
    customer.setName(name);
    customer.setEmail(email);
    customer.setPhone(phone);
    customer.setBirthdate(LocalDateTime.now());

    return customer;
  }
}
