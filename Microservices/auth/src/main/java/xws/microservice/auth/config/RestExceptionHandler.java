package xws.microservice.auth.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import xws.microservice.auth.exceptions.*;

import static org.springframework.http.HttpStatus.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    @ExceptionHandler(ConversionFailedError.class)
    protected ResponseEntity<Object> handleConversionFailedError(
            ConversionFailedError ex) {
        ApiError apiError = new ApiError(UNPROCESSABLE_ENTITY);
        apiError.setMessage(ex.getMessage());
        apiError.setEx(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(DuplicateEntity.class)
    protected ResponseEntity<Object> handleDuplicateEntity(
            DuplicateEntity ex) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setEx(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFound.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFound ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setEx(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UnexpectedError.class)
    protected ResponseEntity<Object> handleUnexpectedError(
            UnexpectedError ex) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setEx(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidEmailOrPasswordError.class)
    protected ResponseEntity<Object> handleInvalidEmailorPasswordError(
            InvalidEmailOrPasswordError ex) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        apiError.setEx(ex);
        return buildResponseEntity(apiError);
    }

    /*ERROR HANDLING
    * Add new custom exception like ItemNotFound
    * Make methods throw that exception
    * Exceptions automatically get forwarded to this handler
    * Create handler like ItemNotFound handler called handle....*/
}