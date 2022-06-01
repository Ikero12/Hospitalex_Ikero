package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;
import logIn.exceptions.NoUserFoundException;

import javax.swing.*;
import java.awt.*;


public class BusquedaPaciente extends GUIPaciente {
    Pacientes pacienteBuscado;
    public BusquedaPaciente(String dniPaciente, Component parent) {
        pacienteBuscado =new DAOPacientes().get(dniPaciente);
        if (pacienteBuscado!=null) new GUIPaciente(pacienteBuscado,true);

        else{
            JOptionPane.showMessageDialog(parent,"Error: No existe el paciente con el DNI introducido. [DNI:"+dniPaciente+"]",
                    "Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
        }
    }
}
