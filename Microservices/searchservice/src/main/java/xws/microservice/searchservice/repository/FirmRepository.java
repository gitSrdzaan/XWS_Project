package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.Firm;

import java.util.List;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {

    @Query(value ="SELECT * FROM firm f WHERE f.firm_country = :country and f.firm_city = :city ",nativeQuery = true)
    List<Firm> findAllByPlace(@Param("country") String country, @Param("city") String city);
}
