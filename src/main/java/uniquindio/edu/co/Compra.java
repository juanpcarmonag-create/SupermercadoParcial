package uniquindio.edu.co;
import java.time.LocalDate;
import java.util.List;

public class Compra {
    private int codigoCompra;
    private LocalDate fecha;
    private MetodosPago metodosPago;
    private double valorTotal;
    private int documentoCliente;

    private List<Producto> listaProductosCompra;

    //private Cliente documento;
    //private Producto producto;

    public Compra(int documentoCliente, int codigoCompra, LocalDate fecha, MetodosPago metodosPago, double valorTotal, List<Producto> listaProductosCompra) {
       // this.documento = cliente;
        this.documentoCliente=documentoCliente;
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.metodosPago = metodosPago;
        this.valorTotal = valorTotal;
        this.listaProductosCompra=listaProductosCompra;


    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodosPago getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(MetodosPago metodosPago) {
        this.metodosPago = metodosPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public List<Producto> getListaProductosCompra() {
        return listaProductosCompra;
    }

    public void setListaProductosCompra(List<Producto> listaProductosCompra) {
        this.listaProductosCompra = listaProductosCompra;
    }

    @Override
    public String toString() {
        return
                "codigoCompra=" + codigoCompra +
                ", fecha=" + fecha +
                ", metodosPago=" + metodosPago +
                ", valorTotal=" + valorTotal +
                ", documentoCliente=" + documentoCliente +
                ", listaProductosCompra=" + listaProductosCompra +
                '}';
    }
}
