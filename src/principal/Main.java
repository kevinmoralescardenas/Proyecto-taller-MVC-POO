package principal;
import controlador.ControladorProducto; 
import modelo.Producto;
import vista.VistaProducto;

public class Main {
    public static void main(String[] args) {
        VistaProducto vista =new VistaProducto();

        ControladorProducto controlador = new ControladorProducto();

        vista.mostrarMenu();
            
        Producto producto1 = new Producto( 101, "mouse", 85000, 20);
        controlador.registrarProducto( producto1);
        System.out.println( controlador.totalProductos());
        
        Producto producto2 = new Producto( 102, "Teclado Mecánico", 150000, 10 );
        Producto producto3 = new Producto( 103, "Monitor", 650000, 5 );
        
        controlador.registrarProducto( producto2);
        controlador.registrarProducto( producto3);
        
        System.out.println( controlador.totalProductos());



    }
}
