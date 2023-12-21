package com.openclassrooms.mypaybuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mypaybuddy.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	List<User> findAll();
	Boolean existsByEmail(String email);
	Boolean existsByUsername(String username);
	/*@Query(" select u from User u " +
			" where u.username = ?")*/
	//Optional<User> findUserWithName(String username);

}
