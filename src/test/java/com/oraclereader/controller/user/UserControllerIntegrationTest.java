package com.oraclereader.controller.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.oraclereader.Application;
import com.oraclereader.entity.user.User;
import com.oraclereader.mock.user.UserMock;
import com.oraclereader.repository.user.UserRepository;
import com.oraclereader.util.ObjectConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest
{
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MockMvc mvc;

  private User user1;
  private User user2;
  private User user3;

  @Before
  public void setUp()
  {
    user1 = UserMock.createUser(1, "Mario", "mario@gmail.com", "itsMeMario");
    userRepository.save(user1);

    user2 = UserMock.createUser(2, "Luigi", "luigi@gmail.com", "luigisMansion");
    userRepository.save(user2);

    user3 = UserMock.createUser(3, "Bowser", "bowser@hotmail.com", "yah!");
    userRepository.save(user3);
  }

  @Test
  public void createUserTest() throws Exception
  {
    User user = UserMock.createUser(4, "Donkey Kong", "dk@gmail.com", "uhuu!");
    String userJson = ObjectConverter.convertObjectToJson(user);

    mvc.perform(post("/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(userJson))
        .andExpect(status().isOk());

    User savedUser = userRepository.findById(4)
        .orElse(null);
    assertNotNull(savedUser);
    assertEquals(user, savedUser);
  }

  @Test
  public void findAllTest() throws Exception
  {
    String result = mvc.perform(get("/user"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    List<User> users = ObjectConverter.convertJsonToObjectList(result, new TypeReference<List<User>>() {});
    assertEquals(3, users.size());
  }

  @Test
  public void findByIdTest() throws Exception
  {
    String result = mvc.perform(get("/user/{id}", 2))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    User user = ObjectConverter.convertJsonToObject(result, User.class);
    assertEquals(user2, user);
  }

  @Test
  public void deleteByIdTest() throws Exception
  {
    int id = 3;

    mvc.perform(delete("/user/{id}", id))
        .andExpect(status().isOk());

    User user = userRepository.findById(id)
        .orElse(null);
    assertNull(user);
  }
}
