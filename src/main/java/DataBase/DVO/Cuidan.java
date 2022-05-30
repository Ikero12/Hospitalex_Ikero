package DataBase.DVO;

public class Cuidan {
    private int idCuidan;
    private String dniEnfermero;
    private String dniPaciente;
    private String FechaIngreso;
    private String FechaAlta;
    private String Planta;

    public Cuidan() {
    }

    public Cuidan(int idCuidan, String dniMedico, String dniPaciente, String fechaIngreso, String fechaAlta, String planta) {
        this.idCuidan = idCuidan;
        this.dniEnfermero = dniMedico;
        this.dniPaciente = dniPaciente;
        FechaIngreso = fechaIngreso;
        FechaAlta = fechaAlta;
        Planta = planta;
    }

    public int getIdCuidan() {
        return idCuidan;
    }

    public void setIdCuidan(int idCuidan) {
        this.idCuidan = idCuidan;
    }

    public String getDniEnfermero() {
        return dniEnfermero;
    }

    public void setDniEnfermero(String dniEnfermero) {
        this.dniEnfermero = dniEnfermero;
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

    public String getPlanta() {
        return Planta;
    }

    public void setPlanta(String planta) {
        Planta = planta;
    }
}
