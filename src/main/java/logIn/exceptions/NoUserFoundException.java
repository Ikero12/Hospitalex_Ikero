package logIn.exceptions;

public class NoUserFoundException extends Exception {

    public NoUserFoundException(String details) {
        super("Error: No se ha iniciado sesion con ningun usuario. " + details);
    }
}
