package xml.team.rentacar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.model.CarClass;
import xml.team.rentacar.model.CarFuel;
import xml.team.rentacar.model.CarMark;
import xml.team.rentacar.model.CarModel;
import xml.team.rentacar.model.Codebook;
import xml.team.rentacar.model.Transmission;
import xml.team.rentacar.model.User;
import xml.team.rentacar.service.CarService;
import xml.team.rentacar.service.CodebookService;
import xml.team.rentacar.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user/")
public class AdminController {
 
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private CodebookService codebookService;
	
	@Autowired
	private CarService carService;
	
    @GetMapping("getAllUsers")
    public ResponseEntity<?> getAllUsers()  {
    	List<xml.team.rentacar.model.User> users = userService.findAll();
    	if(users==null) {
    		return new ResponseEntity("No users",HttpStatus.BAD_REQUEST);
    	}else {
    		return new  ResponseEntity(users,HttpStatus.OK);
    	}
    			
    }

    
    @GetMapping("getSingleUser/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable Long id)  {
    	User user = (User) userService.findById(id);
    	if(user==null) {
    		return new ResponseEntity("No user found",HttpStatus.BAD_REQUEST);
    	}else {
    		return new ResponseEntity(user,HttpStatus.OK);
    	}
    	
        
    }

    
    @PostMapping("addUser")
    public ResponseEntity<?> addUser (@RequestBody User user)  {
    	User u = (User) userService.findById(((xml.team.rentacar.model.User) user).getId());
    	if (u==null) {
    		try {
    			  u = userService.save(user);
    			  return new ResponseEntity(u,HttpStatus.OK);
    			}
    			catch(Exception e) {
    			  return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    			}
    	
    	}else {
    		return new ResponseEntity("User already added",HttpStatus.BAD_REQUEST);
    	}
    }

   
    @PutMapping("updateUser/{id}")
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable Long id) {
    	User u = (User) userService.findById(id);
    	if(u==null) {
    		return new ResponseEntity("No user with that id",HttpStatus.OK);
    	}else {
    		try {
    		u=userService.update(user);
    		return new ResponseEntity(u,HttpStatus.OK);
    		}catch(Exception e) {
    			return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    		}
    	}
    }

    
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Long id) {
    	User user = (User) userService.findById(id);
    	if(user==null) {
    		return new ResponseEntity("No user found",HttpStatus.BAD_REQUEST);
    	}else {
    		userService.deleteById(id);
    		return new ResponseEntity("User deleted",HttpStatus.OK);
    	}
    	
    }
    /**
     * TODO : odrzavanje sifrarnika
     * */
    
    @PostMapping(value = "nova/marka", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCarMark(@RequestBody CarMark carMark) {
    	CarMark mark = carService.findMark(carMark.getMark());
    	if(mark != null) {
    		return new ResponseEntity<>("Marka automobila vec postoji", HttpStatus.BAD_REQUEST);
    	}
    	
    	try {
    		carService.addMark(carMark);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Greska pri upisu marke automobila", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "nova/klasa", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCarClass(@RequestBody CarClass cc){
    	try {
    		carService.addClass(cc);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Greska pri upisu klase automobila", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    	
    	
    }
    
    @PostMapping(value = "novi/model/{markID}/{classID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCarModel(@RequestBody CarModel carModel,@PathVariable Long markID, @PathVariable Long classID) {
    	CarMark mark = carService.findMark(markID);
    	if(mark == null) {
    		return new ResponseEntity<>("Marka automobila nije izabrana", HttpStatus.BAD_REQUEST);
    	}
    	CarClass cc = carService.findCarClass(classID);
    	if(cc == null) {
    		return new ResponseEntity<>("Klasa automobila nije izabrana", HttpStatus.BAD_REQUEST);
    	}
    	
    	
    	try {
    		carService.addModel(mark, carModel, cc);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Greska pri upisu modela automobila", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value ="novi/prenos",consumes = "application/json", produces = "application/json" )
    public ResponseEntity<?> addNewTranssmission(@RequestBody Transmission tran){
    	try {
    		carService.addTransmission(tran);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Greska pri unos nove transmisije", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    

    @PostMapping(value ="novo/gorivo",consumes = "application/json", produces = "application/json" )
    public ResponseEntity<?> addNewCarFuel(@RequestBody CarFuel cf){
    	try {
    		carService.addCarFuel(cf);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>("Greska pri unos novog goriva", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "svi/marke")
    public ResponseEntity<?> findAllCarMarks(){
    	ArrayList<CarMark> listMark = carService.findAllCarMarks();
    	if(listMark == null) {
    		return new ResponseEntity<>("Lista marki automobila prazna", HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(listMark,HttpStatus.OK);
    	
    	
    }
    
    @GetMapping(value = "svi/klase")
    public ResponseEntity<?> findAllCarClasses(){
    	ArrayList<CarClass> listClass = carService.findAllCarClasses();
    	if(listClass == null) {
    		return new ResponseEntity<>("Lista klasi automobila prazna", HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(listClass,HttpStatus.OK);
    	
    	
    }
    
    

    @GetMapping(value = "svi/modeli")
    public ResponseEntity<?> findAllCarModels(){
    	ArrayList<CarModel> listModel = carService.findAllCarModels();
    	if(listModel == null) {
    		return new ResponseEntity<>("Lista modeli automobila prazna", HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(listModel,HttpStatus.OK);
    	
    	
    }
    
    
    
    /**
     * @author Artukov
     * */
    
    @PostMapping("addInCodebook/{id}/{s1}/{s2}/{s3}/{s4}")
    public ResponseEntity<?> addInCodebook (@PathVariable Long id, 
    		@PathVariable String s1, @PathVariable String s2, @PathVariable String s3,@PathVariable String s4)  {
    	
    	Codebook c = codebookService.getOne(id);
    	if (c==null) {
    		return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    	
    	}else {
    		c=codebookService.update(id, s1, s2, s3, s4);
    		return new ResponseEntity(c,HttpStatus.OK);
    	}
    }
    
    @DeleteMapping("deleteFromCodebook/{id}/{s1}/{s2}/{s3}/{s4}")
    public ResponseEntity<?> deleteFromCodebook(@PathVariable Long id, 
    		@PathVariable String s1, @PathVariable String s2, @PathVariable String s3,@PathVariable String s4)  {
    	
    	Codebook c = codebookService.getOne(id);
    	if (c==null) {
    		return new ResponseEntity("Unexpected error",HttpStatus.BAD_REQUEST);
    	
    	}else {
    		codebookService.delete(id, s1, s2, s3, s4);
    		return new ResponseEntity("Deleted from Codebook",HttpStatus.OK);
    	}
    }
    
    
}
