package DataBase.DVO;

public class Atienden {

    private String idConsulta;
    private String dniMedico;
    private String dniPaciente;
    private String Fecha;

    public Atienden(String idConsulta, String dniMedico, String dniPaciente, String fecha) {
        this.idConsulta = idConsulta;
        this.dniMedico = dniMedico;
        this.dniPaciente = dniPaciente;
        Fecha = fecha;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
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
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
