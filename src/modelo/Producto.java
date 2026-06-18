
package modelo;


public class Producto {
    private int codigo;//serial PK
    private String nombre;//varchar (20) limite de caracteres
    private double precio;// Numeric (10, 2) entreo y decimal
    private int stock;// integer
    
    public  Producto() {

    }

    public Producto(int codigo,
                String nombre,
                double precio,
                int stock) {

    this.codigo = codigo;
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void mostrarInformacion() {

    System.out.println("Codigo: " + codigo);
    System.out.println("Nombre: " + nombre);
    System.out.println("Precio: " + precio);
    System.out.println("Stock: " + stock);

}
    
}
