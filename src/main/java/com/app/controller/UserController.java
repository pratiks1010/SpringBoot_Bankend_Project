package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserService;
import com.app.userDto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	  @PostMapping("/newUser")
	    private ResponseEntity<UserDto> createUserDb(@RequestBody UserDto userDto) {
	        UserDto createUserAccount = userService.createUserAccount(userDto);
	        return new ResponseEntity<>(createUserAccount, HttpStatus.OK);
	    }


	@GetMapping("/users/{userId}")
	private ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
		UserDto userById = userService.getUserById(userId);

		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userid}")
	private String deleteUserById(@PathVariable Integer userid) {
		return userService.deleteUserById(userid);
	}

	@PutMapping("/update/{id}")
	private UserDto updateUserDetails(@RequestBody UserDto userDto, @PathVariable Integer id) {
		UserDto updateUser = userService.updateUser(userDto, id);

		return updateUser;
	}

	@GetMapping("/UserList")
	private ResponseEntity<List<UserDto>> getAllList() {
		List<UserDto> userDtoList = this.userService.getAllUserList();

		return new ResponseEntity<List<UserDto>>(userDtoList, HttpStatus.OK);
	}

}
