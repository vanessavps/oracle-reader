package com.oraclereader.service.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.mock.user.UserMock;
import com.oraclereader.repository.user.UserRepository;
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
@ContextConfiguration(classes = UserService.class)
public class UserServiceTest
{
  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void saveTest()
  {
    User user = UserMock.createUser(1, "Rick Sanchez", "rick@sanchez.com", "Pickle_rick!");
    userService.save(user);

    verify(userRepository, times(1)).save(user);
  }

  @Test
  public void findByIdTest()
  {
    User user = UserMock.createUser(2, "Morty Smith", "morty@smith.com", "anatomyPark");

    when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
    userService.findById(user.getId());

    verify(userRepository, times(1)).findById(user.getId());
  }

  @Test
  public void findAllTest()
  {
    User user1 = UserMock.createUser(1, "Rick Sanchez", "rick@sanchez.com", "Pickle_rick!");
    User user2 = UserMock.createUser(2, "Morty Smith", "morty@smith.com", "anatomyPark");
    User user3 = UserMock.createUser(3, "Summer Smith", "summer@smith.com", "CarpeDiem");

    List<User> expectedResult = Arrays.asList(user1, user2, user3);
    when(userRepository.findAll()).thenReturn(expectedResult);

    List<User> result = userService.findAll();

    verify(userRepository, times(1)).findAll();
    assertEquals(expectedResult, result);
  }

  @Test
  public void deleteByIdTest()
  {
    User user = UserMock.createUser(3, "Summer Smith", "summer@smith.com", "CarpeDiem");
    userService.deleteById(user.getId());

    verify(userRepository, times(1)).deleteById(user.getId());
  }


}
