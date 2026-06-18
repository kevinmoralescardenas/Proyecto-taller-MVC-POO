package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    //parametros de configuracion del servidor local
    private static final String URL = "jdbc:postgresql://localhost:5432/proyecto_inventarios_db";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "admin123";
    
    public static Connection obtenerConexion() throws SQLException {
        // DriverManager interactúa con el Driver .jar para levantar el socket de red
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
    
}
