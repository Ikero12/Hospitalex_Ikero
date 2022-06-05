package gestionDatos;

import DataBase.DAO.DAOIngresan;
import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPlanta;
import DataBase.DVO.Ingresan;
import DataBase.DVO.Pacientes;
import gestionDatos.exceptions.AppException;
import gestionDatos.exceptions.NoPatientFound;
import gestionDatos.exceptions.NoSectionFound;
import gestionDatos.exceptions.PatientHospitalized;

import javax.swing.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Ingresos {

    /**
     * Metodo que mete un pacciente en la tabla de ingresos
     * @param dni del paciente a ingresar
     * @param planta planta donde se ingresa
     */
    public static void ingresarPaciente(String dni,String planta){

        try {
            //Comprueba que el paciente existe
            if (new DAOPacientes().get(dni)==null) throw new NoPatientFound(dni);
            //Comprueba si el paciente ya esta ingresdo
            Ingresan ingresan=new DAOIngresan().getAlta(dni);
            if (isPacienteIngresado(ingresan)) throw new PatientHospitalized(dni);
            //Comprueba si la planta donde intentas ingresar al paciente existe
            if (new DAOPlanta().get(planta)==null) throw new NoSectionFound(planta);

            new DAOIngresan().insert(new Ingresan(0, dni, planta,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis())),
                    null));
            JOptionPane.showMessageDialog(null,"Paciente ingresado satisfactoriamente.","Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
        }catch(AppException ex){
            JOptionPane.showMessageDialog(null,ex.getSimpleMessage(),"Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();

        }

    }

    /**
     * Da de alta al paciente ingresado
     * @param dni del paciente ingresado
     */
    public static void darAltaPaciente(String dni){


        try {

            if (new DAOPacientes().get(dni).equals(null)) throw new NoPatientFound(dni);

            new DAOIngresan().updateByPatient(dni,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis())));

        }catch(AppException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex.getSimpleMessage(),"Hospitalex Ikero",JOptionPane.WARNING_MESSAGE);
        }


    }

    public static boolean isPacienteIngresado(Ingresan ingresan){
        if (ingresan==null) return false;

        return null==ingresan.getFechaAlta() && null!=ingresan.getFechaIngreso();

    }

}
