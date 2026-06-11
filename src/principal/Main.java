package principal;
import controlador.ControladorProducto; 
import modelo.Producto;
import vista.VistaProducto;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos la Vista
        VistaProducto vista = new VistaProducto();

        // 2. Instanciamos el Controlador pasando la vista como parámetro
        ControladorProducto controlador = new ControladorProducto(vista);

        // 3. Iniciamos el sistema a través del controlador
        controlador.iniciar();
    }

        

}

