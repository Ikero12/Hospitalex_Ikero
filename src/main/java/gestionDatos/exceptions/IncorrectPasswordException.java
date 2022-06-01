package gestionDatos.exceptions;

public class IncorrectPasswordException extends  AppException {

    private String message="Error: La contraseña introducida es incorrecta. ";

    public IncorrectPasswordException(String details) {
        super("Error: La contraseña introducida es incorrecta. "+ details);
    }


    @Override
    public String getSimpleMessage() {
        return message;
    }
}
