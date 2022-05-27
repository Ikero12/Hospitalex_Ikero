package logIn.user;

import DataBase.DVO.Enfermeros;

public class UserEnfermero extends Enfermeros implements IUsuario {

    public UserEnfermero(Enfermeros enfermeros){

        super(enfermeros.getDni(),enfermeros.getContraseña(),
                enfermeros.getNombre(),enfermeros.getApellidos(),
                enfermeros.getFechaNacimiento(),enfermeros.getNumeroEmpleado(),
                enfermeros.getPlanta());
    }


    @Override
    public void openProfile() {

    }
}
