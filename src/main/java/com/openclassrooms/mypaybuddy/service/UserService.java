package com.openclassrooms.mypaybuddy.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.openclassrooms.mypaybuddy.model.User;
import com.openclassrooms.mypaybuddy.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
