package com.oraclereader.controller.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oraclereader.Application;
import com.oraclereader.entity.user.Customer;
import com.oraclereader.mock.user.CustomerMock;
import com.oraclereader.repository.user.CustomerRepository;
import com.oraclereader.util.ObjectConverter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerControllerIntegrationTest
{
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Customer customer1;
  private Customer customer2;
  private Customer customer3;

  @Before
  public void setUp()
  {
    customer1 = CustomerMock.create(1, "Mario", "mario@gmail.com", "itsMeMario");
    customerRepository.save(customer1);

    customer2 = CustomerMock.create(2, "Luigi", "luigi@gmail.com", "luigisMansion");
    customerRepository.save(customer2);

    customer3 = CustomerMock.create(3, "Bowser", "bowser@hotmail.com", "yah!");
    customerRepository.save(customer3);
  }

  @Test
  public void createTest() throws Exception
  {
    Customer customer = CustomerMock.create(4, "Donkey Kong", "dk@gmail.com", "uhuu!");
    String customerJson = ObjectConverter.convertObjectToJson(mapper, customer);

    mvc.perform(post("/customer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(customerJson))
        .andExpect(status().isOk());

    Customer savedCustomer = customerRepository.findById(4)
        .orElse(null);
    assertNotNull(savedCustomer);
    assertEquals(customer, savedCustomer);
  }

  @Test
  public void findAllTest() throws Exception
  {
    String result = mvc.perform(get("/customer"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<Customer> customers = ObjectConverter.convertJsonToObjectList(mapper, result, new TypeReference<List<Customer>>() {});
    assertEquals(3, customers.size());
  }

  @Test
  public void findByIdTest() throws Exception
  {
    String result = mvc.perform(get("/customer/{id}", 2))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Customer customer = ObjectConverter.convertJsonToObject(mapper, result, Customer.class);
    assertEquals(customer2, customer);
  }

  @Test
  public void findByIdInvalidIdTest() throws Exception
  {
    thrown.expect(EntityNotFoundException.class);
    thrown.expectMessage("Object 50 not found");

    try
    {
      mvc.perform(get("/customer/{id}", 50));
    } catch (NestedServletException e)
    {
      throw (Exception) e.getCause();
    }
  }

  @Test
  public void deleteByIdTest() throws Exception
  {
    int id = 3;

    mvc.perform(delete("/customer/{id}", id))
        .andExpect(status().isOk());

    Customer customer = customerRepository.findById(id)
        .orElse(null);
    assertNull(customer);
  }
}
