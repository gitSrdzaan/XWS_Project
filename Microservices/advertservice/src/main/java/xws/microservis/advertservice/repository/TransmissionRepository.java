

package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xws.microservis.advertservice.model.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {

}

