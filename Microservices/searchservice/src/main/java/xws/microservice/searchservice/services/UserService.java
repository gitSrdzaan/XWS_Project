package xws.microservice.searchservice.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.UserDTO;
import xws.microservice.searchservice.model.User;
import xws.microservice.searchservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public UserDTO findUser(Long id) {
		
		User user = repository.findById(id).orElse(null);
		
		if(user == null)
			throw new NoSuchElementException();
	
		return new UserDTO(user);
	}

	public ArrayList<User> findUsersByLocation(String country, String city) {

		return (ArrayList<User>) repository.findByCountryAndCity(country,city);

	}
}
