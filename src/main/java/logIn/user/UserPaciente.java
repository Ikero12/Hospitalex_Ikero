package logIn.user;

import DataBase.DAO.DAOCitas;
import DataBase.DAO.DAOIngresan;
import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Citas;
import DataBase.DVO.Ingresan;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Citas> getUserCitas() {
        return  new DAOCitas().selectByPatient(this.getDni());
    }

    @Override
    public ArrayList<Ingresan> getUserIngresos() {

        return new DAOIngresan().selectbyPatient(this.getDni());

    }


}
