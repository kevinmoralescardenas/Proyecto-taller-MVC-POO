package vista;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaUsuario extends VistaProducto{

    private Scanner teclado;

    public VistaUsuario() {
        teclado = new Scanner(System.in);
    }

    public void mostrarMenuUsuario() {

        System.out.println("\n================================");
        System.out.println("      GESTIÓN DE USUARIOS       ");
        System.out.println("================================");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Mostrar Usuarios");
        System.out.println("3. Buscar Usuario");
        System.out.println("4. Modificar Usuario");
        System.out.println("5. Eliminar Usuario");
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

    public String leerUsuario() {

        System.out.print("Usuario: ");
        return teclado.nextLine();
    }

    public String leerPassword() {

        System.out.print("Contraseña: ");
        return teclado.nextLine();
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println("\n--> " + mensaje);
    }

    public void mostrarUsuarios(ArrayList<Usuario> usuarios) {

        System.out.println("\n--- LISTA DE USUARIOS ---");

        if (usuarios.isEmpty()) {

            System.out.println("No existen usuarios registrados.");
            return;
        }

        for (Usuario user : usuarios) {

            System.out.println("ID: " + user.getId());
            System.out.println("Nombre: " + user.getNombre());
            System.out.println("Correo: " + user.getCorreo());
            System.out.println("Usuario: " + user.getUsuario());

            System.out.println("--------------------------------");
        }
    }

    public void mostrarUsuarioIndividual(Usuario user) {

        if (user == null) {

            System.out.println("❌ Usuario no encontrado.");
            return;
        }

        System.out.println("\n--- DATOS DEL USUARIO ---");
        System.out.println("ID: " + user.getId());
        System.out.println("Nombre: " + user.getNombre());
        System.out.println("Correo: " + user.getCorreo());
        System.out.println("Usuario: " + user.getUsuario());
        System.out.println("-------------------------");
    }
}
