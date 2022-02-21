package com.spice.communication.usermanagementservice.dao;

import com.spice.communication.usermanagementservice.dao.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User findByUnameAndPass(String uname, String pass);
}
