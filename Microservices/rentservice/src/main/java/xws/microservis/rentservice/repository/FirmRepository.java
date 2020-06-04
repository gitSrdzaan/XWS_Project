package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.Firm;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {

}
