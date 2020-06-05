package xws.microservis.advertservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceListNotFoundException extends RuntimeException{
	
	private Long id;
	
	public PriceListNotFoundException() {super();}
	
	public PriceListNotFoundException(Long id) {
		super(String.format("Price list with id %f not found" , id));
        this.id = id;
	}
	
}
