package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
