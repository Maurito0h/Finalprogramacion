
package inventario.entidades;

public class Stock {
    
    private int id;
    
    private int cantidad;
    
    private Producto producto;
    
    private Sucursal sucursal;

    public Stock() {
    }

    public Stock(int id, int cantidad, Producto producto, Sucursal sucursal) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    // Método para actualizar la cantidad
    public void actualizarCantidad(int cantidadVendida) {
        if (cantidadVendida > 0 && this.cantidad >= cantidadVendida) {
            this.cantidad -= cantidadVendida;
        } else {
            System.out.println("Error: cantidad no válida o stock insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", sucursal=" + sucursal + '}';
    }

    
    
}
