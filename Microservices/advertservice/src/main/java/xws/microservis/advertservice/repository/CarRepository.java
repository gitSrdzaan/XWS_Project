package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.advertservice.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car , Long> {

}
