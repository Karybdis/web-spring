package com.example.demo.Repository;

import com.example.demo.Entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long>
{
    UserInfo findByRole(String role);
    UserInfo findByUsername(String username);
}
