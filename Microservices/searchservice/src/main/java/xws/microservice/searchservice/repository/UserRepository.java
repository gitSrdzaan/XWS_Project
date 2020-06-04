package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	

}
