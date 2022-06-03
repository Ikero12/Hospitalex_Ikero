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

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Personas VALUES(?,?,?,?,?)");
            ps.setString(1,p.getDni());
            ps.setString(2,p.getNombre());
            ps.setString(3,p.getApellidos());
            ps.setString(4,p.getFechaNacimiento());
            ps.setString(5,p.getContrasenha());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Elimina los datos de una persona de la base de datos
     *
     * @param p Persona del que se quiere eliminar los datos
     */
    public void delete(Personas p) {


        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Personas WHERE DNI=?");
            ps.setString(1, p.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

    }

    /**
     * Actualiza los datos de la persona en la base de datos
     *
     * @param p Persona del que se quiere actualizar los datos
     */
    public void update(Personas p) {

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement ps = conn.prepareStatement("UPDATE Personas SET Nombre=?,Apellidos=?,FechaNacimiento=?,Contrasenha=? WHERE DNI=?");
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getApellidos());
            ps.setString(3,p.getFechaNacimiento());
            ps.setString(4,p.getContrasenha());
            ps.setString(5,p.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }
    }

    /**
     * Mete en una ArrayList de usuarios a todos las personas de la base de datos
     *
     * @return ArrayList de personas
     */
    public ArrayList<Personas> select() {

        ArrayList<Personas> list = new ArrayList<Personas>();

        try {

            Connection conn = DBConnection.getInstance().openConn();

            ResultSet result = conn.createStatement().executeQuery("SELECT DNI,Nombre,Apellidos,FechaNacimiento FROM Personas");

            while (result.next()) {

                list.add(new Personas(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return list;

    }

    /**
     * Busca a la Persona que tenga el DNI pasado por parametro
     * @param DNI DNI de la persona
     * @return La persona con el DNI si existe, sino null
     */
    public Personas get(String DNI) {

        Personas p = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Personas WHERE DNI=?");
            platform.setString(1,DNI);
            ResultSet result = platform.executeQuery();

            if (result.next())
                p = new Personas(result.getString("DNI"),
                        result.getString("Contrasenha"),
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                         result.getString("FechaNacimiento"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return p;

    }


    /**
     *
     * @param DNI
     * @return
     */
    public String getCompleteName(String DNI) {

        String name = null;

        try {

            Connection conn = DBConnection.getInstance().openConn();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM Personas WHERE DNI=?");
            platform.setString(1,DNI);
            ResultSet result = platform.executeQuery();

            if (result.next())
               name = result.getString("Nombre")+" "+result.getString("Apellidos");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConn();
        }

        return name;

    }

}
