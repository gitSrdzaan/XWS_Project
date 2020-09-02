package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.model.Owner;
import xws.microservice.searchservice.model.User;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {


    @Query(value = "SELECT f.* FROM owner o inner join firm f on o.id = f.firm_id WHERE o.id = :owner_id",nativeQuery = true)
    Firm findOwnerFirm(@Param("owner_id") Long owner_id);

    @Query(value = "SELECT u.* FROM owner o inner join user u on o.id = u.user_id WHERE o.id = :owner_id",nativeQuery = true)
    User findOwnerUser(@Param("owner_id") Long owner_id);
}
