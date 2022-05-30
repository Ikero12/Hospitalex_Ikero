package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Cuidan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCuidan {


    /**
     * Inserta en la base de datos los datos del ingreso
     *
     * @param c Ingreso cuyos datos quieren añadirse
     */
    public void insert(Cuidan c) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Cuidan VALUES(?,?,?,?,?,?)");
            ps.setInt(1,c.getIdCuidan());
            ps.setString(2,c.getDniEnfermero());
            ps.setString(3,c.getDniPaciente());
            ps.setString(4,c.getFechaIngreso());
            ps.setString(5,c.getFechaAlta());
            ps.setString(6,c.getPlanta());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Elimina los datos de un ingreso de la base de datos
     *
     * @param p Ingreso del que se quiere eliminar los datos
     */
    public void delete(Cuidan p) {


        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Cuidan WHERE IdCuidan=?");
            ps.setInt(1, p.getIdCuidan());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Actualiza los datos del ingreso en la base de datos
     *
     * @param c Ingreso de la que se quiere actualizar los datos
     */
    public void update(Cuidan c) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Cuidan SET DNI_Medico=?, DNI_Paciente=?, Fecha=?, Tipo=?, Anotacion=? WHERE IdCuidan=?");
            ps.setString(1,c.getDniEnfermero());
            ps.setString(2,c.getDniPaciente());
            ps.setString(3,c.getFechaIngreso());
            ps.setString(4,c.getFechaAlta());
            ps.setString(5,c.getPlanta());
            ps.setInt(6,c.getIdCuidan());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }
    }

    /**
     * Mete en una ArrayList de ingresos a todos los ingresos de la base de datos
     *
     * @return ArrayList de ingresos
     */
    public ArrayList<Cuidan> select() {

        ArrayList<Cuidan> list = new ArrayList<Cuidan>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM Cuidan");

            while (result.next()) {

                list.add(new Cuidan(result.getInt("IdCuidan"),
                        result.getString("DNI_Enfermero"),
                        result.getString("DNI_Paciente"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta"),
                        result.getString("Planta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * Busca el ingreso que tenga el ID del ingreso pasado por parametro
     * @param idCuidan ID del ingreso
     * @return El ingresos con el ID del ingreso si existe, sino null
     */
    public Cuidan get(int idCuidan) {

        Cuidan c = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Cuidan WHERE IdCuidan=?");
            platform.setInt(1,idCuidan);
            ResultSet result = platform.executeQuery();

            if (result.next())
                c = new Cuidan(result.getInt("IdCuidan"),
                        result.getString("DNI_Enfermero"),
                        result.getString("DNI_Paciente"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta"),
                        result.getString("Planta"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return c;

    }





}
