package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.RentRequestBundle;

@Repository
public interface RentRequestBundleRepository extends JpaRepository<RentRequestBundle, Long> {

}
