package Application;

import GUI.*;
import gestionDatos.Ingresos;
import logIn.LogIn;


public class HospitalexIkero {
    public static void main(String[] args) {

        if (!LogIn.tryLogin(LogIn.getSavedUser())) new GUILogin();


    }
}