package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;

import gestionDatos.exceptions.NoPatientFound;
import logIn.user.UserPaciente;


import javax.swing.*;
import java.awt.*;


public class BusquedaPaciente extends GUIPaciente {
    UserPaciente pacienteBuscado;

    /**
     * Genera una pestaña nueva con los detalles del paciente ( no puedes cambiar nada, solo revisar sus datos)
     * @param dniPaciente DNI del paciente cuyo perfil queremos ver
     * @param parent Componente para fijar el JOption pane
     */
    public BusquedaPaciente(String dniPaciente, Component parent) {
        pacienteBuscado =new UserPaciente(new DAOPacientes().get(dniPaciente));
        if (pacienteBuscado!=null) new GUIPaciente(pacienteBuscado,true);

        else{
            JOptionPane.showMessageDialog(parent,new NoPatientFound(dniPaciente),
                    "Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
        }
    }
}
