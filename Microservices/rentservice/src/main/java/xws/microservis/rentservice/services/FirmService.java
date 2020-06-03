package xws.microservis.rentservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.dto.FirmDTO;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.repository.FirmRepository;

@Service
public class FirmService {
	@Autowired
	private FirmRepository repository;
	
	
	//pronalazenje auta
	public FirmDTO findFirm(Long id) {
		Firm f = repository.findById(id).orElse(null);
		
		if(f == null) {
			throw new NoSuchElementException();
		}
		return new FirmDTO(f);
		
	}
}
