package DataBase.DVO;

public class Cuidan {
    private String idCuidado;
    private String dniMedico;
    private String dniPaciente;
    private String FechaIngreso;
    private String FechaAlta;
    private String Planta;

    public String getIdCuidado() {
        return idCuidado;
    }

    public void setIdCuidado(String idCuidado) {
        this.idCuidado = idCuidado;
    }

    public String getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(String dniMedico) {
        this.dniMedico = dniMedico;
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
