
package modelo;


public class Empleado extends Persona{
    
    private String cargo;//varchar (20) limite de caracteres

    public Empleado() {

    }

    public Empleado(int id,
                String nombre,
                String correo,
                String cargo) {

    super(id, nombre, correo);

    this.cargo = cargo;

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void mostrarCargo() {

    System.out.println("Cargo: " + cargo);

}

    
    
    
}
