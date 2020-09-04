package xws.microservis.advertservice.service;

import java.util.Optional;

import com.baeldung.springsoap.gen.GetPriceListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.dto.PriceListDTO;
import xws.microservis.advertservice.exception.PriceListNotFoundException;
import xws.microservis.advertservice.model.PriceList;
import xws.microservis.advertservice.model.User;
import xws.microservis.advertservice.mq.PriceListCreatedSender;
import xws.microservis.advertservice.repository.PriceListRepository;
import xws.microservis.advertservice.repository.UserRepository;

@Service
@Transactional
public class PriceListService {
	
	@Autowired
	PriceListRepository priceListRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PriceListCreatedSender createdSender;
	
	
	public PriceList findById(Long id) {
		
		Optional<PriceList> priceList = priceListRepository.findById(id);
		
		if(priceList.isPresent()) {
			
			return priceList.get();
		}else {
			throw new PriceListNotFoundException(id);
		}
	}

	public Long addNewPriceListSoap(GetPriceListRequest request){
		PriceList priceList = new PriceList(request.getPriceList());
		priceList.setMonolitId(request.getPriceList().getId());
		PriceList savedPL = priceListRepository.save(priceList);

		/**
		 * RabbitMQ
		 * */
		PriceListDTO priceListDTO = new PriceListDTO();
		priceList2DTO(savedPL,priceListDTO);

		createdSender.send(priceListDTO);


		return savedPL.getId();
	}

	private void priceList2DTO(PriceList priceList, PriceListDTO priceListDTO) {
		priceListDTO.setId(priceList.getId());
		priceListDTO.setOwner_id((long)1);
		priceListDTO.setPriceCDW(priceList.getPriceCDW());
		priceListDTO.setPricePerDay(priceList.getPricePerDay());
		priceListDTO.setPricePerKilometer(priceList.getPricePerKilometer());

	}

	public PriceList saveNew(PriceListDTO priceListDTO) {
		PriceList priceList = priceListRepository.findById(priceListDTO.getId()).orElse(new PriceList());

		dto2PriceList(priceListDTO,priceList);

		/**
		 * TODO : firma cjevnovnik*/
		User user = userRepository.findById(priceListDTO.getOwner_id()).orElse(null);
		priceList.setUser(user);

		priceListRepository.save(priceList);

		return  priceList;

    }

	private void dto2PriceList(PriceListDTO priceListDTO, PriceList priceList) {
		//priceList.setId(priceListDTO.getId());
		priceList.setPriceCDW(priceListDTO.getPriceCDW());
		priceList.setPricePerDay(priceListDTO.getPricePerDay());
		priceList.setPricePerKilometer(priceListDTO.getPricePerKilometer());
	}
}
