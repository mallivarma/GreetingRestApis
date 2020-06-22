package com.pailee.solutions.greet.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import com.pailee.solutions.greet.IUserService.UsersService;
import com.pailee.solutions.greet.UsersServiceImpl.UsersServiceImpl;
import com.pailee.solutions.greet.dto.UserDTO;
import com.pailee.solutions.greet.model.CreateUserRequestModel;
import com.pailee.solutions.greet.model.CreateUserResponseModel;
import com.pailee.solutions.greet.model.DeleteUserProfileResponseModel;
import com.pailee.solutions.greet.model.UpdateUserRequestModel;
import com.pailee.solutions.greet.utils.DeleteRequestOperation;
import com.pailee.solutions.greet.utils.DeleteResponseStatus;


@Path("/users")
public class UserResource {
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
	public CreateUserResponseModel createUser(CreateUserRequestModel request) {
		
		System.out.println("Entered into createUser class");
		
		// Prepare UserDTO
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(request, userDto);
        
        // Create new user 
        UsersService service = new UsersServiceImpl();
        UserDTO createdUserProfile = service.createUserDB(userDto);
 
        //Prepare response
         
		CreateUserResponseModel responseModel = new CreateUserResponseModel();
		
		BeanUtils.copyProperties(createdUserProfile, responseModel);
		return responseModel;
	}
	
	//Getting the specified user details
	//@Secured
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public CreateUserResponseModel getUserProfile(@PathParam("id") String id)
    {
    	System.out.println("Entered into getUserProfile GET ID class");
    	
		CreateUserResponseModel returnValue = null;
        
        UsersService userService = new UsersServiceImpl();
        UserDTO userProfile = userService.getUser(id);
                
        returnValue = new CreateUserResponseModel();
        BeanUtils.copyProperties(userProfile, returnValue);
        
        return returnValue;
    }
	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<CreateUserResponseModel> getUsers(@DefaultValue("0") @QueryParam("start") int start, 
            @DefaultValue("50") @QueryParam("limit") int limit) {
  
    	System.out.println("Entered into getUsers GET START LIMIT class");
    	
        UsersService userService = new UsersServiceImpl();
        List<UserDTO> users = userService.getUsers(start, limit);
        
        // Prepare return value 
        List<CreateUserResponseModel> returnValue = new ArrayList<CreateUserResponseModel>();
        for (UserDTO userDto : users) {
        	CreateUserResponseModel userModel = new CreateUserResponseModel();
            BeanUtils.copyProperties(userDto, userModel);
            userModel.setHref("/users/" + userDto.getUserId());
            returnValue.add(userModel);
        }
        
        return returnValue;
 }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CreateUserResponseModel updateUserDetails(@PathParam("id") String id,
            UpdateUserRequestModel userDetails) {
        
    	System.out.println("Entered into updateUserDetails  ID class");
    	
        UsersService userService = new UsersServiceImpl();
        UserDTO storedUserDetails = userService.getUser(id);
        
         // Set only those fields you would like to be updated with this request
        if(userDetails.getFirstName() !=null && !userDetails.getFirstName().isEmpty())
        {
            storedUserDetails.setFirstName(userDetails.getFirstName());  
        }
        storedUserDetails.setLastName(userDetails.getLastName());
        
        // Update User Details
        userService.updateUserDetails(storedUserDetails);
        
        // Prepare return value 
        CreateUserResponseModel returnValue = new CreateUserResponseModel();
        BeanUtils.copyProperties(storedUserDetails, returnValue);


        return returnValue;
 }
    //@Secured
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public DeleteUserProfileResponseModel deleteUserProfile(@PathParam("id") String id) {
    	
    	System.out.println("Entered into deleteUserProfile  ID class");
    	
    	
        DeleteUserProfileResponseModel returnValue = new DeleteUserProfileResponseModel();
        returnValue.setDeleteRequestOperation(DeleteRequestOperation.DELETE);
        
        UsersService userService = new UsersServiceImpl();
        UserDTO storedUserDetails = userService.getUser(id);
 
        userService.deleteUser(storedUserDetails);

        returnValue.setDeleteResponseStatus(DeleteResponseStatus.SUCCESS);
 
        return returnValue;
    }

}
