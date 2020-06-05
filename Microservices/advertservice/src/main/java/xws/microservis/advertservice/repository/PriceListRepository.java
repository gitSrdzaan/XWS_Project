package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.advertservice.model.PriceList;


@Repository
public interface PriceListRepository extends JpaRepository<PriceList , Long> {

}
