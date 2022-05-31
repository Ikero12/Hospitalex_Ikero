package logIn.user;

import DataBase.DVO.Citas;
import DataBase.DVO.Enfermeros;
import DataBase.DVO.Ingresan;
import GUI.GUIEnfermero;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Citas> getUserCitas() {
        return null;
    }

    @Override
    public ArrayList<Ingresan> getUserIngresos() {
        return null;
    }

}
