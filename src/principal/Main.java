package principal;

import controlador.ControladorProducto;
import controlador.ControladorUsuario;
import controlador.ControladorEmpleado;

import vista.VistaProducto;
import vista.VistaUsuario;
import vista.VistaEmpleado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Vistas
        VistaProducto vProd = new VistaProducto();
        VistaUsuario vUser = new VistaUsuario();
        VistaEmpleado vEmp = new VistaEmpleado();

        // Controladores
        ControladorProducto cProd = new ControladorProducto(vProd);
        ControladorUsuario cUser = new ControladorUsuario(vUser);
        ControladorEmpleado cEmp = new ControladorEmpleado(vEmp);

        int modulo;

        do {

            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE INVENTARIO - MENU GLOBAL");
            System.out.println("========================================");
            System.out.println("1. Modulo de Productos");
            System.out.println("2. Modulo de Usuarios");
            System.out.println("3. Modulo de Empleados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            try {

                modulo = Integer.parseInt(entrada.nextLine());

            } catch (NumberFormatException e) {

                modulo = -1;
            }

            switch (modulo) {

                case 1:
                    cProd.iniciar();
                    break;

                case 2:
                    cUser.iniciar();
                    break;

                case 3:
                    cEmp.iniciar();
                    break;

                case 4:
                    System.out.println("\nApagando sistema...");
                    break;

                default:
                    System.out.println("\n❌ Opción inválida.");
            }

        } while (modulo != 4);

        entrada.close();
    }
}

