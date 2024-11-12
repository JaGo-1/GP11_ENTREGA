
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "nutricion_bd";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public Conexion() {
        // Constructor vacío
    }

    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("No se puede conectar: " + ex.getMessage());
            }
        }
        return connection;
    }
}
      
