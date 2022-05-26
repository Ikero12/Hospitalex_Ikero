package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Empleados;
import DataBase.DVO.Medicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMedicos {

    /**
     * Inserta en la base de datos los datos del medico
     *
     * @param me Medico cuyos datos quieren añadirse
     */
    public void insert(Medicos me) {

        try {

            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Medicos VALUES(?,?);");
            ps.setString(1,me.getDni());
            ps.setString(2,me.getCampo());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Elimina los datos de un medico de la base de datos
     *
     * @param me Medico del que se quiere eliminar los datos
     */
    public void delete(Medicos me) {

        try {

            Connection conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Enfermero WHERE DNI=?;");
            ps.setString(1, me.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Actualiza los datos del medico en la base de datos
     *
     * @param me Medicos del que se quiere actualizar los datos
     */
    public void update(Medicos me) {

        try {

            Connection conn = DBConnection.getConn();

            new DAOEmpleados().update(new Empleados(me.getDni(),me.getContraseña(),me.getNombre(),me.getApellidos(),me.getFechaNacimiento(),me.getNumeroEmpleado()));

            PreparedStatement ps = conn.prepareStatement("UPDATE Enfermeros SET Planta=? WHERE DNI=?;");
            ps.setString(1,me.getCampo());
            ps.setString(2,me.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }
    }

    /**
     * Mete en una ArrayList de medicos a todos los medicos de la base de datos
     *
     * @return ArrayList de medicos
     */
    public ArrayList<Medicos> select() {

        ArrayList<Medicos> list = new ArrayList<Medicos>();

        try {

            Connection conn = DBConnection.getConn();
            ResultSet result = conn.createStatement().executeQuery("select Personas.*, Empleados.NumeroEmpleado, Medicos.Campo from Personas inner join Empleados on Personas.DNI = Empleados.DNI  join Medicos on  Empleados.DNI = Medicos.DNI;");

            while (result.next()) {

                list.add(new Medicos(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado"),
                        result.getString("Campo")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

        return list;

    }

    /**
     * Busca el medico que tenga el DNI pasado por parametro
     * @param DNI DNI del medico
     * @return El medico con el DNI si existe, sino null
     */
    public Medicos get(String DNI) {

        Medicos me = null;

        try {

            Connection conn = DBConnection.getConn();
            PreparedStatement platform = conn.prepareStatement("select Personas.*, Empleados.NumeroEmpleado, Medicos.Campo from Personas inner join Empleados on Personas.DNI = Empleados.DNI = ?  join Medicos on  Empleados.DNI = Medicos.DNI = ?;");
            platform.setString(1,DNI);
            ResultSet result = platform.executeQuery();

            if (result.next())
                me = new Medicos(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado"),
                        result.getString("Planta"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

        return me;

    }
}
