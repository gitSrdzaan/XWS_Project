package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.PriceList;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

	
	
}
