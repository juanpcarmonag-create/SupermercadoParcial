package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombre;
    private String direccion;
    private int telefono;

    private List<Producto> listaProductos;
    private List<Cliente> listaClientes;
    private List<Compra> listaCompras;
    //private List<Producto> listaProductosCompra;
   // private List<Producto> listaComprasCliente;

    public Supermercado(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        listaProductos= new ArrayList<>();
        listaClientes= new ArrayList<>();
        listaCompras= new ArrayList<>();
        //listaProductosCompra=new ArrayList<>();
        //listaComprasCliente=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @Override
    public String toString() {
        return nombre + '\'' +
                ", direccion: " + direccion +
                ", telefono: " + telefono;
    }

    public boolean verificarCliente (int documento){
        boolean existe= false;
        for(Cliente cliente: listaClientes){
            if(cliente.getDocumento()== documento){
                existe= true;
                break;
            }
        }
        return existe;
    }

    public boolean agregarCliente(Cliente cliente){
        boolean agregado= false;
        boolean existe= verificarCliente(cliente.getDocumento());
        if(existe==false){
            listaClientes.add(cliente);
            agregado= true;
        }
        return agregado;
    }

    public boolean verificarProducto (int codigoProducto){
        boolean existe= false;
        for(Producto productos: listaProductos){
            if(productos.getCodigoProducto()== codigoProducto){
                existe= true;
                break;
            }
        }
        return existe;
    }

    public boolean agregarProducto(Producto producto){
        boolean agregado= false;
        boolean existe= verificarProducto(producto.getCodigoProducto());
        if(existe==false){
            listaProductos.add(producto);
            agregado= true;
        }
        return agregado;
    }

    public boolean verificarCompra (int codigoCompra){
        boolean existe= false;
        for(Compra compra: listaCompras){
            if(compra.getCodigoCompra()== codigoCompra){
                existe= true;
                break;
            }else {
                break;
            }
        }
        return existe;
    }

    public boolean agregarCompra(Compra compra){
        boolean agregado= false;
        boolean existe= verificarCompra(compra.getCodigoCompra());
        if(existe==false){
            listaCompras.add(compra);
            agregado= true;
        }
        return agregado;
    }

    public Producto verificarCantidadProducto(int codigo, int cantidad){
        Producto product=null;
        for(Producto producto: listaProductos)
            if (producto.getCodigoProducto()==codigo){
                if(producto.getCantidad()-cantidad>=0)
                    producto.setCantidad(producto.getCantidad()-cantidad);
                product=producto;
            }
        return product;
    }

    public boolean verificarListaProductos(List<Producto> lista, int codigo){
        boolean existe= false;
        for(Producto productos: lista){
            if(productos.getCodigoProducto()== codigo){
                existe= true;
                break;
            }
        }
        return existe;
    }


    public boolean agregarProductoCompra(Producto producto,List<Producto> lista, int codigo){
        boolean agregado= false;
        boolean existe=   verificarListaProductos(lista,codigo);
        if(existe==false){
            lista.add(producto);
            agregado= true;
        }
        return agregado;
    }

    public String comprobarComprasCliente(int documento){
        String mensaje="";
        for(Compra compras:listaCompras){
            if(compras.getDocumentoCliente()==documento){
                mensaje+=compras+"\n";
            }else {
                mensaje+="ingrese documento valido";
            }
        }
        return mensaje;
    }

    public String comprobarVentaTotalFecha(LocalDate fecha){
        String mensaje="";
        double valor=0;
        for(Compra compras: listaCompras){
            if(compras.getFecha().equals(fecha)){
                valor+=ValorVentasTotal(compras);
                mensaje+="Valor de las compras realizadas: "+valor;
            }else {
                mensaje+="ingrese documento valido";
            }
        }
        return mensaje;
    }
    public double ValorVentasTotal(Compra compra){
        double valorTotal =compra.getValorTotal();;
        return valorTotal;
    }

    public boolean verificarFechaCompra(LocalDate fecha){
        boolean existe= false;
        for(Compra compra: listaCompras){
            if(compra.getFecha()== fecha){
                existe= true;
                break;
            }
        }
        return existe;
    }

}
