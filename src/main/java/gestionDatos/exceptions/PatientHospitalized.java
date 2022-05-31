package gestionDatos.exceptions;

public class PatientHospitalized extends AppException{

    public PatientHospitalized(String details) {
        super("Error: El paciente con el DNI especificado ya esta hospitalizado. [DNI:"+details+"]");
    }

    @Override
    public String getSimpleMessage() {
        return null;
    }
}
