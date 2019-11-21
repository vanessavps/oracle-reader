package com.oraclereader.mock.user;

import com.oraclereader.entity.user.User;

public class UserMock
{
  public static User create(Integer id, String name, String email, String password)
  {
    User user = new User();
    user.setId(id);
    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);

    return user;
  }
}
