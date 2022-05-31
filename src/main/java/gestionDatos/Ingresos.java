package gestionDatos;

import DataBase.DAO.DAOIngresan;
import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPlanta;
import DataBase.DVO.Ingresan;
import gestionDatos.exceptions.AppException;
import gestionDatos.exceptions.NoPatientFound;
import gestionDatos.exceptions.NoSectionFound;
import gestionDatos.exceptions.PatientHospitalized;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Ingresos {

    public static void ingresarPaciente(String dni,String planta){

        try {
            //Comprueba que el paciente existe
            if (new DAOPacientes().get(dni)==null) throw new NoPatientFound(dni);
            //Comprueba si el paciente ya esta ingresdo
            Ingresan ingresan=new DAOIngresan().getAlta(dni);
            if (null==ingresan.getFechaAlta() && null!=ingresan.getFechaIngreso()) throw new PatientHospitalized(dni);
            //Comprueba si la planta donde intentas ingresar al paciente existe
            if (new DAOPlanta().get(planta)==null) throw new NoSectionFound(planta);

            new DAOIngresan().insert(new Ingresan(0, planta, dni,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis())),
                    null));
        }catch(AppException ex){
            ex.printStackTrace();
        }

    }


    public static void darAltaPaciente(String dni){


        try {

            if (new DAOPacientes().get(dni).equals(null)) throw new NoPatientFound(dni);

            new DAOIngresan().updateByPatient(dni,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis())));

        }catch(AppException ex){
            ex.printStackTrace();

        }


    }

}
