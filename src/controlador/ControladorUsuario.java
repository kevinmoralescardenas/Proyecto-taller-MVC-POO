package controlador;

import modelo.Usuario;
import vista.VistaUsuario;
import java.util.ArrayList;

public class ControladorUsuario {

    private ArrayList<Usuario> usuarios;
    private VistaUsuario vista;

    public ControladorUsuario(VistaUsuario vista) {
        this.usuarios = new ArrayList<>();
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;

        do {

            vista.mostrarMenuUsuario();
            opcion = vista.leerOpcion();

            switch (opcion) {

                case 1:
                    ejecutarRegistro();
                    break;

                case 2:
                    ArrayList<Usuario> listaActual = obtenerUsuarios();
                    vista.mostrarUsuarios(listaActual);
                    break;

                case 3:
                    vista.mostrarMensaje("--- BUSCAR USUARIO POR ID ---");

                    int idBuscar = vista.leerId();

                    Usuario encontrado = buscarUsuario(idBuscar);

                    vista.mostrarUsuarioIndividual(encontrado);
                    break;

                case 4:

                    vista.mostrarMensaje("--- MODIFICAR USUARIO ---");

                    int idModificar = vista.leerId();

                    if (buscarUsuario(idModificar) != null) {

                        String nuevoNombre = vista.leerNombre();
                        String nuevoCorreo = vista.leerCorreo();
                        String nuevoUsuario = vista.leerUsuario();
                        String nuevaPassword = vista.leerPassword();

                        boolean modificado =
                                modificarUsuario(
                                        idModificar,
                                        nuevoNombre,
                                        nuevoCorreo,
                                        nuevoUsuario,
                                        nuevaPassword);

                        if (modificado) {

                            vista.mostrarMensaje("¡Usuario actualizado con éxito!");
                        }

                    } else {

                        vista.mostrarMensaje("[Error]: El usuario no existe.");
                    }

                    break;

                case 5:

                    vista.mostrarMensaje("--- ELIMINAR USUARIO ---");

                    int idEliminar = vista.leerId();

                    boolean eliminado = eliminarUsuario(idEliminar);

                    if (eliminado) {

                        vista.mostrarMensaje("¡Usuario eliminado correctamente!");

                    } else {

                        vista.mostrarMensaje("[Error]: El usuario no existe.");
                    }

                    break;

                case 6:

                    vista.mostrarMensaje("Saliendo del módulo de usuarios...");
                    break;

                default:

                    vista.mostrarMensaje("Opción no válida.");
            }

        } while (opcion != 6);
    }

    // REGISTRAR
    private void ejecutarRegistro() {

        vista.mostrarMensaje("--- REGISTRAR NUEVO USUARIO ---");

        int id = vista.leerId();
        String nombre = vista.leerNombre();
        String correo = vista.leerCorreo();
        String usuario = vista.leerUsuario();
        String password = vista.leerPassword();

        Usuario nuevoUsuario =
                new Usuario(id, nombre, correo, usuario, password);

        usuarios.add(nuevoUsuario);

        vista.mostrarMensaje("¡Usuario registrado correctamente!");
        vista.mostrarMensaje("Total de usuarios: " + totalUsuarios());
    }

    // TOTAL
    public int totalUsuarios() {

        return usuarios.size();
    }

    // OBTENER LISTA
    public ArrayList<Usuario> obtenerUsuarios() {

        return this.usuarios;
    }

    // BUSCAR
    public Usuario buscarUsuario(int idBuscar) {

        for (Usuario usuario : this.usuarios) {

            if (usuario.getId() == idBuscar) {

                return usuario;
            }
        }

        return null;
    }

    // MODIFICAR
    public boolean modificarUsuario(
            int idBuscar,
            String nuevoNombre,
            String nuevoCorreo,
            String nuevoUsuario,
            String nuevaPassword) {

        Usuario usuario = buscarUsuario(idBuscar);

        if (usuario == null) {

            return false;
        }

        usuario.setNombre(nuevoNombre);
        usuario.setCorreo(nuevoCorreo);
        usuario.setUsuario(nuevoUsuario);
        usuario.setPassword(nuevaPassword);

        return true;
    }

    // ELIMINAR
    public boolean eliminarUsuario(int idBuscar) {

        Usuario usuario = buscarUsuario(idBuscar);

        if (usuario == null) {

            return false;
        }

        usuarios.remove(usuario);

        return true;
    }
}