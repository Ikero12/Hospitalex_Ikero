package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;
import gestionDatos.exceptions.NoPatientFound;


import javax.swing.*;
import java.awt.*;


public class BusquedaPaciente extends GUIPaciente {
    Pacientes pacienteBuscado;
    public BusquedaPaciente(String dniPaciente, Component parent) {


        pacienteBuscado =new DAOPacientes().get(dniPaciente);
        if (pacienteBuscado!=null) new GUIPaciente(pacienteBuscado,true);

        else{
            JOptionPane.showMessageDialog(parent,new NoPatientFound(dniPaciente),
                    "Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
        }
    }
}
