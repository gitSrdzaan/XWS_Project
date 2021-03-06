package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservice.searchservice.model.PriceList;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {
}
