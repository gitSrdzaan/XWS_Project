package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.rentservice.model.PriceList;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList,Long> {
}
