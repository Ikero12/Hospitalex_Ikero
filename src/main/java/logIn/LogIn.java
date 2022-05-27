package logIn;

import DataBase.DAO.DAOEnfermeros;
import DataBase.DAO.DAOMedicos;
import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Enfermeros;
import DataBase.DVO.Medicos;
import DataBase.DVO.Pacientes;
import logIn.exceptions.IncorrectPasswordException;
import logIn.exceptions.NoUserFoundException;
import logIn.user.IUsuario;
import logIn.user.UserEnfermero;
import logIn.user.UserMedico;
import logIn.user.UserPaciente;


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
        }

        if (!contrasenha.equals(usuario.getContrasenha())) throw new IncorrectPasswordException("[Try another password]");

        setSavedUser(usuario,isUserRemembered);

        usuario.openProfile();
    }

    public static String[] getSavedUser() {

        Scanner sc = null;

        String logInData=null;

        try {

            sc = new Scanner(new File(FILE_PATH));

            if (sc.hasNextLine()) logInData=sc.next();

        }catch(FileNotFoundException ex){

            System.out.println("Error:"+ex.getMessage());

        }finally {
            sc.close();
        }
        return logInData.split("-",3);

    }

    public static void setSavedUser(IUsuario usuario, Boolean isUserRemembered) {

        if (usuario == null || !isUserRemembered) return;

        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(FILE_PATH);

            fileWriter.write(usuario.getDni() + "-" + usuario.getContrasenha() + "-" + usuario.getClass().getSimpleName());

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
