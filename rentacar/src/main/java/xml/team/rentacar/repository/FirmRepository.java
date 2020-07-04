package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.Firm;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {

}
