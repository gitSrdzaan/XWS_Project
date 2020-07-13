package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.CarClass;
import xml.team.rentacar.model.CarFuel;
import xml.team.rentacar.model.CarMark;
import xml.team.rentacar.model.CarModel;
import xml.team.rentacar.model.Transmission;
import xml.team.rentacar.repository.CarClassRepository;
import xml.team.rentacar.repository.CarFuelRepository;
import xml.team.rentacar.repository.CarMarkRepository;
import xml.team.rentacar.repository.CarModelRepository;
import xml.team.rentacar.repository.CarRepository;
import xml.team.rentacar.repository.TransmissionRepository;


@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private CarMarkRepository markRepository;
	
	@Autowired
	private CarModelRepository modelRepository;
	
	@Autowired
	private CarClassRepository classRepository;
	
	@Autowired
	private CarFuelRepository fuelRepository;
	
	@Autowired
	private TransmissionRepository transRepository;
	
	public boolean addCar(Car car) throws Exception {
		
		try {
			repository.save(car);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesan pokusaj uspisivanja auta u bazu");
		}

		/**
		 * TODO: komunikacija sa ostalim servisima
		 * */
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> soapResponse = restTemplate.getForEntity("http://localhost:8086/car/" + car.getId(),Long.class);



		return true;
	}

	public List<Car> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Car> cars = (ArrayList<Car>) repository.findAll();
		if(cars == null) {
			return null;
		}
		
		return cars;
	}

	public CarMark findMark(String carMark) {
		// TODO Auto-generated method stub
		System.out.println(carMark);
		CarMark mark = markRepository.findMark(carMark);
		//ArrayList<CarMark> markList = (ArrayList<CarMark>) markRepository.findByMark(carMark);
		if(mark == null) {
			return null;
		}
		return mark;
		
	}
	
	public CarMark findMark(Long id) {
		// TODO Auto-generated method stub
		//System.out.println(carMark);
		CarMark mark = markRepository.findById(id).orElse(null);
		if(mark == null) {
			return null;
		}
		return mark;
		
	}

	public CarModel modelExsits(CarMark mark, String carModel) {
		// TODO Auto-generated method stub
		CarModel model =  modelRepository.findByMarkAndModel(mark.getId(), carModel);
		if(model == null) {
			return null;
		}
		return model;
	}

	public CarClass classExsits(CarModel carModel, String carClass) {
		// TODO Auto-generated method stub

		try{
			CarClass cc = classRepository.findByModelAndClass(carModel.getId(),carClass);
			if(cc == null) {
				return null;
			}

			return cc;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		

	}

	public Car findCar(Long carID) {
		// TODO Auto-generated method stub
		
		Car car = repository.findById(carID).orElse(null);
		
		if(car == null) {
			return null;
		}
		
		return car;
	}

	public void addMark(CarMark carMark) throws Exception {
		// TODO Auto-generated method stub
		try {
			markRepository.save(carMark);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Upis nove marke automobila nije uspio");
		}
		
	}

	public void addModel(CarMark mark, CarModel carModel, CarClass cc) throws Exception {
		// TODO Auto-generated method stub
		mark.getListModel().add(carModel);
		carModel.setMark(mark);
		carModel.getListCarClass().add(cc);
		cc.getListCarModel().add(carModel);
		
		
		try {
			modelRepository.save(carModel);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri upisu novog modela");
		}
		
		try {
			markRepository.save(mark);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri azuraranja marke automobila sa novim modelom");
		}
		try {
			classRepository.save(cc);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri azuraranja klase automobila sa novim modelom");
		}
		
		
	}

	public void addClass(CarClass cc) throws Exception {
		// TODO Auto-generated method stub
		try {
			classRepository.save(cc);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri cuvanju nove klase automobila");
		}
		
	}

	public CarClass findCarClass(Long classID) {
		// TODO Auto-generated method stub
	
		return  classRepository.findById(classID).orElse(null);
	}

	public void addCarFuel(CarFuel cf) throws Exception {
		// TODO Auto-generated method stub
		try {
			fuelRepository.save(cf);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri upisu novog goriva");
		}
		
		
		
	}

	public void addTransmission(Transmission tran) throws Exception {
		// TODO Auto-generated method stub
		try {
			transRepository.save(tran);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri upisu nove transmisije");
		}
		
		
	}

	public ArrayList<CarMark> findAllCarMarks() {
		// TODO Auto-generated method stub
		
		return (ArrayList<CarMark>) markRepository.findAll();
	}

	public ArrayList<CarClass> findAllCarClasses() {
		// TODO Auto-generated method stub
		return (ArrayList<CarClass>) classRepository.findAll();
	}

	public ArrayList<CarModel> findAllCarModels() {
		// TODO Auto-generated method stub
		return (ArrayList<CarModel>) modelRepository.findAll();
	}

    public ArrayList<Transmission> getAllTransmission() {
		return (ArrayList<Transmission>) transRepository.findAll();
    }

	public ArrayList<CarFuel> getAllCarFuel() {
		return (ArrayList<CarFuel>) fuelRepository.findAll();
	}
}
