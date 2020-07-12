

package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xws.microservis.advertservice.model.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {

    @Query(value = "Select * from transmission where transsmision.transmission = :transmission", nativeQuery = true)
    Transmission findByName(@Param("transsmision") String transmission);
}

