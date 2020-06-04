package xml.team.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.User;
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
			return null;
		}



		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
	 
	 
		

		

		

		
		

		
}
