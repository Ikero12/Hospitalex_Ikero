package logIn.user;

import DataBase.DVO.Medicos;
import GUI.GUIMedico;

public class UserMedico extends Medicos implements IUsuario  {

    public UserMedico(Medicos medicos){

        super(medicos.getDni(),medicos.getContrasenha(),
                medicos.getNombre(),medicos.getApellidos(),
                medicos.getFechaNacimiento(),medicos.getNumeroEmpleado(),
                medicos.getCampo());
    }

    @Override
    public void openProfile() {

        new GUIMedico(this);
    }

    @Override
    public String getTipoClase() {
        return "Medicina";
    }

}
