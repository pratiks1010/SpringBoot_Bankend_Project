package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.entity.UserAccount;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.UserRepository;
import com.app.userDto.UserDto;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUserAccount(UserDto userDto) {
        UserAccount newAccount = mapper.map(userDto, UserAccount.class);
//        newAccount.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserAccount newAccountCreated = userRepo.save(newAccount);

        return mapper.map(newAccountCreated, UserDto.class);
    }

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub

		UserAccount accoundFound = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("this invalid id please entre valid id"));
		return mapper.map(accoundFound, UserDto.class);
	}

	@Override
	public String deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		UserAccount userFound = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("this invalid id please entre valid id"));

		userRepo.delete(userFound);
		return "User Deleted SucessFully!!!!";
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userID) {
		// TODO Auto-generated method stub

		UserAccount userAccount = this.userRepo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("this invalid id please entre valid id"));
		userAccount.setUserFullName(userDto.getUserFullName());
		userAccount.setUserName(userDto.getUserName());
		userAccount.setPassword(userDto.getPassword());
		// Update password if provided
//		if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
//			// Encrypt and update the password
//			userAccount.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		}

		return mapper.map(userAccount, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUserList() {
		// TODO Auto-generated method stub

		List<UserAccount> allUser = userRepo.findAll();
		List<UserDto> allUserDto = allUser.stream().map((UserAccount) -> mapper.map(UserAccount, UserDto.class))
				.collect(Collectors.toList());
		return allUserDto;
	}

//	@Override
//	public UserDto USerDtgetUserByUserName(String UserName) {
//		// TODO Auto-generated method stub
//
//		UserAccount findByUserName = userRepo.findByUserName(UserName);
//
//		UserDto userDto = mapper.map(findByUserName, UserDto.class);
//
//		return userDto;
//	}

}
