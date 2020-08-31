package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.RentRequest;

import java.util.ArrayList;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {
    @Query(value = "SELECT * FROM rent_request rr inner join rent_advert ra on rr.rentAdvert_id = ra.id " +
            " WHERE ra.user_id = :user_id",nativeQuery = true)
   public ArrayList<RentRequest> findAllByUser(@Param("user_id") Long id);
}
