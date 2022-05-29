package Application;


import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Pacientes;
import GUI.*;

public class HospitalexIkero {
    public static void main(String[] args) {
        Pacientes paciente = new DAOPacientes().get("12345678A");
       // new GUILogin();
        new GUIPaciente(paciente);

    }
}