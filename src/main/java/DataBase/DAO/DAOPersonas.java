package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPersonas {

    /**
     * Inserta en la base de datos los datos de la persona
     *
     * @param p Persona cuyos datos quieren añadirse
     */
    public void insert(Personas p) {

        Connection conn = null;

        try {

            conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Persona VALUES(?,?,?,?,?)");
            ps.setString(1,p.getDni());
            ps.setString(2,p.getNombre());
            ps.setString(3,p.getApellidos());
            ps.setString(4,p.getFechaNacimiento());
            ps.setString(5,p.getContraseña());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Elimina los datos de una persona de la base de datos
     *
     * @param p Persona del que se quiere eliminar los datos
     */
    public void delete(Personas p) {

        Connection conn = null;

        try {

            conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Personas WHERE DNI=?");
            ps.setString(1, p.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Actualiza los datos de la persona en la base de datos
     *
     * @param p Persona del que se quiere actualizar los datos
     */
    public void update(Personas p) {

        Connection conn = null;

        try {

            conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Usuario SET Nombre=?,Apellidos=?,FechaNacimiento=?,Contraseña=? WHERE DNI=?");
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellidos());
            ps.setString(3,p.getFechaNacimiento());
            ps.setString(4,p.getContraseña());
            ps.setString(5,p.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mete en una ArrayList de usuarios a todos las personas  de la base de datos
     *
     * @return ArrayList de personas
     */
    public ArrayList<Personas> select() {

        ArrayList<Personas> userList = new ArrayList<Personas>();
        Connection conn = null;
        ResultSet result;

        try {

            conn = DBConnection.getConn();

            result = conn.createStatement().executeQuery("SELECT DNI,Nombre,Apellidos,FechaNacimiento FROM Persoas");

            while (result.next()) {

                userList.add(new Personas(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userList;

    }

    /**
     * Busca a la Persona que tenga el DNI pasado por parametro
     * @param DNI DNI de la persona
     * @return La persona con el DNI si existe, sino null
     */
    public Personas get(String DNI) {

        Personas p = null;
        Connection conn = null;
        ResultSet result;

        try {

            conn = DBConnection.getConn();

            PreparedStatement platform = conn.prepareStatement("SELECT DNI,Nombre,Apellidos,FechaNacimiento FROM Personas WHERE DNI=?");
            platform.setString(1,DNI);
            result = platform.executeQuery();

            if (result.next())
                p = new Personas(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                         result.getString("FechaNacimiento"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return p;

    }

}
