package xws.microservis.advertservice.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import xws.microservis.advertservice.model.RentAdvert;
import xws.microservis.advertservice.model.RentRequest;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface AdvertRepository extends JpaRepository<RentAdvert, Long> {

	@Lock(LockModeType.PESSIMISTIC_READ)
	RentAdvert save(RentAdvert advert);

	@Query(value = "SELECT * FROM rent_advert ra WHERE ra.user_id = :id",nativeQuery = true)
	ArrayList<RentAdvert> findByUserId(@Param("id") Long id);

}
