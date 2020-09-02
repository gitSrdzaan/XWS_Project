package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.rentservice.model.Transmission;

@Repository
public interface TransmissionRepository  extends JpaRepository<Transmission,Long> {
}
