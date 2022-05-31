package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;



public class BusquedaPaciente extends GUIPaciente {
    Pacientes Pacientebuscado;
    public BusquedaPaciente(String DNIpaciente) {
        Pacientebuscado =new DAOPacientes().get(DNIpaciente);
        new GUIPaciente(Pacientebuscado,true);
    }
}
