package com.oraclereader.controller.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.service.user.UserService;
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

  @PostMapping
  public User create(@RequestBody User user)
  {
    return userService.save(user);
  }

  @GetMapping
  public List<User> findAll()
  {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") Integer id)
  {
    return userService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)
  {
    userService.deleteById(id);
  }


}
