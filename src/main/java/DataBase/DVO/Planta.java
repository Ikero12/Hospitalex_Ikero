package DataBase.DVO;

public class Planta {

    private String nombre;
    private int piso ;

    public Planta() {
    }

    public Planta(String nombre, int piso) {
        this.nombre = nombre;
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
