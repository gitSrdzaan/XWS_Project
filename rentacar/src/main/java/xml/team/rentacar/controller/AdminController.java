package xml.team.rentacar.controller;

import org.apache.catalina.User;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
 
	
    @GetMapping()
    public ResponseEntity<?> getAllUsers()  {
        return null;
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable Long id)  {
        return null;
    }

    
    @PostMapping()
    public ResponseEntity<?> addUser (@RequestBody User user)  {
        return null;
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable Long id) {
        return null;
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) {
        return null;
    }
    
    
}
