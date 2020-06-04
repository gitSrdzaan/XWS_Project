package xws.microservice.searchservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.FirmDTO;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.repository.FirmRepository;

@Service
public class FirmService {

	@Autowired
	private FirmRepository repository;
	
	public FirmDTO findFirm(Long id) {
		
		Firm firm = repository.findById(id).orElse(null);
		
		if(firm == null)
			throw new NoSuchElementException();
		
		return new FirmDTO(firm);
	}
}
