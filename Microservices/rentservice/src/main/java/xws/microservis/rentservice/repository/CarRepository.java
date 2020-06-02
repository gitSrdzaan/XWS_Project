package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xws.microservis.rentservice.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	
}
