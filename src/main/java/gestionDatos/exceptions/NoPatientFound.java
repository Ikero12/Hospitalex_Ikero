package gestionDatos.exceptions;

public class NoPatientFound extends AppException{

    public NoPatientFound(String details) {
        super("Error: El paciente con el DNI especificado no existe. [DNI:"+details+"]");
    }

    @Override
    public String getSimpleMessage() {
        return super.getMessage();
    }
}
