package xml.team.rentacar.controller;

import java.util.List;

import org.apache.catalina.User;
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
        return null;
    }

   
    @PutMapping("updateUser/{id}")
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable Long id) {
        return null;
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
