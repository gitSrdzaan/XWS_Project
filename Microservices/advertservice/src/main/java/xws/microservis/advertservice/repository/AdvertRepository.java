package xws.microservis.advertservice.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import xws.microservis.advertservice.model.Advert;


@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

	@Lock(LockModeType.PESSIMISTIC_READ)
	Advert save(Advert advert);
	
}
