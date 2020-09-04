package xws.microservis.advertservice.controller;

import java.io.Console;
import java.util.ArrayList;


import com.baeldung.springsoap.gen.GetCarRequest;
import com.baeldung.springsoap.gen.GetCarResponse;
import com.baeldung.springsoap.gen.GetRentAdvertRequest;
import com.baeldung.springsoap.gen.GetRentAdvertResponse;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xws.microservis.advertservice.dto.AdvertDto;

import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.model.RentAdvert;
import xws.microservis.advertservice.model.User;
import xws.microservis.advertservice.mq.AdvertCreatedSender;
import xws.microservis.advertservice.mq.AdvertUpdatedSender;
import xws.microservis.advertservice.service.AdvertService;
import xws.microservis.advertservice.service.UserService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/advert")
@Endpoint
public class AdvertController {


	private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

	@Autowired
	private AdvertService advertService;

	@Autowired
	private UserService userService;

	@Autowired
	private AdvertCreatedSender createdSender;

	@Autowired
	private AdvertUpdatedSender updatedSender;

	/**
	 *  REST poziv koji vraca sve reklame jednog korisnika
	 *  */
	@GetMapping(value = "/userAll/{id}", produces = "application/json")
	public ResponseEntity<?> getAllAdverts(@PathParam("id") Long id){

		User user = userService.findUser(id);
		if(user == null){
			return new ResponseEntity<>("AdvertService: User ne postoji", HttpStatus.BAD_REQUEST);
		}

		ArrayList<RentAdvert> adverts = advertService.findByUser(id);


		return new ResponseEntity<>(adverts,HttpStatus.OK);

	}

	@PostMapping(value="/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createAdvert(@RequestBody AdvertDto advertDto ){
		
		System.out.println(advertDto.getId());
		System.out.println(advertDto.getAdvertEndDate());
		System.out.println(advertDto.getAdvertStartDate());
		System.out.println(advertDto.getPriceListId());
		System.out.println(advertDto.getCarId());




		RentAdvert advert = advertService.save(advertDto);
		advertDto.setId(advert.getId());

		createdSender.send(advertDto);

		return  ResponseEntity.ok(advert);
	}

	@PutMapping(value = "/modify", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> modifyAdvert(@RequestBody  AdvertDto advertDto){

		advertService.save(advertDto);

		updatedSender.send(advertDto);


		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}" )
	public ResponseEntity<?> deleteAdvert(@PathParam("id") Long advertId){

		try {
			advertService.deleteAdvert(advertId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRentAdvertRequest")
	@ResponsePayload
	public GetRentAdvertResponse addAdvertFromAgentApp(@RequestPayload GetRentAdvertRequest request) {
		try{
			GetRentAdvertResponse response = new GetRentAdvertResponse();

			response.setId(advertService.addNewAdvertSoap(request));

			return response;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}



}
