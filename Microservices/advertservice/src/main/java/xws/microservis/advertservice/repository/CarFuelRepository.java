
package xws.microservis.advertservice.repository;

package xws.microservis.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.advertservice.model.CarFuel;


@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel, Long> {

	
}

