package gestionDatos.exceptions;

public class NoSectionFound extends AppException{
    public NoSectionFound(String details) {
        super("Error: La planta especificada no existe. [Planta:"+details+"]");
    }

    @Override
    public String getSimpleMessage() {
        return super.getMessage();
    }
}
