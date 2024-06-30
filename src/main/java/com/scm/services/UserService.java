package com.scm.services;

import com.scm.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserbyId(String id);

    Optional<User> updateuser(User user);

    void deleteuser(String id);

    boolean isUserExist(String id);

    boolean isUserExitByEmail(String email);

    List<User> getAllUsers();

}
