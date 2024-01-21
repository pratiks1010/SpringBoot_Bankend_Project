package com.app.service;

import java.util.List;

import com.app.userDto.UserDto;

public interface UserService {

	UserDto createUserAccount(UserDto userDto);

	UserDto getUserById(Integer userId);

	String deleteUserById(Integer userId);

	UserDto updateUser(UserDto userDto, Integer userID);

	List<UserDto> getAllUserList();

//	UserDto USerDtgetUserByUserName(String UserName);

}
