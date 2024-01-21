package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserAccount;
import com.app.userDto.UserDto;


@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
	
	
// UserDto findByUserName(String userName);
	
	

}
