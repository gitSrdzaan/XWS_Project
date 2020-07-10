package xws.microservice.searchservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xws.microservice.searchservice.dto.FirmDTO;
import xws.microservice.searchservice.dto.UserDTO;
import xws.microservice.searchservice.model.User;
import xws.microservice.searchservice.services.UserService;

@RestController
@RequestMapping(value = "/korisnik")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/prikaz/{userID}")
    public ResponseEntity<?> getUserInfo(@PathVariable Long userID){

        UserDTO userDTO = userService.findUser(userID);
        if(userDTO == null){
            return  new ResponseEntity<>("Korisnik ne postoji", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

}
