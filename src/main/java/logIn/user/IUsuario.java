package logIn.user;

import DataBase.DVO.Citas;
import DataBase.DVO.Ingresan;

import java.util.ArrayList;

public interface IUsuario {
    
    void openProfile();
    String getDni();
    String getContrasenha();
    String getTipoClase();
    ArrayList<Citas> getUserCitas();
    ArrayList<Ingresan> getUserIngresos();

}
