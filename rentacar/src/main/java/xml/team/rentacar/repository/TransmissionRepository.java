package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.Transmission;
@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {

}
