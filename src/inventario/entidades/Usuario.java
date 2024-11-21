
package inventario.entidades;

public class Usuario {
    
    private int id;
    
    private String usuario;
    
    private String contrasenia;
    
    private String nombre;
    
    private Sucursal sucursal;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasenia, String nombre, Sucursal sucursal) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.sucursal = sucursal;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", sucursal=" + sucursal + '}';
    }

       
    
}
