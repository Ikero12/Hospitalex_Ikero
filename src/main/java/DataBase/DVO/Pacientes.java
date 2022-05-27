package DataBase.DVO;

import logIn.user.IUsuario;

public class Pacientes extends Personas {

    private String NumeroSeguridadSocial;
    private String Enfermedad;
    private String FechaMuerte;

    public Pacientes(String dni, String contrasenha, String nombre, String apellidos, String fechaNacimiento, String numeroSeguridadSocial, String enfermedad, String fechaMuerte) {
        super(dni, contrasenha, nombre, apellidos, fechaNacimiento);
        NumeroSeguridadSocial = numeroSeguridadSocial;
        Enfermedad = enfermedad;
        FechaMuerte = fechaMuerte;
    }

    public String getNumeroSeguridadSocial() {
        return NumeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        NumeroSeguridadSocial = numeroSeguridadSocial;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        Enfermedad = enfermedad;
    }

    public String getFechaMuerte() {
        return FechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        FechaMuerte = fechaMuerte;
    }

}
