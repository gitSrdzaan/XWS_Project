package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.repository.FirmRepository;

@Service
public class FirmService {
	@Autowired
	private FirmRepository repository;
}