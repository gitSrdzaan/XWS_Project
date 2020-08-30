package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.model.RentAdvert;

import java.util.Optional;

@Repository
public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long> {

    @Query(value ="SELECT f.* FROM rent_advert ra INNER JOIN firm f ON f.id = ra.firm" +
            "WHERE  .id = :id"
            ,nativeQuery = true)
    Firm findFirmByAdvert(@Param("id") Long id) ;
}
