package logIn.exceptions;

public class NoUserFoundException extends AppException {

    private String message="Error: No se ha iniciado sesion con ningun usuario. ";

    public NoUserFoundException(String details) {
        super("Error: No se ha iniciado sesion con ningun usuario. " + details);
    }

    public String getSimpleMessage(){

        return message;

    }
}
