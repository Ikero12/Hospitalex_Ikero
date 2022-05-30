package logIn.user;

import DataBase.DVO.Enfermeros;
import GUI.GUIEnfermero;

public class UserEnfermero extends Enfermeros implements IUsuario {

    public UserEnfermero(Enfermeros enfermeros){

        super(enfermeros.getDni(),enfermeros.getContrasenha(),
                enfermeros.getNombre(),enfermeros.getApellidos(),
                enfermeros.getFechaNacimiento(),enfermeros.getNumeroEmpleado(),
                enfermeros.getPlanta());
    }


    @Override
    public void openProfile() {
        new GUIEnfermero(this);
    }

    @Override
    public String getTipoClase() {
        return "Enfermeria";
    }
}
