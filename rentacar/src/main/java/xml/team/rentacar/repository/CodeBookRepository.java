package xml.team.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xml.team.rentacar.model.Codebook;



@Repository
public interface CodeBookRepository extends JpaRepository<Codebook, Long>{
	
	 
    //User findByUsername(String username);
}
