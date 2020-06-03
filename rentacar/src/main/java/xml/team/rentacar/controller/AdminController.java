package xml.team.rentacar.controller;

import java.util.List;

import xml.team.model.User;
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

import xml.team.rentacar.service.UserDTO;
import xml.team.rentacar.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
 
	@Autowired
	private UserServiceImpl userService;
	
	
    @GetMapping("getAllUsers")
    public ResponseEntity<?> getAllUsers()  {
    	List<xml.team.model.User> users = userService.findAll();
    	if(users==null) {
    		return new ResponseEntity("No users",HttpStatus.BAD_REQUEST);
    	}else {
    		return new  ResponseEntity(users,HttpStatus.OK);
    	}
    			
    }

    
    @GetMapping("getSingleUser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable Long id)  {
    	User user = (User) userService.findById(id);
    	if(user==null) {
    		return new ResponseEntity("No user found",HttpStatus.BAD_REQUEST);
    	}else {
    		return new ResponseEntity(user,HttpStatus.OK);
    	}
    	
        
    }

    
    @PostMapping("addUser")
    public ResponseEntity<?> addUser (@RequestBody User user)  {
    	User u = (User) userService.findById(((xml.team.model.User) user).getId());
    	if (u==null) {
    		try {
    			  u = userService.save(user);
    			  return new ResponseEntity(u,HttpStatus.OK);
    			}
    			catch(Exception e) {
    			  return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    			}
    	
    	}else {
    		return new ResponseEntity("User already added",HttpStatus.BAD_REQUEST);
    	}
    }

   
    @PutMapping("updateUser/{id}")
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable Long id) {
    	User u = (User) userService.findById(id);
    	if(u==null) {
    		return new ResponseEntity("No user with that id",HttpStatus.OK);
    	}else {
    		try {
    		u=userService.update(user);
    		return new ResponseEntity(u,HttpStatus.OK);
    		}catch(Exception e) {
    			return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    		}
    	}
    }

    
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) {
    	User user = (User) userService.findById(id);
    	if(user==null) {
    		return new ResponseEntity("No user found",HttpStatus.BAD_REQUEST);
    	}else {
    		userService.deleteById(id);
    		return new ResponseEntity("User deleted",HttpStatus.OK);
    	}
    	
    }
    
    
}
