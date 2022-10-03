package com.example.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
