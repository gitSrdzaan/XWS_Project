package xws.microservis.advertservice.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xws.microservis.advertservice.dto.AdvertDto;
import xws.microservis.advertservice.model.Advert;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.service.AdvertService;

@RestController
@RequestMapping(value = "/advert")
public class AdvertController {
	
	@Autowired
	private AdvertService advertService;

	@PostMapping(value="/create", consumes = "application/json")
	public ResponseEntity<?> createAdvert(@RequestBody AdvertDto advertDto ){
		
		System.out.println(advertDto.getId());
		System.out.println(advertDto.getAdvertEndDate());
		System.out.println(advertDto.getPriceListId());
		System.out.println(advertDto.getCarId());
		
		return ResponseEntity.ok(advertService.save(advertDto));
	}
	
}
