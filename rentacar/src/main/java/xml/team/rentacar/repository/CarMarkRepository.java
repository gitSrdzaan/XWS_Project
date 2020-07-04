package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.CarMark;

@Repository
public interface CarMarkRepository extends JpaRepository<CarMark, Long> {

	public List<CarMark> findByMark(String mark);
	
	
	
}
