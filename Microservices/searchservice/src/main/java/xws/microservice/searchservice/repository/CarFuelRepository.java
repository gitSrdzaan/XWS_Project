package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xws.microservice.searchservice.model.CarFuel;

import java.util.Set;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel,Long> {

    @Query(value = "SELECT  c.fuel FROM  car_fuel c", nativeQuery = true)
    Set<String> findAllCarFuel();
}
