package xws.microservis.rentservice.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.dto.CarDTO;
import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.model.User;
import xws.microservis.rentservice.repository.*;

@Service
public class CarService  {

	@Autowired 
	private CarRepository repository;

	@Autowired
	private CarFuelRepository carFuelRepository;

	@Autowired
	private TransmissionRepository transmissionRepository;


	@Autowired
	private FirmRepository firmRepository;

	@Autowired
	private UserRepository userRepository;
	
	
	//pronalazenj auta
	public CarDTO findCar(Long id) {
		Car c = repository.findById(id).orElse(null);
		
		if(c  == null)
			throw new NoSuchElementException();
		
		return new CarDTO(c);
	}


    public void addCar(CarDTO carDTO) {
		Car car = repository.findById(carDTO.getId()).orElse(new Car());
		
		dto2Car(carDTO,car);

		Firm firm = firmRepository.findById(carDTO.getOwner_id()).orElse(null);
		if(firm != null){
			car.setFirm(firm);
			car.setMonolitId(firm.getId());
		}
		else{
			User user = userRepository.findById(carDTO.getOwner_id()).orElse(null);
			car.setUser(user);

		}

		try{
			repository.save(car);
		}
		catch (Exception e){
			e.printStackTrace();
		}


		
    }

	private void dto2Car(CarDTO carDTO, Car car) {
		car.setId(carDTO.getId());
		car.setCarClass(carDTO.getCarClass());
		car.setCarComment(carDTO.getCarComment());
		car.setCarFuel(carFuelRepository.findById(carDTO.getCarFuel()).orElse(null));
		car.setTransmission(transmissionRepository.findById(carDTO.getTransmission()).orElse(null));
		car.setCarMark(carDTO.getCarMark());
		car.setCarModel(carDTO.getCarModel());
		car.setCarGrade(carDTO.getCarGrade());
		car.setCarMileage(carDTO.getCarMileage());
		car.setMaxAllowedMileage(carDTO.getMaxAllowedMileage());
		car.setKidsSeats(carDTO.getKidsSeats());
		car.setCarRegistration(carDTO.getCarRegistration());
	}
}
