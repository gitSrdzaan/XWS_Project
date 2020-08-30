package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.RentRequestBundle;

@Repository
public interface RentRequestBundleRepository extends JpaRepository<RentRequestBundle, Long> {

}
