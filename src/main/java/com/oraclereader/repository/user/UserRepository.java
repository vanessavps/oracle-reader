package com.oraclereader.repository.user;

import com.oraclereader.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{

}
