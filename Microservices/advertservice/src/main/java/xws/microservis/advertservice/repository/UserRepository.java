package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
