package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarClass;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

	public List<CarClass> findByCarClass(String carClass);
	
	
	
}
