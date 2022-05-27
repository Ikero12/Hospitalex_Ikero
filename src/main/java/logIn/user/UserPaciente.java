package logIn.user;

import DataBase.DVO.Pacientes;

public class UserPaciente extends Pacientes implements IUsuario  {
    public UserPaciente(Pacientes pacientes) {
        super(pacientes.getDni(), pacientes.getContraseña(), pacientes.getNombre(),
                pacientes.getApellidos(), pacientes.getFechaNacimiento(),
                pacientes.getNumeroSeguridadSocial(), pacientes.getEnfermedad(), pacientes.getFechaMuerte());
    }

    @Override
    public void openProfile() {

    }
}
