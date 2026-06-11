package controlador;

import modelo.Empleado;
import vista.VistaEmpleado;
import java.util.ArrayList;

public class ControladorEmpleado {

    private ArrayList<Empleado> empleados;
    private VistaEmpleado vista;

    public ControladorEmpleado(VistaEmpleado vista) {

        this.vista = vista;
        this.empleados = new ArrayList<>();
    }

    public void iniciar() {

        int opcion;

        do {

            vista.mostrarMenuEmpleado();
            opcion = vista.leerOpcion();

            switch (opcion) {

                case 1:
                    registrarEmpleado();
                    break;

                case 2:
                    vista.mostrarEmpleados(obtenerEmpleados());
                    break;

                case 3:
                    buscarEmpleadoVista();
                    break;

                case 4:
                    modificarEmpleadoVista();
                    break;

                case 5:
                    eliminarEmpleadoVista();
                    break;

                case 6:
                    vista.mostrarMensaje("Saliendo del módulo de empleados...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
            }

        } while (opcion != 6);
    }

    // REGISTRAR
    private void registrarEmpleado() {

        vista.mostrarMensaje("--- REGISTRAR EMPLEADO ---");

        int id = vista.leerId();
        String nombre = vista.leerNombre();
        String correo = vista.leerCorreo();
        String cargo = vista.leerCargo();

        Empleado nuevoEmpleado =
                new Empleado(id, nombre, correo, cargo);

        empleados.add(nuevoEmpleado);

        vista.mostrarMensaje("¡Empleado registrado correctamente!");
        vista.mostrarMensaje("Total de empleados: " + totalEmpleados());
    }

    // MOSTRAR
    public ArrayList<Empleado> obtenerEmpleados() {

        return empleados;
    }

    // BUSCAR DESDE MENÚ
    private void buscarEmpleadoVista() {

        vista.mostrarMensaje("--- BUSCAR EMPLEADO ---");

        int idBuscado = vista.leerId();

        Empleado encontrado = buscarEmpleado(idBuscado);

        vista.mostrarEmpleadoIndividual(encontrado);
    }

    // BUSCAR LÓGICA
    public Empleado buscarEmpleado(int idBuscar) {

        for (Empleado emp : empleados) {

            if (emp.getId() == idBuscar) {

                return emp;
            }
        }

        return null;
    }

    // MODIFICAR DESDE MENÚ
    private void modificarEmpleadoVista() {

        vista.mostrarMensaje("--- MODIFICAR EMPLEADO ---");

        int idModificar = vista.leerId();

        if (buscarEmpleado(idModificar) != null) {

            String nuevoNombre = vista.leerNombre();
            String nuevoCorreo = vista.leerCorreo();
            String nuevoCargo = vista.leerCargo();

            boolean modificado =
                    modificarEmpleado(
                            idModificar,
                            nuevoNombre,
                            nuevoCorreo,
                            nuevoCargo);

            if (modificado) {

                vista.mostrarMensaje("¡Empleado actualizado correctamente!");
            }

        } else {

            vista.mostrarMensaje("Empleado no encontrado.");
        }
    }

    // MODIFICAR LÓGICA
    public boolean modificarEmpleado(
            int idBuscar,
            String nuevoNombre,
            String nuevoCorreo,
            String nuevoCargo) {

        Empleado emp = buscarEmpleado(idBuscar);

        if (emp == null) {

            return false;
        }

        emp.setNombre(nuevoNombre);
        emp.setCorreo(nuevoCorreo);
        emp.setCargo(nuevoCargo);

        return true;
    }

    // ELIMINAR DESDE MENÚ
    private void eliminarEmpleadoVista() {

        vista.mostrarMensaje("--- ELIMINAR EMPLEADO ---");

        int idEliminar = vista.leerId();

        boolean eliminado = eliminarEmpleado(idEliminar);

        if (eliminado) {

            vista.mostrarMensaje("¡Empleado eliminado correctamente!");

        } else {

            vista.mostrarMensaje("Empleado no encontrado.");
        }
    }

    // ELIMINAR LÓGICA
    public boolean eliminarEmpleado(int idBuscar) {

        Empleado emp = buscarEmpleado(idBuscar);

        if (emp == null) {

            return false;
        }

        empleados.remove(emp);

        return true;
    }

    // TOTAL
    public int totalEmpleados() {

        return empleados.size();
    }
}