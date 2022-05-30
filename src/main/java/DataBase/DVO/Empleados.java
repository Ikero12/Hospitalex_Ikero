package DataBase.DVO;

public class Empleados extends Personas {

    private String NumeroEmpleado;

    public Empleados() {

    }

    public Empleados(String dni, String contrasenha, String nombre, String apellidos, String fechaNacimiento, String numeroEmpleado) {
        super(dni, contrasenha, nombre, apellidos, fechaNacimiento);
        NumeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() {
        return NumeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        NumeroEmpleado = numeroEmpleado;
    }

}
