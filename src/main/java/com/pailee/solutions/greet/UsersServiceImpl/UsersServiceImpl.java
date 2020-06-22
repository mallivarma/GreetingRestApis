package com.pailee.solutions.greet.UsersServiceImpl;

import java.util.List;


import com.pailee.solutions.greet.DAOImpl.UsersDAOImpl;
import com.pailee.solutions.greet.IDAO.UsersDAO;
import com.pailee.solutions.greet.IUserService.UsersService;
import com.pailee.solutions.greet.dto.UserDTO;
import com.pailee.solutions.greet.exceptions.CouldNotCreateRecordException;
import com.pailee.solutions.greet.exceptions.CouldNotDeleteRecordException;
import com.pailee.solutions.greet.exceptions.CouldNotUpdateRecordException;
import com.pailee.solutions.greet.exceptions.EmailVerificationException;
import com.pailee.solutions.greet.exceptions.NoRecordFoundException;
import com.pailee.solutions.greet.utils.AmazonSendEmail;
import com.pailee.solutions.greet.utils.GreetErrorMessages;
import com.pailee.solutions.greet.utils.UserProfileUtils;

public class UsersServiceImpl implements UsersService {

	private UsersDAO database;

	public UsersServiceImpl() {
		this.database = new UsersDAOImpl();
	}

	UserProfileUtils userProfileUtils = new UserProfileUtils();

	@Override
	public UserDTO createUserDB(UserDTO userDTO) {

		UserDTO returnValue = null;

		// Validate the required fields
		userProfileUtils.validateRequiredFields(userDTO);

		// Check if user already exists
		UserDTO existingUser = this.getUserByUserName(userDTO.getEmail());
		if (existingUser != null) {
			throw new CouldNotCreateRecordException(GreetErrorMessages.RECORD_ALREADY_EXISTS.name());
		}

		// Generate secure public user id
		String userId = userProfileUtils.generateUserId(30);
		userDTO.setUserId(userId);

		// Generate salt
		String salt = userProfileUtils.getSalt(30);
		// Generate secure password
		String encryptedPassword = userProfileUtils.generateSecurePassword(userDTO.getPassword(), salt);
		userDTO.setSalt(salt);
		userDTO.setEncryptedPassword(encryptedPassword);
		
		//
		userDTO.setEmailVerificationStatus(false);
		userDTO.setEmailVerificationToken(userProfileUtils.generateEmailverificationToken(30));

		// Record data into a database
		returnValue = this.saveUser(userDTO);

		//new AmazonSendEmail().verifyEmail(userDTO);

		// Return back the user profile
		return returnValue;

	}

	public UserDTO getUserByUserName(String userName) {
		UserDTO userDto = null;

		if (userName == null || userName.isEmpty()) {
			return userDto;
		}

		// Connect to database
		try {
			this.database.openConnection();
			userDto = this.database.getUserByUserName(userName);
		} finally {
			this.database.closeConnection();
		}

		return userDto;
	}
	
	
	public UserDTO getUser(String id) {
        UserDTO returnValue = null;
        try {
            this.database.openConnection();
            returnValue = this.database.getUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new NoRecordFoundException(GreetErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        } finally {
            this.database.closeConnection();
        }
        return returnValue;
    }
	

	private UserDTO saveUser(UserDTO user) {
		UserDTO returnValue = null;
		// Connect to database
		try {
			this.database.openConnection();
			returnValue = this.database.saveUser(user);
		} finally {
		}

		return returnValue;
	}
	
	@Override
    public List<UserDTO> getUsers(int start, int limit) {

        List<UserDTO> users = null;

        // Get users from database
        try {
            this.database.openConnection();
            users = this.database.getUsers(start, limit);
        } finally {
            this.database.closeConnection();
        }

        return users;
    }

    public void updateUserDetails(UserDTO userDetails) {
        try {
            // Connect to database 
            this.database.openConnection();
            // Update User Details
            this.database.updateUser(userDetails);

        } catch (Exception ex) {
            throw new CouldNotUpdateRecordException(ex.getMessage());
        } finally {
            this.database.closeConnection();
        }
    }

    public void deleteUser(UserDTO userDto) {
        try {
            this.database.openConnection();
            this.database.deleteUser(userDto);
        } catch (Exception ex) {
            throw new CouldNotDeleteRecordException(ex.getMessage());
        } finally {
            this.database.closeConnection();
        }

        this.database.closeConnection();
        // Verify that user is deleted
        try {
            userDto = getUser(userDto.getUserId());
        } catch (NoRecordFoundException ex) {
            userDto = null;
        }

        if (userDto != null) {
            throw new CouldNotDeleteRecordException(
                    GreetErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage());
        }
    }

	@Override
	public boolean verifyEmail(String token) {
		 boolean returnValue = false;

	        if (token == null || token.isEmpty()) {
	            throw new EmailVerificationException(GreetErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
	        }

	        try {

	            UserDTO storedUserRecord = getUserByEmailToken(token);

	            if (storedUserRecord == null) {
	                return returnValue;
	            }

	            // Update user Reccord
	            storedUserRecord.setEmailVerificationStatus(true);
	            storedUserRecord.setEmailVerificationToken(null);

	            updateUserDetails(storedUserRecord);

	            returnValue = true;

	        } catch (Exception ex) {
	            throw new EmailVerificationException(ex.getMessage());
	        }

	        return returnValue;
	}
	private UserDTO getUserByEmailToken(String token) {
        UserDTO returnValue;
        try {
            this.database.openConnection();
            returnValue = this.database.getUserByEmailToken(token);

        } finally {
            this.database.closeConnection();
        }
        return returnValue;
    }

}
