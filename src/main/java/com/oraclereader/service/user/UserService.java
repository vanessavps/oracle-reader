package com.oraclereader.service.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.repository.user.UserRepository;
import com.oraclereader.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService implements CrudService<User>
{
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User user)
  {
    return userRepository.save(user);
  }

  @Override
  public User findById(Integer id)
  {
    return userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User " + id + " not found"));
  }

  @Override
  public List<User> findAll()
  {
    return userRepository.findAll();
  }

  @Override
  public void deleteById(Integer id)
  {
    userRepository.deleteById(id);
  }
}
