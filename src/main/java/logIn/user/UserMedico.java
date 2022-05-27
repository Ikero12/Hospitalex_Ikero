package logIn.user;

import DataBase.DVO.Enfermeros;
import DataBase.DVO.Medicos;

public class UserMedico extends Medicos implements IUsuario  {

    public UserMedico(Medicos medicos){

        super(medicos.getDni(),medicos.getContraseña(),
                medicos.getNombre(),medicos.getApellidos(),
                medicos.getFechaNacimiento(),medicos.getNumeroEmpleado(),
                medicos.getCampo());
    }

    @Override
    public void openProfile() {

    }

}
