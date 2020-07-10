package xws.microservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xws.microservice.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
