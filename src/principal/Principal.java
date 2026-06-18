package principal;

import conexion.Conexion;
import controlador.ControladorLogin;
import vista.VentanaLogin;
import java.sql.Connection;
import java.sql.SQLException;

public class Principal {
    
    

    public static void main(String[] args) {
        
        // --- TEST DE DIAGNÓSTICO DE BASE DE DATOS DE ARRANQUE ---
        System.out.println("[Sistema]: Verificando estado de los servicios externos...");
        // Uso de Try-with-resources: la variable 'testConn' se cerrará sola al terminar el bloque
        try (Connection testConn = Conexion.obtenerConexion()) {
            if (testConn != null && !testConn.isClosed()) {
                System.out.println("[Diagnóstico]: Enlace con PostgreSQL establecido con éxito. Base de datos: ONLINE.\n");
            }
        } catch (SQLException e) {
            System.out.println("\n[ERROR CRÍTICO DE INFRAESTRUCTURA]");
            System.out.println("Detalle del fallo: " + e.getMessage());
            System.out.println("Causa probable: Servidor apagado, credenciales inválidas o base de datos inexistente.");
            System.out.println("El sistema se detendrá de inmediato.");
            return; // Aborta la ejecución si no hay base de datos disponible
        }

        // 1. Instanciamos la interfaz gráfica del Login
        VentanaLogin inicioSesion = new VentanaLogin();            
               
        // 2. Instanciamos el controlador inyectando la vista para enlazar los eventos y SQL
        ControladorLogin cLogin = new ControladorLogin(inicioSesion);
        
         // 3. Hacemos visible la ventana en el monitor
        inicioSesion.setVisible(true);
        
        
    }
}

