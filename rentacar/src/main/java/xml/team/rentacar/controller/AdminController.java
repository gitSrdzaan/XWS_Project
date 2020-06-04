package xml.team.rentacar.controller;

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

import xml.team.rentacar.model.Codebook;
import xml.team.rentacar.model.User;
import xml.team.rentacar.service.CodebookService;
import xml.team.rentacar.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user/")
public class AdminController {
 
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private CodebookService codebookService;
	
	
    @GetMapping("getAllUsers")
    public ResponseEntity<?> getAllUsers()  {
    	List<xml.team.rentacar.model.User> users = userService.findAll();
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
    	User u = (User) userService.findById(((xml.team.rentacar.model.User) user).getId());
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
    
    @PostMapping("addInCodebook/{id}/{s1}/{s2}/{s3}/{s4}")
    public ResponseEntity<?> addInCodebook (@PathVariable Long id, @PathVariable String s1, @PathVariable String s2, @PathVariable String s3,@PathVariable String s4)  {
    	
    	Codebook c = codebookService.getOne(id);
    	if (c==null) {
    		return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    	
    	}else {
    		c=codebookService.update(id, s1, s2, s3, s4);
    		return new ResponseEntity(c,HttpStatus.OK);
    	}
    }
    
    @DeleteMapping("deleteFromCodebook/{id}/{s1}/{s2}/{s3}/{s4}")
    public ResponseEntity<?> deleteFromCodebook(@PathVariable Long id, @PathVariable String s1, @PathVariable String s2, @PathVariable String s3,@PathVariable String s4)  {
    	
    	Codebook c = codebookService.getOne(id);
    	if (c==null) {
    		return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    	
    	}else {
    		codebookService.delete(id, s1, s2, s3, s4);
    		return new ResponseEntity("Deleted from Codebook",HttpStatus.OK);
    	}
    }
    
    
}
