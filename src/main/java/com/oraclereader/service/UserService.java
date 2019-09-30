package com.oraclereader.service;

import com.oraclereader.entity.user.User;
import com.oraclereader.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  public List<User> findAll()
  {
    return userRepository.findAll();
  }

  public User save(User user)
  {
    return userRepository.save(user);
  }
}
