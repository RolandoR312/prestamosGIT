package com.example.prestamos.repository;


import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User,Integer> {

}
