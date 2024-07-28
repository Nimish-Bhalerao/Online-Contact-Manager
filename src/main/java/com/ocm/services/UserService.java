package com.ocm.services;

import java.util.List;
import java.util.Optional;

import com.ocm.entites.User;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);
    void deleteUser(String id);

    boolean isUserExist(String id);

    boolean isUserExistByEmail(String email);
    //have to specify the import
    List<User> getAllUsers();
}
