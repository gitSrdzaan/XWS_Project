package xml.team.rentacar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	 
	    public User save(User u) {
	    	User user= new User();
	        user.setName(u.getName());
	        user.setSurname(u.getSurname());
	        user.setDriversLicence(u.getDriversLicence());
	        user.setUsername(u.getUsername());
	        user.setPassword(u.getPassword());
	        user.setEmail(u.getEmail());
	        user.setUserCars(u.getUserCars());
	        
	         userRepository.save(user);
	         return user;
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
	        
	 
	        
	 
	        userRepository.save(user);
	        return user;
	    }
	 
	    public void delete(User user) {
	        userRepository.delete(user);
	    }
	 
	    public User create(UserDTO UserDTO) {
	        User user = new User();
	        user.setId(UserDTO.getId());
	        user.setName(UserDTO.getName());
	        user.setSurname(UserDTO.getSurname());
	        user.setDriversLicence(UserDTO.getDriversLicence());
	        user.setUsername(UserDTO.getUsername());
	        user.setEmail(UserDTO.getEmail());
	        user.setPassword(UserDTO.getPassword());
	        user.setUserCars(UserDTO.getUserCars());
			
	        
	        return user;
	    }
	 
	 
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




	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
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