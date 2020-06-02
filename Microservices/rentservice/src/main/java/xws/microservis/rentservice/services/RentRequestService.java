package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.repository.RentRequestRepository;

@Service
public class RentRequestService {

	@Autowired
	private RentRequestRepository repisotory;
}
