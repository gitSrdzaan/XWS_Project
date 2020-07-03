package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.RentAdvert;

@Repository
public interface RentAdvertRepository extends JpaRepository<RentAdvert, Long> {

}
