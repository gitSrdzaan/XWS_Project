package xws.microservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xws.microservice.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
