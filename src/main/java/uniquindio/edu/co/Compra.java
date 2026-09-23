package uniquindio.edu.co;
import java.time.LocalDate;

public class Compra {
    private int codigoCompra;
    private LocalDate fecha;
    private MetodosPago metodosPago;
    private double valorTotal;

    public Compra(int codigoCompra, LocalDate fecha,MetodosPago metodosPago, double valorTotal) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.metodosPago=metodosPago;
        this.valorTotal = valorTotal;
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

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra=" + codigoCompra +
                ", fecha=" + fecha +
                ", metodosPago=" + metodosPago +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
