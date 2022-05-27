package DataBase.DVO;

import logIn.user.IUsuario;

public class Enfermeros extends Empleados {

    private String planta;

    public Enfermeros(String dni, String contrasenha, String nombre, String apellidos, String fechaNacimiento, String numeroEmpleado, String planta) {
        super(dni, contrasenha, nombre, apellidos, fechaNacimiento, numeroEmpleado);
        this.planta = planta;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

}
