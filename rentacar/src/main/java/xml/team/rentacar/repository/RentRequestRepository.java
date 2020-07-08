package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xml.team.rentacar.model.RentRequest;
import xml.team.rentacar.model.RentRequestStatus;
import java.util.List;


@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {

    @Query(value ="SELECT * FROM rent_request rr   WHERE   status = :status", nativeQuery = true)
    List<RentRequest> findAllStatus(@Param("status")RentRequestStatus status);
}
