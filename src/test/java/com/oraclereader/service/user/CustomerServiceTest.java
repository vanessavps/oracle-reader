package com.oraclereader.service.user;

import com.oraclereader.entity.user.Customer;
import com.oraclereader.mock.user.CustomerMock;
import com.oraclereader.repository.user.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomerService.class)
public class CustomerServiceTest
{
  @Autowired
  private CustomerService customerService;

  @MockBean
  private CustomerRepository customerRepository;

  @Test
  public void saveTest()
  {
    Customer customer = CustomerMock.create(1, "Rick Sanchez", "rick@sanchez.com", "+55 1454 5561");
    customerService.save(customer);

    verify(customerRepository, times(1)).save(customer);
  }

  @Test
  public void findByIdTest()
  {
    Customer customer = CustomerMock.create(2, "Morty Smith", "morty@smith.com", "+54 66655 321");

    when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
    customerService.findById(customer.getId());

    verify(customerRepository, times(1)).findById(customer.getId());
  }

  @Test
  public void findAllTest()
  {
    Customer customer1 = CustomerMock.create(1, "Rick Sanchez", "rick@sanchez.com", "+55 1113 45641");
    Customer customer2 = CustomerMock.create(2, "Morty Smith", "morty@smith.com", "+55 1231 45647");
    Customer customer3 = CustomerMock.create(3, "Summer Smith", "summer@smith.com", "+64 3105 5405");

    List<Customer> expectedResult = Arrays.asList(customer1, customer2, customer3);
    when(customerRepository.findAll()).thenReturn(expectedResult);

    List<Customer> result = customerService.findAll();

    verify(customerRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    Customer customer = CustomerMock.create(3, "Summer Smith", "summer@smith.com", "+64 9999 5561");
    customerService.deleteById(customer.getId());

    verify(customerRepository, times(1)).deleteById(customer.getId());
  }


}
