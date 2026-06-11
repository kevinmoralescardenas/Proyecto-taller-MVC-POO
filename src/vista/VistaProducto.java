package vista;
import modelo.Persona;
import modelo.Usuario;
import modelo.Empleado;
import modelo.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaProducto {
  
    private Scanner teclado;
    
    //constructor
    public VistaProducto() {
            teclado = new Scanner(System.in);
    }

    //metodo leer codigo
   // --- NUEVOS MÉTODOS PARA CAPTURA DE DATOS ---
  // Métodos para registrar un producto uno por uno
      // Captura el código validando que sea un número entero
    public int leerCodigo(){        
        while(true) {
            try {
                System.out.print("Registrar Codigo: ");             
                int codigo = teclado.nextInt();
                teclado.nextLine(); // Limpia el Enter residual
                return codigo;
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: El código debe ser un número entero.");
                teclado.nextLine(); // Limpia el búfer
            }
        }
    }

    
    
    
    


    public void mostrarMenu() {
        
        System.out.println("\n================================");
        System.out.println("      SISTEMA DE INVENTARIO     ");
        System.out.println("================================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }


    public int leerOpcion(){
        while(true) {
            try {
                int opcion = teclado.nextInt();
                teclado.nextLine(); // Limpia el Enter residual
                return opcion;
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar un número entero válido.");
                System.out.print("Intente de nuevo. Seleccione una opción: ");
                teclado.nextLine(); // Limpia el búfer del Scanner tras el error
            }
        }
    }
   
    
    
   // El nombre no requiere try-catch numérico ya que acepta cualquier cadena de texto
    public String leerNombre(){
        System.out.print("Registrar Nombre: ");
        return teclado.nextLine();
    }

// Captura el precio validando que sea un número decimal o entero
    public double leerPrecio(){
        while(true) {
            try {
                System.out.print("Registrar Precio: ");
                double precio = teclado.nextDouble();
                teclado.nextLine(); // Limpia el Enter residual
                return precio;
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: El precio debe ser un valor numérico (ej: 1500.50).");
                teclado.nextLine(); // Limpia el búfer
            }
        }
    }

    // Captura el stock validando que sea un número entero
    public int leerStock(){
        while(true) {
            try {
                System.out.print("Registrar Stock: ");
                int stock = teclado.nextInt();
                teclado.nextLine(); // Limpia el Enter residual
                return stock;
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: El stock debe ser un número entero.");
                teclado.nextLine(); // Limpia el búfer
            }
        }
    }

    // Método exclusivo de la Vista para mostrar mensajes al usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n--> " + mensaje);
    }
    
    public int leerCantidad() {
    while (true) {
        try {
            System.out.print("Registrar Cantidad: ");
            int cantidad = teclado.nextInt();
            teclado.nextLine();
            return cantidad;
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: La cantidad debe ser un número entero.");
            teclado.nextLine();
        }
    }
}
    
    
     // Recibe la lista de productos y la imprime en consola
    public void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS EN INVENTARIO ---");
        
        // Validación: Si no hay elementos, avisa al usuario y detiene el método
        if (productos.isEmpty()) {
            System.out.println("[Alerta]: No existen productos registrados en el sistema.");
            return;
        }

        // Bucle For-Each para recorrer la colección e imprimir ordenadamente
        for (Producto prod : productos) {
            System.out.println("Código:   " + prod.getCodigo());
            System.out.println("Nombre:   " + prod.getNombre());
            System.out.println("Precio:   $" + prod.getPrecio());
            System.out.println("Stock:    " + prod.getStock() + " unidades");
            System.out.println("---------------------------------------");
        }
    }
    
    
       // Recibe un único producto filtrado y despliega su información detallada
    public void mostrarProductoIndividual(Producto prod) {

    if (prod == null) {
        System.out.println("\n[Error]: El producto con el código especificado no existe.");
        return;
    }

    System.out.println("\n--- DETALLE DEL PRODUCTO ENCONTRADO ---");
    System.out.println("Código:   " + prod.getCodigo());
    System.out.println("Nombre:   " + prod.getNombre());
    System.out.println("Precio:   $" + prod.getPrecio());
    System.out.println("Stock:    " + prod.getStock() + " unidades");
    System.out.println("---------------------------------------");
}
}

    

