package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.repository.RentAdvertRepository;

@Service
public class RentAdvertService {
	@Autowired
	private RentAdvertRepository repository;
}
