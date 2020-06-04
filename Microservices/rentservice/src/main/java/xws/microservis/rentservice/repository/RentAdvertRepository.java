package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.RentAdvert;

@Repository
public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long> {

}
