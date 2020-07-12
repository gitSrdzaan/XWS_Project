package xws.microservice.auth.config;

public class ErrorMessages {

    public static String ENTITY_NOT_FOUND() {
        return "The requested data cannot be found.";
    }

    public static String REQUEST_ERROR() {
        return "Invalid request and/or missing data.";
    }

    public static String DUPLICATE_ITEM() { return "Duplicate item exists."; }

    public static String CONVERSION_FAILED() { return "Data conversion failed."; }
}
