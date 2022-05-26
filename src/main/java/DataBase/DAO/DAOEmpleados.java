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
     * Inserta en la base de datos los datos del empleado
     *
     * @param em Empleado cuyos datos quieren añadirse
     */
    public void insert(Empleados em) {

        try {

            Connection conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Empleados(DNI) VALUES(?)");
            ps.setString(1,em.getDni());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Elimina los datos de un empleado de la base de datos
     *
     * @param em Empleado del que se quiere eliminar los datos
     */
    public void delete(Empleados em) {

        try {

            Connection conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Empleados WHERE DNI=?");
            ps.setString(1, em.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Actualiza los datos del empleado en la base de datos
     *
     * @param em Empleado del que se quiere actualizar los datos
     */
    public void update(Empleados em) {

            new DAOPersonas().update(new Personas(em.getDni(),em.getContraseña(),em.getNombre(),em.getApellidos(),em.getFechaNacimiento()));

    }

    /**
     * Mete en una ArrayList de empleados a todos los empleados de la base de datos
     *
     * @return ArrayList de empleados
     */
    public ArrayList<Empleados> select() {

        ArrayList<Empleados> list = new ArrayList<Empleados>();

        try {

            Connection conn = DBConnection.getConn();
            ResultSet result = conn.createStatement().executeQuery("select Personas.*, Empleados.NumeroEmpleado from Personas inner join Empleados on Personas.DNI = Empleados.DNI;");

            while (result.next()) {

                list.add(new Empleados(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

        return list;

    }

    /**
     * Busca el empleado que tenga el DNI pasado por parametro
     * @param DNI DNI del empleado
     * @return El empleado con el DNI si existe, sino null
     */
    public Empleados get(String DNI) {

        Empleados em = null;

        try {

            Connection conn = DBConnection.getConn();
            PreparedStatement platform = conn.prepareStatement("select Personas.*, Empleados.NumeroEmpleado from Personas inner join Empleados on Personas.DNI = Empleados.DNI = ?;");
            platform.setString(1,DNI);
            ResultSet result = platform.executeQuery();

            if (result.next())
                em = new Empleados(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

        return em;

    }

}
