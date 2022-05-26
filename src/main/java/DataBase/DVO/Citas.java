package DataBase.DVO;

public class Citas {

    private int idCita;
    private String dniMedico;
    private String dniPaciente;
    private String fecha;
    private String tipo;
    private String anotacion;

    public Citas(int idCita, String dniMedico, String dniPaciente, String fecha, String tipo, String anotacion) {
        this.idCita = idCita;
        this.dniMedico = dniMedico;
        this.dniPaciente = dniPaciente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.anotacion = anotacion;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }
}
