package logIn;


import DataBase.DVO.Personas;
import org.mindrot.jbcrypt.BCrypt;

public class Password {

    public static String hashPassword(String pass){

        return BCrypt.hashpw(pass, BCrypt.gensalt(13));
    }

    public static boolean isSamePassword(String password,String hash){

        return BCrypt.checkpw(password,hash);
    }

    public static void changePassword(Personas personas){



    }


}