package DataBase.DVO;

import logIn.user.IUsuario;

public class Medicos extends Empleados {

    private String campo;

    public Medicos(String dni, String contraseña, String nombre, String apellidos, String fechaNacimiento, String numeroEmpleado, String campo) {
        super(dni, contraseña, nombre, apellidos, fechaNacimiento, numeroEmpleado);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

}
