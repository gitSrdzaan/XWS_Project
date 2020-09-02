package xws.microservis.advertservice.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.baeldung.springsoap.gen.GetCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.dto.CarDTO;
import xws.microservis.advertservice.exception.CarNotFoundException;
import xws.microservis.advertservice.model.*;
import xws.microservis.advertservice.repository.*;

@Service
@Transactional
public class CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	UserRepository userRepository;

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
	
	public Car findById(Long id){
		
		Optional<Car> car = carRepository.findById(id);
		
		if(car.isPresent()) {
			
			return car.get();
		}else {
			throw new CarNotFoundException(id);
		}
	}

	public void saveNewCar(CarDTO carDTO) throws Exception {
		User user  = userRepository.findById(carDTO.getOwner_id()).orElse(null);
		if(user == null){
			throw new Exception("Korisnik ne postoji");
		}
		Car car = new Car();
		dtoToCar(carDTO,car);
		car.setUser(user);
		try {
			carRepository.save(car);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception("Greska u pokusaju uspisa automobila");
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

	public ArrayList<Car> getAllCars() {

		return (ArrayList<Car>) carRepository.findAll();
	}

    public void modifyCar(CarDTO carDTO, Long carId) throws Exception {

		Car car = carRepository.findById(carId).orElse(null);
		if(car == null){
			throw new NoSuchElementException("AdvertService: modifikacija - auto ne postoji");

		}
		dtoToCar(carDTO,car);
		try {
			carRepository.save(car);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception("Greska u pokusaju uspisa automobila");
		}

    }
    public Long addNewCarSoap(GetCarRequest request){
		Car car = new Car(request.getCar());

		CarFuel carFuel = fuelRepository.findByName(request.getCar().getCarFuel());
		Transmission transmission = transRepository.findByName(request.getCar().getTransmission());
		car.setCarFuel(carFuel);
		car.setTransmission(transmission);

		Car newCar = carRepository.save(car);

		return newCar.getId();

	}


	// * Metoda koja Car.class objekat set-uje na vrijednosti CarDTO.class objekta
	// * @param model.CarDTO carDTO
	// * @param model.Car car
    private void dtoToCar(CarDTO carDTO, Car car){
		car.setId(carDTO.getId());
		car.setCarClass(carDTO.getCarClass());
		car.setCarComment(carDTO.getCarComment());
		car.setCarFuel(fuelRepository.findById(carDTO.getCarFuel()).orElse(null));
		car.setTransmission(transRepository.findById(carDTO.getTransmission()).orElse(null));
		car.setCarMark(carDTO.getCarMark());
		car.setCarModel(carDTO.getCarModel());
		car.setCarGrade(carDTO.getCarGrade());
		car.setCarMileage(carDTO.getCarMileage());
		car.setMaxAllowedMileage(carDTO.getMaxAllowedMileage());
		car.setKidsSeats(carDTO.getKidsSeats());
		car.setCarRegistration(carDTO.getCarRegistration());

	}
}
