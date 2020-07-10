package xws.microservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xws.microservice.auth.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
