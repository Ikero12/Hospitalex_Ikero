package logIn;

import DataBase.DAO.DAOEnfermeros;
import DataBase.DAO.DAOMedicos;
import DataBase.DAO.DAOPacientes;
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

    public static void logIn(String dni, String contraseña, String tipo) throws NoUserFoundException, IncorrectPasswordException {

        IUsuario usuario = null;
        switch (tipo) {

            case "Pacientes" -> {
                usuario = new UserPaciente(new DAOPacientes().get(dni));
            }
            case "Medicos" -> {
                usuario = new UserMedico(new DAOMedicos().get(dni));
            }
            case "Enfermeros" -> {
                usuario = new UserEnfermero(new DAOEnfermeros().get(dni)) ;
            }
        }

        if (usuario.equals(null)) throw new NoUserFoundException("[DNI:" + dni + ".Not found in database]");

        if (usuario.getContraseña() != contraseña) throw new IncorrectPasswordException("[Try another password]");

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

    public static void setSavedUser(IUsuario usuario, Boolean checked) {

        if (usuario == null || !checked) return;

        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(FILE_PATH);

            fileWriter.write(usuario.getDni() + "-" + usuario.getContraseña() + "-" + usuario.getClass());

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
