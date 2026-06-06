package principal;

import modelo.Persona;
import modelo.Usuario;
import modelo.Empleado;
import modelo.Producto;
import java.util.Scanner;
import java.util.ArrayList;



//junior
/**
 *
 * @author usuario
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();

        System.out.println("Sistema de Inventario");
        
        //prueba 1
        Persona persona1 = new Persona();
        persona1.setId(1);
        persona1.setNombre("Carlos");
        persona1.setCorreo("carlos@gmail.com");
        
        persona1.mostrarInformacion();
        
        //prueba 2
        Persona persona2 =
        new Persona(
                2,
                "Ana",
                "ana@gmail.com"
        );
        
        persona2.mostrarInformacion();
        
        Persona persona3 =
        new Persona(
                3,
                "Pedro",
                "pedro@gmail.com"
        );
        
        persona3.mostrarInformacion();
        
        Persona persona4 =
        new Persona(
                4,
                "Laura",
                "Laura@gmail.com"
        );
        
        persona4.mostrarInformacion();
        
        Persona persona5 =
        new Persona(
                5,
                "Andres",
                "andres@gmail.com"
        );
        
        persona5.mostrarInformacion();
        
        //prueba 3 usuario
        
        Usuario usuario1 =
        new Usuario(
                1,
                "Carlos",
                "carlos@gmail.com",
                "carlos123",
                "12345"
        );

        usuario1.mostrarInformacion();
        usuario1.iniciarSesion();
        
        //prueba 4 empleado
        
        Empleado empleado1 =
        new Empleado(
                2,
                "Laura",
                "laura@gmail.com",
                "Administrador"
        );
        
        empleado1.mostrarInformacion();

        empleado1.mostrarCargo();

        //actividad propuesta 5
        Empleado empleado2 =
        new Empleado(
                6,
                "carlos",
                "carlos@gmail.com",
                "supervisor"
        );
        
        empleado2.mostrarInformacion();

        empleado2.mostrarCargo();
        
        Usuario usuario2 =
        new Usuario(
                1,
                "kevin",
                "kevin@gmail.com",
                "kevin123",
                "123456"
        );

        usuario2.mostrarInformacion();
        usuario2.iniciarSesion();
        
        
        //prueba 5 producto
        Producto producto1 =
        new Producto(
                101,
                "Mouse Gamer",
                85000,
                20
        );

        producto1.mostrarInformacion();
        
        Producto producto2 =
        new Producto(
                102,
                "Teclado Mecánico",
                150000,
                10
        );


        Producto producto3 =
        new Producto(
                103,
                "Monitor 24 Pulgadas",
                650000,
                5
        );

        producto1.mostrarInformacion();

        producto2.mostrarInformacion();

        producto3.mostrarInformacion();

        producto1.setStock(30);
        
        producto1.mostrarInformacion();
        
        //actividad propuesta 6
        
        Producto producto4 =
        new Producto(
                104,
                "impresora hp",
                650000,
                5
        );
        
        Producto producto5 =
        new Producto(
                105,
                "WebCam",
                650000,
                5
        );
        
        Producto producto6 =
        new Producto(
                106,
                "disco ssd",
                650000,
                5
        );

        producto4.mostrarInformacion();
        producto5.mostrarInformacion();
        producto6.mostrarInformacion();
        
        producto4.setStock(40);
        
        producto4.mostrarInformacion();
        
        int opcion;
        do {
            System.out.println("\n================================");
            System.out.println(" SISTEMA DE INVENTARIO ");
            System.out.println("================================");

            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            System.out.println("4. Acerca del sistema");
            
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            
            switch(opcion){
                case 1:

                    System.out.println("Registrar producto");
                    int codigo;
                    String nombre;
                    double precio;
                    int stock;
                    System.out.print("Código: ");
                    codigo = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nombre: ");
                    nombre = teclado.nextLine();
                    System.out.print("Precio: ");
                    precio = teclado.nextDouble();
                    Agregar:
                    System.out.print("Stock: ");
                    stock = teclado.nextInt();
                    Producto producto =
                    new Producto(codigo,nombre,precio,stock);
                    inventario.add(producto);
                    System.out.println("Producto registrado correctamente");




                break;
                
                case 2:

                    System.out.println("Mostrar productos");
                    for (Producto p : inventario) {

                    p.mostrarInformacion();

                    System.out.println("----------------");

                    }


                break;
                
                case 3:

                    System.out.println("Fin del programa");

                    System.exit(0);

                break;
                case 4:
                    
                    System.out.println("Sistema desarrollado en Java");
                    
                    
                 break;
                default:

                    System.out.println("Opción no válida");

            }

        } while (true);
        
        

        
        
    }
}
