package logIn;


import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Personas;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;

public class Password {

    public static String hashPassword(String pass) {

        return BCrypt.hashpw(pass, BCrypt.gensalt(13));
    }

    public static boolean isSamePassword(String password, String hash) {

        return BCrypt.checkpw(password, hash);
    }

    public static void changePassword(Personas personas, Component parent) {


        String old = JOptionPane.showInputDialog(parent, "Introduce tu antigua contraseña", "Hospitalex Ikero", JOptionPane.INFORMATION_MESSAGE);

        if (isSamePassword(old, personas.getContrasenha())) {

            String newPassword = JOptionPane.showInputDialog(parent, "Introduce tu nueva contraseña", "Hospitalex Ikero", JOptionPane.INFORMATION_MESSAGE);

            String newPassword2 = JOptionPane.showInputDialog(parent, "Introduce de nuevo la contraseña", "Hospitalex Ikero", JOptionPane.INFORMATION_MESSAGE);

            if (newPassword.equals(newPassword2)) {

                personas.setContrasenha(Password.hashPassword(newPassword));
                new DAOPersonas().update(personas);
                JOptionPane.showMessageDialog(parent, "Contraseña cambiada satisfactoriamente", "Hospitalex Ikero", JOptionPane.INFORMATION_MESSAGE);

            } else
                JOptionPane.showMessageDialog(parent, "Las contraseñas no coinciden, intentelo de nuevo", "Hospitalex Ikero", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(parent, "La contraseña no coincide con almacenada,intentelo de nuevo", "Hospitalex Ikero", JOptionPane.WARNING_MESSAGE);

    }


}