package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xws.microservice.searchservice.model.Transmission;

import java.util.Set;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission,Long> {

    @Query(value = "SELECT t.transmission from transmission t", nativeQuery = true)
    Set<String> findAllTransmission();
}
