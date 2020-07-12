
package xws.microservis.advertservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.CarFuel;


@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel, Long> {

    @Query(value = "Select * from car_fuel where car_fuel.fuel = :carFuel",nativeQuery=true)
    CarFuel findByName(@Param("carFuel")String carFuel);
}

