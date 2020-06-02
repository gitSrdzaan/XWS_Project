package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xws.microservis.rentservice.model.Firm;

public interface FirmRepository extends JpaRepository<Firm, Long> {

}
