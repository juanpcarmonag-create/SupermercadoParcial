package uniquindio.edu.co;

public class Producto {
    private int codigoProducto;
    private String nombre;
    private Categoria Categoria;
    private double precio;
    private int cantidad;

    public Producto(int codigoProducto, String nombre, Categoria Categoria, double precio, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.Categoria=Categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto(Categoria categoria) {
        Categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto=" + codigoProducto +
                ", nombre='" + nombre + '\'' +
                ", Categoria=" + Categoria +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
