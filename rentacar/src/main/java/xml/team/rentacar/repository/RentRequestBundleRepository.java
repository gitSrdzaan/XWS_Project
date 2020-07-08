package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xml.team.rentacar.model.RentRequestBundle;

@Repository
public interface RentRequestBundleRepository extends JpaRepository<RentRequestBundle, Long> {

}
