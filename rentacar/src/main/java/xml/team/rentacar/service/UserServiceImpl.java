package xml.team.rentacar.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import xml.team.model.PriceList;
import xml.team.model.User;
import xml.team.rentacar.repository.UserRepository;

@Service
public class UserServiceImpl {
	 	@Autowired
	    private UserRepository userRepository;
	 
	    
	 	
	    public User getOne(Long id) {
	        return userRepository.getOne(id);
	    }
	 
	    
	 
	    public User findById(Long id) {
	    	return userRepository.findById(id).get();
	    }
	 
	    public User save(User user) {
	        return userRepository.save(user);
	    }
	 
	    public User update(User u) {
	    	
	        User user = userRepository.findById(u.getId()).orElse(null);
	        user.setName(u.getName());
	        user.setSurname(u.getSurname());
	        user.setDriversLicence(u.getDriversLicence());
	        user.setUsername(u.getUsername());
	        user.setPassword(u.getPassword());
	        user.setEmail(u.getEmail());
	        user.setUserCars(u.getUserCars());
	        
	 
	        
	 
	        return userRepository.save(user);
	    }
	 
	    public void delete(User user) {
	        userRepository.delete(user);
	    }
	 
	   /* @Override
	    public User create(NewUserDto newUserDto) {
	        User user = new User();
	        user.setName(newUserDto.getName());
	        user.setDescription(newUserDto.getDescription());
	        user.setAdmin(userService.findByUsername(newUserDto.getUserEmail()));
	        return user;
	    }*/
	 
	 
		public List<User> findAll() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}





	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}





	public void deleteInBatch(Iterable<User> arg0) {
		// TODO Auto-generated method stub
		
	}



	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}




	public <S extends User> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	public <S extends User> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<User> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	public void flush() {
		// TODO Auto-generated method stub
		
	}



	public <S extends User> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	public <S extends User> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}




	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}




	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}




	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	public void deleteAll(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub
		
	}




	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub
		
	}



	public boolean existsById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}




	public <S extends User> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



	public <S extends User> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}




	public <S extends User> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}




	public <S extends User> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

		/*@Override
		public User findByAddress(String address) {
			// TODO Auto-generated method stub
			return null;
		}*/

		

		

		
		

		
}
