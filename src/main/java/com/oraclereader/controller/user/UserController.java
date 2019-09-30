package com.oraclereader.controller.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @GetMapping
  public List<User> getAll()
  {
    return userRepository.findAll();
  }

  @PostMapping
  public User create(@RequestBody User user)
  {
    return userRepository.save(user);
  }

}
