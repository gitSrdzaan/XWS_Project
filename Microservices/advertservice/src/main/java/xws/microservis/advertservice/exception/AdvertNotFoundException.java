package xws.microservis.advertservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdvertNotFoundException extends RuntimeException {
    private Long id;

    public AdvertNotFoundException(){
        super();
    }

    public AdvertNotFoundException(Long id) {
        super(String.format("Ad with id %f not found", id));
        this.id = id;
    }
}
