package xws.microservis.advertservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException{
	
	private Long id;
	
	public CarNotFoundException() {super();}
	
	public CarNotFoundException(Long id) {
		super(String.format("Car with id %f not found" , id));
        this.id = id;
	}
	
}
