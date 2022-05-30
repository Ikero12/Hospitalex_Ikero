package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCitas {

    /**
     * Inserta en la base de datos los datos de la cita
     *
     * @param c Cita cuyos datos quieren añadirse
     */
    public void insert(Citas c) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Citas VALUES(?,?,?,?,?,?)");
            ps.setInt(1,c.getIdCita());
            ps.setString(2,c.getDniMedico());
            ps.setString(3,c.getDniPaciente());
            ps.setString(4,c.getFecha());
            ps.setString(5,c.getTipo());
            ps.setString(6,c.getAnotacion());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Elimina los datos de una cita de la base de datos
     *
     * @param p Cita del que se quiere eliminar los datos
     */
    public void delete(Citas p) {


        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Citas WHERE IdCita=?");
            ps.setInt(1, p.getIdCita());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Actualiza los datos de la cita en la base de datos
     *
     * @param c Cita de la que se quiere actualizar los datos
     */
    public void update(Citas c) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Citas SET DNI_Medico=?, DNI_Paciente=?, Fecha=?, Tipo=?, Anotacion=? WHERE IdCita=?");
            ps.setString(1,c.getDniMedico());
            ps.setString(2,c.getDniPaciente());
            ps.setString(3,c.getFecha());
            ps.setString(4,c.getTipo());
            ps.setString(5,c.getAnotacion());
            ps.setInt(6,c.getIdCita());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }
    }

    /**
     * Mete en una ArrayList de citas a todos las citas de la base de datos
     *
     * @return ArrayList de citas
     */
    public ArrayList<Citas> select() {

        ArrayList<Citas> list = new ArrayList<Citas>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM Citas");

            while (result.next()) {

                list.add(new Citas(result.getInt("IdCita"),
                        result.getString("DNI_Medico"),
                        result.getString("DNI_Paciente"),
                        result.getString("Fecha"),
                        result.getString("Tipo"),
                        result.getString("Anotacion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * Busca a la cita que tenga el idCita pasado por parametro
     * @param idCita ID de la cita
     * @return La citas con el ID de la cita si existe, sino null
     */
    public Citas get(String idCita) {

        Citas c = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Citas WHERE IdCita=?");
            platform.setString(1,idCita);
            ResultSet result = platform.executeQuery();

            if (result.next())
                c = new Citas(result.getInt("IdCita"),
                        result.getString("DNI_Medico"),
                        result.getString("DNI_Paciente"),
                        result.getString("Fecha"),
                        result.getString("Tipo"),
                        result.getString("Anotacion"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return c;

    }


}
