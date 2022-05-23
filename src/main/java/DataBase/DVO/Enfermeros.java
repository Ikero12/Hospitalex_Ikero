package DataBase.DVO;

public class Enfermeros extends Empleados {

    private String planta;

    public Enfermeros(String dni, String nombre, String apellidos, String fechaNacimiento, String numeroEmpleado, String planta) {
        super(dni, nombre, apellidos, fechaNacimiento, numeroEmpleado);
        this.planta = planta;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

}
