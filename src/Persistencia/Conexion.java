package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String DB = "bd_nutricion";
    private static Connection connection;

    public Conexion() {

    }

    public static Connection getConexion() {

        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");

                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("no se puede conectar " + ex.getMessage());

            }
        }
        return connection;

    }
}
