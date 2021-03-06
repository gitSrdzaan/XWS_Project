package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	
}
