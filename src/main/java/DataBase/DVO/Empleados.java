package DataBase.DVO;

public class Empleados extends Personas {

    private String NumeroEmpleado;

    public Empleados(String dni, String nombre, String apellidos, String fechaNacimiento, String numeroEmpleado) {
        super(dni, nombre, apellidos, fechaNacimiento);
        NumeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() {
        return NumeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        NumeroEmpleado = numeroEmpleado;
    }

}
