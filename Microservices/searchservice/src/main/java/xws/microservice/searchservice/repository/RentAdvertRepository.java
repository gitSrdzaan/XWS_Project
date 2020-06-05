package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.RentAdvert;

@Repository
public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long>{

	
	
}
