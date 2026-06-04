package modelo;

/**
 *
 * @author usuario
 */
public class Usuario extends Persona {
    private String usuario;
    private String password;

    public Usuario() {

    }
    
    public Usuario(int id,
               String nombre,
               String correo,
               String usuario,
               String password) {

    super(id, nombre, correo);

    this.usuario = usuario;
    this.password = password;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void iniciarSesion() {

    System.out.println("Bienvenido " + usuario);

    }
    
    


}
    