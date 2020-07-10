package xws.microservice.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import xws.microservice.zuul.UserDTO.UserDTO;


@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/auth/verify/{token}")
    boolean verify(@PathVariable("token") String token);

    @GetMapping("/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable Long id,
                                    @RequestHeader("x-auth") String auth);
}
