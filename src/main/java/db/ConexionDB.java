//Conexion a la base de datos

//Importacion de paquetes
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    //Datos DB
    private static final String DB = "db_reproductormusicamodelomultiproposito";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Mariam2025*";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DB+"?useSSL=false";

    private static Connection conexion = null;

    //Constructor privado
    private ConexionDB() {
    }

    // Metodo Abrir conexión
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión exitosa...");
            } catch (SQLException | ClassNotFoundException ex) {
                System.err.println("Error al conectar con la base de datos" + ex.getMessage());
                ex.printStackTrace();
            };
        };
        return conexion;
    }
    //Metodo Cerrar conexión
    public static boolean cerrarConexion() throws SQLException, ClassNotFoundException {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Base de datos desconectada...");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar con la base de datos" + ex.getMessage());
            };
        };
        return false;
    }




}
