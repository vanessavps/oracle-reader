package com.oraclereader.repository.user;

import com.oraclereader.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository
 */
public interface UserRepository extends JpaRepository<User,Integer>
{

}
