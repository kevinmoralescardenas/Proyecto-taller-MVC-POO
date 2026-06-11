package controlador;

import modelo.Producto;
import vista.VistaProducto;
import java.util.ArrayList;






public class ControladorProducto {
    private ArrayList<Producto> inventario;
    private VistaProducto vista;

    public ControladorProducto(VistaProducto vista) {
        this.inventario = new ArrayList<>();
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    ejecutarRegistro();
                    break;
                case 2:
                    ArrayList<Producto> listaActual = obtenerProductos();
                    vista.mostrarProductos(listaActual);
                    break;
                case 3:
                    vista.mostrarMensaje("--- BUSCAR PRODUCTO POR CÓDIGO ---");
                    int idBuscar = vista.leerCodigo();
                    Producto encontrado = buscarProducto(idBuscar);
                    vista.mostrarProductoIndividual(encontrado);
                    break;
                case 4:
                    // FLUJO MIGRADO: MODIFICAR PRODUCTO
                    vista.mostrarMensaje("--- MODIFICAR PRODUCTO ---");
                    int idModificar = vista.leerCodigo();
                    
                    // Verificamos primero si existe para no pedir datos en vano
                    if (buscarProducto(idModificar) != null) {
                        String nuevoNombre = vista.leerNombre();
                        double nuevoPrecio = vista.leerPrecio();
                        int nuevoStock = vista.leerCantidad();
                        
                        boolean modificado = modificarProducto(idModificar, nuevoNombre, nuevoPrecio, nuevoStock);
                        if (modificado) {
                            vista.mostrarMensaje("¡Producto actualizado con éxito!");
                        }
                    } else {
                        vista.mostrarMensaje("[Error]: El producto no existe. No se puede modificar.");
                    }
                    break;
                case 5:
                    // FLUJO MIGRADO: ELIMINAR PRODUCTO
                    vista.mostrarMensaje("--- ELIMINAR PRODUCTO ---");
                    int idEliminar = vista.leerCodigo();                    
                    boolean eliminado = eliminarProducto(idEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("¡Producto eliminado correctamente del inventario!");
                    } else {
                        vista.mostrarMensaje("[Error]: El producto no existe. No se pudo eliminar.");
                    }
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo del sistema de inventario...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }


        } while (opcion != 6);
    }
    
    

    // --- MÉTODO DE NEGOCIO: REGISTRAR PRODUCTO ---
    private void ejecutarRegistro() {
        vista.mostrarMensaje("--- REGISTRAR NUEVO PRODUCTO ---");
        
        // 1. La vista captura los datos individuales
        int codigo = vista.leerCodigo();
        String nombre = vista.leerNombre();
        double precio = vista.leerPrecio();
        int cantidad = vista.leerCantidad();

        // 2. El controlador crea el objeto (Modelo) con los datos obtenidos
        Producto nuevoProducto = new Producto(codigo, nombre, precio, cantidad);

        // 3. Se almacena en la colección del Controlador
        inventario.add(nuevoProducto);

        // 4. Se le pide a la vista informar el éxito y el estado del inventario
        vista.mostrarMensaje("¡Producto registrado correctamente!");
        vista.mostrarMensaje("Total de productos en el inventario: " + totalProductos());
    }

    // Método auxiliar para conocer el tamaño actual del inventario
    public int totalProductos() {
        return inventario.size();
    }
    
    // Retorna la lista completa de productos almacenados en el inventario
public ArrayList<Producto> obtenerProductos() {
    return this.inventario;
}


    // Lógica de Negocio: Busca un producto por su código y lo retorna. Si no existe, retorna null.
    public Producto buscarProducto(int codigoBuscar) {
        for (Producto producto : this.inventario) {
            if (producto.getCodigo() == codigoBuscar) {
                return producto; // Coincidencia encontrada, retornamos el objeto completo
            }
        }
        return null; // Finalizó el ciclo y el código no existe en el ArrayList
    }

    
    

    // Lógica de Negocio: Modifica un producto existente si es localizado por su código
    public boolean modificarProducto(int codigoBuscar, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        Producto producto = buscarProducto(codigoBuscar); // Reutilizamos la búsqueda
        
        if (producto == null) {
            return false; // No existe, la modificación no es posible
        }
        
        // Si existe, actualizamos sus propiedades encapsuladas
        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(nuevoStock); // Sincronizado con el atributo 'cantidad' del modelo
        return true;
    }

    // Lógica de Negocio: Elimina un producto del ArrayList si coincide con el código
    public boolean eliminarProducto(int codigoBuscar) {
        Producto producto = buscarProducto(codigoBuscar);
        
        if (producto == null) {
            return false; // No existe, no se puede eliminar
        }
        
        this.inventario.remove(producto); // Remueve la instancia completa del ArrayList
        return true;
    }

    
    
    
    
    
    
    
}

