package com.pailee.solutions.greet.IUserService;

import java.util.List;

import com.pailee.solutions.greet.dto.UserDTO;

public interface UsersService {
	
	UserDTO createUserDB(UserDTO dto);
	UserDTO getUser(String id);
	UserDTO getUserByUserName(String userName);
	List<UserDTO> getUsers(int start, int limit);
	void updateUserDetails(UserDTO userDetails);
	void deleteUser(UserDTO userDto);
	boolean verifyEmail(String token);
}
