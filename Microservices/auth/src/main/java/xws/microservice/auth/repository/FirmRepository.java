package xws.microservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xws.microservice.auth.model.Firm;

public interface FirmRepository extends JpaRepository<Firm,Long> {
    Firm findByCid(String cid);
}
