package logIn;

import DataBase.DAO.DAOEnfermeros;
import DataBase.DAO.DAOMedicos;
import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Enfermeros;
import DataBase.DVO.Medicos;
import DataBase.DVO.Pacientes;
import GUI.GUILogin;
import gestionDatos.exceptions.AppException;
import gestionDatos.exceptions.IncorrectPasswordException;
import gestionDatos.exceptions.NoUserFoundException;
import logIn.user.IUsuario;
import logIn.user.UserEnfermero;
import logIn.user.UserMedico;
import logIn.user.UserPaciente;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {

    private static final String FILE_PATH = "src/main/resources/SavedUser.txt".replace("/", File.separator);

    public static void logIn(String dni, String contrasenha, String tipo,Boolean isUserRemembered) throws NoUserFoundException, IncorrectPasswordException {

        IUsuario usuario=null;
        switch (tipo) {

            case "Paciente" -> {

                Pacientes paciente= new DAOPacientes().get(dni);

                if (paciente ==null) throw new NoUserFoundException("[DNI:" + dni + ".Not found in database]");
                usuario = new UserPaciente(paciente);
            }
            case "Medicina" -> {

                Medicos medicos= new DAOMedicos().get(dni);
                if (medicos ==null) throw new NoUserFoundException("[DNI:" + dni + ".Not found in database]");
                usuario = new UserMedico(medicos);
            }
            case "Enfermeria" -> {

                Enfermeros enfermeros= new DAOEnfermeros().get(dni);
                if (enfermeros ==null) throw new NoUserFoundException("[DNI:" + dni + ".Not found in database]");
                usuario = new UserEnfermero(enfermeros) ;
            }
            default -> {
                throw new NoUserFoundException("[DNI:" + dni + ".Not found in database]");
            }
        }

        if (!contrasenha.equals(usuario.getContrasenha())) throw new IncorrectPasswordException("[Try another password]");

        setSavedUser(usuario,isUserRemembered);

        usuario.openProfile();
    }

    public static void disconnect(JFrame usuario){
        String[]opciones = {"Si","No"};
        int disc = JOptionPane.showOptionDialog(null,"Estás seguro de que quieres desconectarte?",
                "Hospitalex Ikero", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
        if (disc==0) {
            usuario.dispose();
            setSavedUser(new UserPaciente(), true);
            new GUILogin();
        }
    }

    public static String[] getSavedUser() {

        Scanner sc = null;

        String logInData=null;

        File savedCredentials=new File(FILE_PATH);

        if(!savedCredentials.exists()) return null;

        try {

            sc = new Scanner(savedCredentials);

            if (sc.hasNextLine()) logInData=sc.next();

        }catch(FileNotFoundException ex){

            System.out.println("Error:"+ex.getMessage());

        }finally {
            sc.close();
        }



        if (null==logInData) return null;
        return logInData.split("-",3);

    }

    public static boolean tryLogin(String[] userData){

        if(userData==null) return false;

        try {
            logIn(userData[0],userData[1],userData[2],true);
        }catch(AppException ex){
            ex.printStackTrace();
            return false;
        }

        return true;
    }



    public static void setSavedUser(IUsuario usuario, Boolean isUserRemembered) {

        if (usuario == null || !isUserRemembered) return;

        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(FILE_PATH);

            fileWriter.write(usuario.getDni() + "-" + usuario.getContrasenha() + "-" +usuario.getTipoClase());

        } catch (FileNotFoundException ex) {

            ex.printStackTrace();


        } catch (IOException ex) {

            ex.printStackTrace();

        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }


}
