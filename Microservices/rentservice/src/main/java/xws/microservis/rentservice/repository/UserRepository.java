package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xws.microservis.rentservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
