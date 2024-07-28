package com.ocm.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocm.entites.User;
@Repository
public interface UserRepo extends JpaRepository<User,String> {
//methods for db related operation
//custom finder methods
Optional<User> findByEmail(String email);
}
