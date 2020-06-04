package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.Firm;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {

}
