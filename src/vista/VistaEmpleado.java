package vista;

import modelo.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaEmpleado extends VistaProducto{

    private Scanner teclado;

    public VistaEmpleado() {
        teclado = new Scanner(System.in);
    }

    public void mostrarMenuEmpleado() {

        System.out.println("\n================================");
        System.out.println("      GESTIÓN DE EMPLEADOS      ");
        System.out.println("================================");
        System.out.println("1. Registrar Empleado");
        System.out.println("2. Mostrar Empleados");
        System.out.println("3. Buscar Empleado");
        System.out.println("4. Modificar Empleado");
        System.out.println("5. Eliminar Empleado");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Elija una opción: ");
    }

    

    public int leerId() {

        while (true) {
            try {

                System.out.print("ID: ");
                int id = teclado.nextInt();
                teclado.nextLine();
                return id;

            } catch (java.util.InputMismatchException e) {

                System.out.println("❌ Error: El ID debe ser numérico.");
                teclado.nextLine();
            }
        }
    }

    public String leerNombre() {

        System.out.print("Nombre: ");
        return teclado.nextLine();
    }

    public String leerCorreo() {

        System.out.print("Correo: ");
        return teclado.nextLine();
    }

    public String leerCargo() {

        System.out.print("Cargo: ");
        return teclado.nextLine();
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println("\n--> " + mensaje);
    }

    public void mostrarEmpleados(ArrayList<Empleado> empleados) {

        System.out.println("\n--- LISTA DE EMPLEADOS ---");

        if (empleados.isEmpty()) {

            System.out.println("No existen empleados registrados.");
            return;
        }

        for (Empleado emp : empleados) {

            System.out.println("ID: " + emp.getId());
            System.out.println("Nombre: " + emp.getNombre());
            System.out.println("Correo: " + emp.getCorreo());
            System.out.println("Cargo: " + emp.getCargo());
            System.out.println("--------------------------------");
        }
    }

    public void mostrarEmpleadoIndividual(Empleado emp) {

        if (emp == null) {

            System.out.println("❌ Empleado no encontrado.");
            return;
        }

        System.out.println("\n--- DATOS DEL EMPLEADO ---");
        System.out.println("ID: " + emp.getId());
        System.out.println("Nombre: " + emp.getNombre());
        System.out.println("Correo: " + emp.getCorreo());
        System.out.println("Cargo: " + emp.getCargo());
        System.out.println("--------------------------");
    }
}
