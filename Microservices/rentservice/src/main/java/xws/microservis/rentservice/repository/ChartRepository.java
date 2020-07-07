package xws.microservis.rentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xws.microservis.rentservice.model.Chart;

@Repository
public interface ChartRepository extends JpaRepository<Chart,Long> {


}
