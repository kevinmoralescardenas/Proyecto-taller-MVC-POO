package controlador;

import modelo.Usuario;

import conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vista.VentanaLogin;
//import vista.VentanaPrincipal; no utilizamos esta importacion


// Agregamos "implements ActionListener" para que la clase pueda escuchar botones
// y sus metodos obligarorios que son actionPerformed
public class ControladorLogin implements ActionListener{
    
    // El constructor ahora recibe la nueva vista gráfica
    private VentanaLogin vista;

    // El constructor ahora recibe la nueva vista gráfica
    public ControladorLogin(VentanaLogin vista) {
        
        this.vista = vista;
        
        // Le indicamos a la vista que este controlador escuchará sus botones
         this.vista.conectarBotones(this);
                   
    } 
    
    // Método obligatorio de la interfaz ActionListener. Se ejecuta automáticamente al dar clic.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Capturamos el texto del botón que fue presionado
        String botonPresionado = e.getActionCommand();

        if (botonPresionado.equals("Enviar")) {
            ejecutarAutenticacion();
        } else if (botonPresionado.equals("Salir")) {
            System.out.println("[Sistema]: Cierre voluntario desde la interfaz.");
            System.exit(0); // Cierra la aplicación por completo
        }
    }
    
     // Procesa los datos capturados y consulta a PostgreSQL (Lógica del Documento 15)
    private void ejecutarAutenticacion() {
        String usuarioDigitado = vista.getUsuario();
        String claveDigitada = vista.getClave();

        // Validación de campos vacíos en la capa de negocio
        if (usuarioDigitado.isEmpty() || claveDigitada.isEmpty()) {
            vista.mostrarMensajeAlerta("[Alerta]: Por favor, complete todos los campos.");
            return;
        }

        // Llamamos al método que consulta la Base de Datos
        boolean esValido = validarCredencialesInDB(usuarioDigitado, claveDigitada);

         if (esValido) {
            vista.mostrarMensajeAlerta("¡Acceso Permitido! Bienvenido al sistema.");
            
            // 1. Creamos la ventana principal
            //VentanaPrincipal menuPrincipal = new VentanaLogin();
            
            // 2. NUEVO: Creamos su controlador y le pasamos la ventana para que se conecten
            //new ControladorPrincipal(menuPrincipal);
            
            // 3. Mostramos la ventana principal en pantalla
            //menuPrincipal.setVisible(true);
            
            // 4. Destruimos el Login de la memoria
            vista.dispose(); 
            
            System.out.println("[Sistema]: Login exitoso. Abriendo módulos con MVC...");
        } else {
            vista.mostrarMensajeAlerta("[Error]: Usuario o contraseña incorrectos. Acceso Denegado.");
        }
    }
    
      // Consulta exacta a PostgreSQL utilizando Try-with-resources (Lógica pura del Módulo 15)
    private boolean validarCredencialesInDB(String txtUsuario, String txtClave) {
        
        // Consulta SQL con parámetros dinámicos (?) 
        String sql = "SELECT usuario,  clave " +
                "FROM usuario " +
                "WHERE usuario = ? AND clave = ?";

        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) { // recibe la consulta sql (tiene canal abierto)
            
            ps.setString(1, txtUsuario); //modifiqueme los parametros y cambielos porque lo que captura
            ps.setString(2, txtClave);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si encontró la coincidencia en PostgreSQL
            }
        } catch (SQLException e) {
            vista.mostrarMensajeAlerta("[Error Crítico SQL]: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
    
    
}// Fin de la clase