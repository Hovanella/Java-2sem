package DAO;


import org.jetbrains.annotations.NotNull;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnectionManager {
    

    public java.sql.Connection Connect() {

        java.sql.Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=JavaLaba6;integratedSecurity=true;"
                    + "encrypt=true;trustServerCertificate=true";

            conn = DriverManager.getConnection(dbURL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;

    }

    public void Disconnect(java.sql.@NotNull Connection con) {
        
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
