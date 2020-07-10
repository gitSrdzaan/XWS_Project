package xws.microservice.auth.exceptions;

public class InvalidEmailOrPasswordError extends Exception{
    public InvalidEmailOrPasswordError(String s){
        super(s);
    }
}