package DataBase.DVO;

public class Ingresan {
    private int idIngresan;
    private String nombrePlanta;
    private String dniPaciente;
    private String FechaIngreso;
    private String FechaAlta;

    public Ingresan() {
    }

    public Ingresan(int idIngresan, String nombrePlanta, String dniPaciente, String fechaIngreso, String fechaAlta) {
        this.idIngresan = idIngresan;
        this.nombrePlanta = nombrePlanta;
        this.dniPaciente = dniPaciente;
        FechaIngreso = fechaIngreso;
        FechaAlta = fechaAlta;
    }

    public int getIdIngresan() {
        return idIngresan;
    }

    public void setIdIngresan(int idIngresan) {
        this.idIngresan = idIngresan;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        FechaAlta = fechaAlta;
    }
}
