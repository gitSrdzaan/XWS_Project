package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.RentAdvert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long>{

    @Query(value = "SELECT * FROM rent_advert ra   WHERE ra.firm = :firmID AND ra.advert_start_date <= :startDate AND ra.advert_end_date >= :endDate"
            ,nativeQuery = true)
    List<RentAdvert> findByStartEndDate(
            @Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("firmID") Long firmID);
}
