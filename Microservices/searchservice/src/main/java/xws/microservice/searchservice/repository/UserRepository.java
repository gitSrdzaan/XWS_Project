package xws.microservice.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xws.microservice.searchservice.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value ="SELECT * FROM user u WHERE u.user_country = :country and u.user_city = :city ",nativeQuery = true)
    List<User> findByCountryAndCity(@Param("country")String country, @Param("city") String city);


}
