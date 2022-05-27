package logIn.exceptions;

public class IncorrectPasswordException extends Exception{

    public IncorrectPasswordException(String details) {
        super("Error: La contraseña introducida es incorrecta. " + details);
    }


}
