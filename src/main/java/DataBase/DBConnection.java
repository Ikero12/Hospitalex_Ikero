package DataBase;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:src/main/java/DataBase/BDHospital.db".replace("/",File.separator);

    private static DBConnection instance=null;

    private Connection conn=null;


    private DBConnection() {

        try {

            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){

        if (instance==null) instance= new DBConnection();

        return instance;
    }

    public Connection openConn() {

        try {

            instance.conn=DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance.conn;
    }

    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
