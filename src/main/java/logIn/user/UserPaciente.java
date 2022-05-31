package logIn.user;

import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;

public class UserPaciente extends Pacientes implements IUsuario  {

    public UserPaciente() {
        super();
    }

    public UserPaciente(Pacientes pacientes) {
        super(pacientes.getDni(), pacientes.getContrasenha(), pacientes.getNombre(),
                pacientes.getApellidos(), pacientes.getFechaNacimiento(),
                pacientes.getNumeroSeguridadSocial(), pacientes.getEnfermedad(), pacientes.getFechaMuerte());
    }


    @Override
    public void openProfile() {
        new GUIPaciente(this,false);
    }

    @Override
    public String getTipoClase() {
        return "Paciente";
    }
}
