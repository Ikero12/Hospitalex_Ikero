package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Empleados;
import DataBase.DVO.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmpleados {

    /**
     * Inserta en la base de datos los datos de la persona
     *
     * @param e Persona cuyos datos quieren añadirse
     */
    public void insert(Empleados e) {

        Connection conn = null;

        try {

            conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Persona VALUES(?,?,?,?,?)");
            ps.setString(1,e.getDni());
            ps.setString(2,e.getNombre());
            ps.setString(3,e.getApellidos());
            ps.setString(4,e.getFechaNacimiento());
            ps.setString(5,e.getContraseña());
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

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Empleados WHERE DNI=?");
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
     * @param em Persona del que se quiere actualizar los datos
     */
    public void update(Empleados em) {

        Connection conn = null;

        try {

            conn = DBConnection.getConn();

            new DAOPersonas().update(new Personas(em.getDni(),));

            PreparedStatement ps = conn.prepareStatement("UPDATE Personas SET Nombre=?,Apellidos=?,FechaNacimiento=?,Contraseña=? WHERE DNI=?");
            ps.setString(1,em.getNombre());
            ps.setString(2,em.getApellidos());
            ps.setString(3,em.getFechaNacimiento());
            ps.setString(4,em.getContraseña());
            ps.setString(5,em.getDni());
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
     * Mete en una ArrayList de usuarios a todos los empleados de la base de datos
     *
     * @return ArrayList de empleados
     */
    public ArrayList<Empleados> select() {

        ArrayList<Empleados> userList = new ArrayList<Empleados>();
        Connection conn = null;
        ResultSet result;

        try {

            conn = DBConnection.getConn();
            //TODO
            result = conn.createStatement().executeQuery("select Personas.*, Empleados.* from Personas inner join Empleados on Personas.DNI = Empleados.DNI;");

            while (result.next()) {

                userList.add(new Empleados(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado")));
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
     * Busca el empleado que tenga el DNI pasado por parametro
     * @param DNI DNI del empleado
     * @return El empleado con el DNI si existe, sino null
     */
    public Empleados get(String DNI) {

        Empleados e = null;
        Connection conn = null;
        ResultSet result;

        try {

            conn = DBConnection.getConn();
            //TODO
            PreparedStatement platform = conn.prepareStatement("select Personas.*, Empleados.* from Personas inner join Empleados on Personas.DNI = Empleados.DNI = ?;");
            platform.setString(1,DNI);
            result = platform.executeQuery();

            if (result.next())
                e = new Empleados(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return e;

    }

}
