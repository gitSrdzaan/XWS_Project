package xml.team.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

	public List<PriceList> findByFirm(Firm firm);
	
	
}
