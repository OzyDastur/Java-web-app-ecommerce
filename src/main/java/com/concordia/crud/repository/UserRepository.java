package com.concordia.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concordia.crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAddress(String emailAddress);
}
