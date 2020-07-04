package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarModel;
@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

	public List<CarModel> findByModel(String model);
	
	@Query(value ="Select * FROM car_model m  where m.mark_id = :mark_id and m.model = :model",nativeQuery = true)
	public CarModel findByMarkAndModel(@Param("mark_id") Long mark_id, @Param("model") String model);
	
}
