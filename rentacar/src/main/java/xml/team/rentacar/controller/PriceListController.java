package xml.team.rentacar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.dto.PriceListDTO;
import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.service.FirmService;
import xml.team.rentacar.service.PriceListService;

@RestController
@RequestMapping(value = "/pricelist")
public class PriceListController {

	@Autowired
	private PriceListService priceListService;
	
	@Autowired
	private FirmService firmService;
	
	@GetMapping(value = "/all/{id}",produces = "application/json")
	public ResponseEntity<?> findAllPriceList(@PathVariable Long id){
		ArrayList<PriceList> listPL = priceListService.findAllFirmPL(id);
		
		if(listPL == null) {
			return new ResponseEntity<>("Greska pri listanju cjenovnika", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(listPL,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addPriceList(@RequestBody PriceListDTO plDTO) {
		Firm firm = firmService.findFirm(plDTO.getFirmID());
		if(firm == null) {
			return new ResponseEntity<>("Firma ne postoji", HttpStatus.BAD_REQUEST);
		}
		
		try {
			PriceList pl = new PriceList();
			pl.setId(plDTO.getId());
			pl.setFirm(firm);
			pl.setPriceCDW(plDTO.getPriceCDW());
			pl.setPricePerDay(plDTO.getPricePerDay());
			pl.setPricePerKilometer(plDTO.getPricePerKilometer());
			//pl.setSaleIntervals(plDTO.getSaleIntervals());
			priceListService.addNewPriceList(pl);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri upisu cjenovnika",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
