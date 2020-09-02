package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.rentservice.model.CarFuel;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel,Long> {
}
