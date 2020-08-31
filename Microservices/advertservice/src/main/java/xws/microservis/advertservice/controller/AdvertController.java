package xws.microservis.advertservice.controller;

import java.io.Console;
import java.util.ArrayList;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xws.microservis.advertservice.dto.AdvertDto;

import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.model.RentAdvert;
import xws.microservis.advertservice.model.User;
import xws.microservis.advertservice.service.AdvertService;
import xws.microservis.advertservice.service.UserService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/advert")
public class AdvertController {
	
	@Autowired
	private AdvertService advertService;

	@Autowired
	private UserService userService;

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

	@PostMapping(value="/create", consumes = "application/json")
	public ResponseEntity<?> createAdvert(@RequestBody AdvertDto advertDto ){
		
		System.out.println(advertDto.getId());
		System.out.println(advertDto.getAdvertEndDate());
		System.out.println(advertDto.getPriceListId());
		System.out.println(advertDto.getCarId());
		
		return  ResponseEntity.ok(advertService.save(advertDto));
	}

	@PutMapping(value = "/modify", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> modifyAdvert(@RequestBody  AdvertDto advertDto){

		advertService.save(advertDto);


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
	
}
