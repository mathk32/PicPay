package com.example.picpay.domain.repository;

import com.example.picpay.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserR extends JpaRepository<User, Integer> {
}
