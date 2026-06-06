package vista;

import java.util.Scanner;
import java.util.ArrayList; 
import modelo.Producto;

public class VistaProducto {
    private Scanner teclado;
    
    public VistaProducto() {
    teclado = new Scanner(System.in);
    }
    
    public int leerCodigo() {
        System.out.print("Código: ");

        return teclado.nextInt();
    }


    
    public void mostrarMenu() {
        System.out.println();
        System.out.println("================================");
        System.out.println(" SISTEMA DE INVENTARIO ");
        System.out.println("================================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }
    public void mostrarProductos(ArrayList<Producto> productos) {
        if(productos.isEmpty()) {

            System.out.println(
            "No existen productos registrados");

            return;
        }

        for (Producto producto : productos) {

            producto.mostrarInformacion();

            System.out.println("-------------------");

        }
    }
    

    
}
