package com.oraclereader.service.user;

import com.oraclereader.entity.user.User;
import com.oraclereader.repository.user.UserRepository;
import com.oraclereader.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User>
{
  @Autowired
  public UserService(UserRepository userRepository)
  {
    super(userRepository);
  }
}
