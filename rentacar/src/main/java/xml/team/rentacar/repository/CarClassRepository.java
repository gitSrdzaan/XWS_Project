package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarClass;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

	public List<CarClass> findByCarClass(String carClass);

	@Query(value = "SELECT c.* FROM car_class c INNER JOIN model_class mc ON c.id = mc.car_class_id "
			+ " WHERE mc.model_id = :model_id and c.car_class = :car_class ", nativeQuery= true)
	public CarClass findByModelAndClass(@Param("model_id")Long id,@Param("car_class") String carClass);
	
	
	
}
