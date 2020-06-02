package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xws.microservis.rentservice.model.RentRequest;

public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {

}
