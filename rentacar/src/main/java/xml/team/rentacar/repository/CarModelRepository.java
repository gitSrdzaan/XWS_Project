package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarModel;
@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

	public List<CarModel> findByModel(String model);
	
	
}
