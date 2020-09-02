package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.RentRequest;

import java.util.ArrayList;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {


}
