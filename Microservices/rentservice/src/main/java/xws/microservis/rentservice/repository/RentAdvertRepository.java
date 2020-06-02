package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xws.microservis.rentservice.model.RentAdvert;

public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long> {

}
