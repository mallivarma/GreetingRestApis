package com.pailee.solutions.greet.IDAO;

import java.util.List;

import com.pailee.solutions.greet.dto.UserDTO;


public interface UsersDAO {

	void openConnection();
	 UserDTO getUserByUserName(String userName);
	 UserDTO saveUser(UserDTO user);
	 UserDTO getUser(String id);
	 List<UserDTO> getUsers(int start, int limit);
	 void updateUser(UserDTO userProfile);
	 void deleteUser(UserDTO userProfile);
	 UserDTO getUserByEmailToken(String token);
     void closeConnection();
}

