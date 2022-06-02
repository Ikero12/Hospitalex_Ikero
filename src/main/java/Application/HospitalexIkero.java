package Application;

import DataBase.DVO.Enfermeros;
import DataBase.DVO.Medicos;
import DataBase.DVO.Pacientes;
import GUI.*;
import gestionDatos.Ingresos;
import gestionDatos.PedirCita;
import logIn.LogIn;


public class HospitalexIkero {
    public static void main(String[] args) {

        if (!LogIn.tryLogin(LogIn.getSavedUser())) new GUILogin();

    }
}