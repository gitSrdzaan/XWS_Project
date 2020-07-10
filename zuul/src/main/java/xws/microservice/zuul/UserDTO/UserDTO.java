package xws.microservice.zuul.UserDTO;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    //private String password;
    private String email;
    private String name;
    private String surname;
    private String city;
    private String state;
}
