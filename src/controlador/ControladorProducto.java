
package controlador;
import java.util.ArrayList;
import modelo.Producto;

public class ControladorProducto {
    private ArrayList<Producto> inventario;
    
    public ControladorProducto() {
        inventario = new ArrayList<>();
    }
    
    public void registrarProducto( Producto producto) {
        inventario.add(producto);

        System.out.println("Producto registrado correctamente");
    }
    
    public int totalProductos() {
        return inventario.size();
    }
    


}

