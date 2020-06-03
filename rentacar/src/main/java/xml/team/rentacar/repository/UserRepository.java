package xml.team.rentacar.repository;

import xml.team.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Lock(LockModeType.PESSIMISTIC_READ)
 
    User findByUsername(String username);
 
    //Optional<Hotel> findByAddress(String address);
 
   
}
