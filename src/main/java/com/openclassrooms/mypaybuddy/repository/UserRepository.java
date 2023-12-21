package com.openclassrooms.mypaybuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mypaybuddy.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	//@Query("select parent from User  where parent = ?");

}
