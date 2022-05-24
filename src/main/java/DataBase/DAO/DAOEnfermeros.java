package DataBase.DAO;

import DataBase.DBConnection;
import DataBase.DVO.Empleados;
import DataBase.DVO.Enfermeros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DAOEnfermeros {

    /**
     * Inserta en la base de datos los datos del enfermero
     *
     * @param en Enfermero cuyos datos quieren añadirse
     */
    public void insert(Enfermeros en) {

        try {

            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Enfermeros VALUES(?,?)");
            ps.setString(1,en.getDni());
            ps.setString(2,en.getPlanta());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Elimina los datos de un enfermero de la base de datos
     *
     * @param en Enfermero del que se quiere eliminar los datos
     */
    public void delete(Enfermeros en) {

        try {

            Connection conn = DBConnection.getConn();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM Enfermero WHERE DNI=?");
            ps.setString(1, en.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

    }

    /**
     * Actualiza los datos del enfermero en la base de datos
     *
     * @param en Enfermero del que se quiere actualizar los datos
     */
    public void update(Enfermeros en) {

        try {

            Connection conn = DBConnection.getConn();

            new DAOEmpleados().update(new Empleados(en.getDni(),en.getContraseña(),en.getNombre(),en.getApellidos(),en.getFechaNacimiento(),en.getNumeroEmpleado()));

            PreparedStatement ps = conn.prepareStatement("UPDATE Enfermeros SET Planta=? WHERE DNI=?");
            ps.setString(1,en.getPlanta());
            ps.setString(2,en.getDni());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }
    }

    /**
     * Mete en una ArrayList de enfermeros a todos los enfermeros de la base de datos
     *
     * @return ArrayList de enfermeros
     */
    public ArrayList<Enfermeros> select() {

        ArrayList<Enfermeros> list = new ArrayList<Enfermeros>();

        try {

            Connection conn = DBConnection.getConn();
            ResultSet result = conn.createStatement().executeQuery("select Personas.*, Empleados.*, Medicos.* from Personas inner join Empleados on Personas.DNI = Empleados.DNI join Enfermeros on  Personas.DNI = Enfermeros.DNI");

            while (result.next()) {

                list.add(new Enfermeros(result.getString("DNI"),
                        "*******",
                        result.getString("Nombre"),
                        result.getString("Apellidos"),
                        result.getString("FechaNacimiento"),
                        result.getString("NumeroEmpleado"),
                        result.getString("Planta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConn();
        }

        return list;

    }

    /**
     * Busca el enfermero que tenga el DNI pasado por parametro
     * @param DNI DNI del enfermero
     * @return El enfermero con el DNI si existe, sino null
     */
    public Enfermeros get(String DNI) {

        Enfermeros en = null;

        try {

            Connection conn = DBConnection.getConn();
            PreparedStatement platform = conn.prepareStatement("select Personas.*, Empleados.*, Medicos.* from Personas inner join Empleados on Personas.DNI = Empleados.DNI = ? join Enfermeros on  Personas.DNI = Enfermeros.DNI = ?");
            platform.setString(1,DNI);
            ResultSet result = platform.executeQuery();

            if (result.next())
                en = new Enfermeros(result.getString("DNI"),
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

        return en;

    }

}
