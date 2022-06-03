package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Ingresan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOIngresan {


    /**
     * Inserta en la base de datos los datos del ingreso
     *
     * @param i Ingreso cuyos datos quieren añadirse
     */
    public void insert(Ingresan i) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Ingresan(DNI_Paciente,Nombre_Planta,FechaIngreso,FechaAlta) VALUES(?,?,?,?)");
            ps.setString(1, i.getNombrePlanta());
            ps.setString(2, i.getDniPaciente());
            ps.setString(3, i.getFechaIngreso());
            ps.setString(4, i.getFechaAlta());
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
    public void delete(Ingresan p) {


        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Ingresan WHERE IdIngreso=?");
            ps.setInt(1, p.getIdIngresan());
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
     * @param i Ingreso de la que se quiere actualizar los datos
     */
    public void update(Ingresan i) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Ingresan SET DNI_Paciente=?, Nombre_Planta=?, FechaIngreso=?, FechaAlta=? WHERE IdIngreso=?");
            ps.setString(1, i.getDniPaciente());
            ps.setString(2, i.getNombrePlanta());
            ps.setString(3, i.getFechaIngreso());
            ps.setString(4, i.getFechaAlta());
            ps.setInt(5, i.getIdIngresan());
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
    public ArrayList<Ingresan> select() {

        ArrayList<Ingresan> list = new ArrayList<Ingresan>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM Ingresan");

            while (result.next()) {

                list.add(new Ingresan(result.getInt("IdIngreso"),
                        result.getString("DNI_Paciente"),
                        result.getString("Nombre_Planta"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta")));
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
     *
     * @param idIngreso ID del ingreso
     * @return El ingresos con el ID del ingreso si existe, sino null
     */
    public Ingresan get(int idIngreso) {

        Ingresan c = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Ingresan WHERE IdIngreso=?");
            platform.setInt(1, idIngreso);
            ResultSet result = platform.executeQuery();

            if (result.next())
                c = new Ingresan(result.getInt("IdIngreso"),
                        result.getString("DNI_Paciente"),
                        result.getString("Nombre_Planta"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return c;

    }

    /**
     * @param dni
     * @return
     */
    public ArrayList<Ingresan> selectbyPatient(String dni) {

        ArrayList<Ingresan> list = new ArrayList<Ingresan>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Ingresan where DNI_Paciente=? ");
            platform.setString(1, dni);
            ResultSet result = platform.executeQuery();

            while (result.next()) {

                list.add(new Ingresan(result.getInt("IdIngreso"),
                        result.getString("Nombre_Planta"),
                        result.getString("DNI_Paciente"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * @param planta
     * @return
     */
    public ArrayList<Ingresan> selectbyEnfermero(String planta) {

        ArrayList<Ingresan> list = new ArrayList<Ingresan>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Ingresan where Nombre_Planta=? ");
            platform.setString(1, planta);
            ResultSet result = platform.executeQuery();

            while (result.next()) {

                list.add(new Ingresan(result.getInt("IdIngreso"),
                        result.getString("DNI_Paciente"),
                        result.getString("Nombre_Planta"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     *
     * @param dni
     * @param date
     */
    public void updateByPatient(String dni,String date) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Ingresan SET  FechaAlta=? WHERE IdIngreso= (select max(IdIngreso) from Ingresan WHERE DNI_Paciente=?)");
            ps.setString(1,date);
            ps.setString(2,dni);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }
    }

    /**
     *
     * @param dni
     * @return
     */
    public Ingresan getAlta(String dni) {

        Ingresan i = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Ingresan WHERE IdIngreso= (select max(IdIngreso) from Ingresan WHERE DNI_Paciente=?)");
            platform.setString(1,dni);
            ResultSet result = platform.executeQuery();

            if (result.next())
                i = new Ingresan(result.getInt("IdIngreso"),
                        result.getString("DNI_Paciente"),
                        result.getString("Nombre_Planta"),
                        result.getString("FechaIngreso"),
                        result.getString("FechaAlta"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return i;

    }

}
