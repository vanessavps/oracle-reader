package com.oraclereader.controller.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
  private final UserService userService;

  @Autowired
  public UserController(UserService userService)
  {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAll()
  {
    return userService.findAll();
  }

  @PostMapping
  public User create(@RequestBody User user)
  {
    return userService.save(user);
  }

}
