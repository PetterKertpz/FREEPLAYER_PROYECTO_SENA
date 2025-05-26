import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/db_reproductormusicamodelomultiproposito";
    private static final String USER = "SENA";
    private static final String PASS = "Mariam2025*";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Registrar el driver (opcional en versiones recientes de JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conexion = getConnection();

        // Aquí puedes ejecutar consultas...

        try {
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}