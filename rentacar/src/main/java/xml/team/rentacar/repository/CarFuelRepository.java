package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarFuel;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel, Long> {

	
}
