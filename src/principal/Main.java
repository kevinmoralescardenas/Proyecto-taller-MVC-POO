package principal;
import controlador.ControladorProducto; 
import vista.VistaProducto;

public class Main {
    public static void main(String[] args) {
        VistaProducto vista =
            new VistaProducto();

        ControladorProducto controlador =
            new ControladorProducto();

            vista.mostrarMenu();

    }
}
