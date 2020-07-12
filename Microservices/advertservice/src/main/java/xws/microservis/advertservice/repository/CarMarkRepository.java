package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.CarMark;


@Repository
public interface CarMarkRepository extends JpaRepository<CarMark, Long> {

	public CarMark findByMark(String mark);
	
	@Query(value = "SELECT * FROM car_mark cm WHERE cm.mark = :mark", nativeQuery = true)
	public CarMark findMark(@Param("mark") String mark);
	
	
	
	
}
