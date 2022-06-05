package logIn.user;

import DataBase.DAO.DAOCitas;
import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Citas;
import DataBase.DVO.Ingresan;
import DataBase.DVO.Medicos;
import GUI.GUIMedico;

import java.util.ArrayList;

public class UserMedico extends Medicos implements IUsuario {

    public UserMedico(Medicos medicos) {

        super(medicos.getDni(), medicos.getContrasenha(),
                medicos.getNombre(), medicos.getApellidos(),
                medicos.getFechaNacimiento(), medicos.getNumeroEmpleado(),
                medicos.getCampo());
    }

    @Override
    public void openProfile() {

        new GUIMedico(this);
    }

    @Override
    public String getTipoClase() {
        return "Medicina";
    }

    @Override
    public ArrayList<Citas> getUserCitas() {
        return new DAOCitas().selectByMedic(this.getDni());
    }

    @Override
    public ArrayList<Ingresan> getUserIngresos() {
        return null;
    }


}
