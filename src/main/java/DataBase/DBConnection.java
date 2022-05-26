package DataBase;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:src/main/java/DataBase/BDHospital.db".replace("/",File.separator);

    private static Connection conn=null;

    private DBConnection() {

        try {

            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {

        if (conn==null) new DBConnection();

        return conn;
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
