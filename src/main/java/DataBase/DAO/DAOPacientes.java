package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Pacientes;
import DataBase.DVO.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPacientes {

    /**
     * Inserta en la base de datos los datos del paciente
     *
     * @param pa Paciente cuyos datos quieren añadirse
     */
    public void insert(Pacientes pa) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Pacientes VALUES(?,?,?,?);");
            ps.setString(1,pa.getDni());
            ps.setString(2,pa.getNumeroSeguridadSocial());
            ps.setString(3,pa.getEnfermedad());
            ps.setString(4,pa.getFechaMuerte());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Elimina los datos de un paciente de la base de datos
     *
     * @param pa Paciente del que se quiere eliminar los datos
     */
    public void delete(Pacientes pa) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Pacientes WHERE DNI=?;");
            ps.setString(1, pa.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Actualiza los datos del paciente en la base de datos
     *
     * @param pa Paciente del que se quiere actualizar los datos
     */
    public void update(Pacientes pa) {

        try {
            Connection conn = DBConnection.getInstance().openConn();

            new DAOPersonas().update(new Personas(pa.getDni(), pa.getContrasenha(), pa.getNombre(), pa.getApellidos(), pa.getFechaNacimiento()));

            PreparedStatement ps = conn.prepareStatement("UPDATE Pacientes SET NumeroSeguridadSocial=?, Enfermedad=?, FechaMuerte=? WHERE DNI=?;");
            ps.setString(1, pa.getNumeroSeguridadSocial());
            ps.setString(2, pa.getEnfermedad());
            ps.setString(3, pa.getFechaMuerte());
            ps.setString(4, pa.getDni());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Mete en una ArrayList de pacientes a todos los empleados de la base de datos
     *
     * @return ArrayList de pacientes
     */
    public ArrayList<Pacientes> select() {

        ArrayList<Pacientes> list = new ArrayList<Pacientes>();

        try {

            Connection conn = DBConnection.getInstance().openConn();
            ResultSet result = conn.createStatement().executeQuery("select Personas.*, Pacientes.NumeroSeguridadSocial, Pacientes.Enfermedad, Pacientes.FechaMuerte  from Personas inner join Pacientes on Personas.DNI = Pacientes.DNI;");

            while (result.next()) {

                list.add(new Pacientes(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroSeguridadSocial"),
                        result.getString("Enfermedad"),
                        result.getString("FechaMuerte")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * Busca el paciente que tenga el DNI pasado por parametro
     * @param DNI DNI del paciente
     * @return El paciente con el DNI si existe, sino null
     */
    public Pacientes get(String DNI) {

        Pacientes pa = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("select Personas.*, Pacientes.NumeroSeguridadSocial,Pacientes.Enfermedad,Pacientes.FechaMuerte  from Personas inner join Pacientes on Personas.DNI = Pacientes.DNI  WHERE Personas.DNI = ?;");
            platform.setString(1,DNI);

            ResultSet result = platform.executeQuery();

            if (result.next())
                pa = new Pacientes(result.getString("DNI"),
                        result.getString("Contraseña"),
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroSeguridadSocial"),
                        result.getString("Enfermedad"),
                        result.getString("FechaMuerte"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return pa;

    }



}
