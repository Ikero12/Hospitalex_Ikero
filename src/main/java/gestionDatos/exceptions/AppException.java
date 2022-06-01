package gestionDatos.exceptions;

public abstract class AppException extends Exception {


    public AppException(String details) {
        super(details);
    }

    public abstract String getSimpleMessage();
}
