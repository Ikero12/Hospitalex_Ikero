package DataBase.DAO;


import DataBase.DBConnection;
import DataBase.DVO.Planta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPlanta {


    /**
     * Inserta en la base de datos los datos de la Planta
     *
     * @param c Cita cuyos datos quieren aÃ±adirse
     */
    public void insert(Planta c) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Planta(Nombre,Piso) VALUES(?,?)");
            ps.setString(1,c.getNombre());
            ps.setInt(2,c.getPiso());
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
    public void delete(Planta  p) {


        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Citas WHERE IdCita=?");
            ps.setString(1, p.getNombre());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Actualiza los datos de la Planta en la base de datos
     *
     * @param p Planta de la que se quiere actualizar los datos
     */
    public void update(Planta p) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Planta SET Piso=? WHERE Nombre=?");
            ps.setInt(1,p.getPiso());
            ps.setString(2,p.getNombre());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }
    }

    /**
     * Mete en una ArrayList de todas las plantas de la base de datos
     *
     * @return ArrayList de plantas
     */
    public ArrayList<Planta> select() {

        ArrayList<Planta> list = new ArrayList<Planta>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM Planta");

            while (result.next()) {

                list.add(new Planta(result.getString("Nombre"),
                        result.getInt("piso")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * Busca a la cita que tenga el nombrePlanta pasado por parametro
     * @param nombrePlanta ID de la cita
     * @return La citas con el ID de la cita si existe, sino null
     */
    public Planta get(String nombrePlanta) {

        Planta p = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Planta WHERE Nombre=?");
            platform.setString(1,nombrePlanta);
            ResultSet result = platform.executeQuery();

            if (result.next())
                p = new Planta(result.getString("Nombre"),
                        result.getInt("piso"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return p;

    }

}