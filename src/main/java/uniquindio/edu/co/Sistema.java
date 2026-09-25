package uniquindio.edu.co;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Sistema {
    private MetodosPago metodosPago;
    private Categoria categoria;
    static void main() {
        Scanner sc=new Scanner(System.in);
        Supermercado supermercado= new Supermercado("MarketPlus", "1-3", 32294);

        int opcion;
        do{
            System.out.println("┌--------------====Supermercado====--------------┐");
            System.out.println("│       1.Agregar productos al inventario        │");
            System.out.println("│         2.Ingresar cliente al sistema          │");
            System.out.println("│                3.Generar compra                │");
            System.out.println("│  4.Consultar compras realizadas por un cliente │");
            System.out.println("│          5.Consultar ventas acumuladas         │");
            System.out.println("│              6.verificar inventario            │");
            System.out.println("│               0.Finalizar Programa             │");
            System.out.println("└------------------------------------------------┘");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){

                case 1: System.out.println("____Datos producto____");

                    System.out.print("Codigo: ");
                    int codigo=sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreProducto=sc.nextLine();


                    System.out.print("Ingrese categoria en mayusculas: ");
                    String catProducto = sc.nextLine();
                    Categoria categoria1 = Categoria.valueOf(catProducto);

                    System.out.print("Precio: ");
                    double precio=sc.nextDouble();

                    System.out.print("Cantidad:");
                    int cantidad= sc.nextInt();
                    sc.nextLine();

                    Producto producto=new Producto(codigo, nombreProducto,categoria1, precio, cantidad);


                    if(supermercado.agregarProducto(producto)){
                        System.out.println();
                        System.out.print(producto);
                        System.out.println("Producto agregado correctamente ");
                        System.out.println();
                    }
                    break;



                case 2:System.out.println("____Datos Cliente____");

                    System.out.print("Nombre: ");
                    String nombreCliente=sc.nextLine();

                    System.out.print("Documento: ");
                    int documento= sc.nextInt();

                    System.out.print("Telefono: ");
                    int telefono= sc.nextInt();
                    sc.nextLine();

                    System.out.print("Correo: ");
                    String correo=sc.nextLine();

                    Cliente cliente=new Cliente(nombreCliente,documento,telefono,correo);

                    if(supermercado.agregarCliente(cliente)){
                        System.out.println();
                        System.out.println(cliente);
                        System.out.println("Cliente agregado correctamente");
                        System.out.println();
                    }else{
                        System.out.println();
                        System.out.print("El cliente ya existe");
                        System.out.println();
                    }
                    break;

                case 3: System.out.println("____Generar compra____");

                    System.out.println("Ingrese documento del cliente: ");
                    int documentoClienteVerificar=sc.nextInt();
                    sc.nextLine();
                    if(supermercado.verificarCliente(documentoClienteVerificar)){
                    }else{
                        System.out.println();
                        System.out.println("ingresa documento válido");
                        System.out.println();
                        break;
                    }

                    System.out.print("Ingrese el codigo compra: ");
                    int codigoCompra= sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese la fecha de la compra (dd/mm/aaaa): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String textoFecha = sc.nextLine();
                    LocalDate fecha = LocalDate.parse(textoFecha, formato);

                    System.out.print("Ingrese Metodo de pago en mayusculas: ");
                    String metPago = sc.nextLine();
                    MetodosPago metodosPago1 = MetodosPago.valueOf(metPago);

                    List<Producto> miLista = new ArrayList<>();
                    double valorTotal=0;

                    int op;
                    do {
                        System.out.println("┌-----------==Pedido==-----------┐");
                        System.out.println("│ 1.Agregar producto a la compra │");
                        System.out.println("│      0.pedido completado       │");
                        System.out.println("└--------------------------------┘");
                        op=sc.nextInt();
                        switch (op){
                            case 1:
                                System.out.println();
                                System.out.println("Productos disponibles: \n"+supermercado.getListaProductos());

                                System.out.println("Escriba el codigo del producto: ");
                                int codigoProd= sc.nextInt();

                                System.out.println("¿Cuantos desea?: ");
                                int cantidadProducto= sc.nextInt();

                                Producto clienteCompra=supermercado.verificarCantidadProducto(codigoProd,cantidadProducto);
                                if (supermercado.agregarProductoCompra(clienteCompra,miLista,codigoProd)){
                                    System.out.println();
                                    System.out.println("Producto agregado a la compra");
                                    System.out.println();
                                }else{
                                    System.out.println();
                                    System.out.println("Codigo invalido o producto agotado");
                                    System.out.println();
                                }


                                for(Producto producto1: miLista){

                                    valorTotal+= producto1.getPrecio()*cantidadProducto;
                                }
                                break;
                            case 0:
                                System.out.println("________Compra finalizada_________");
                                break;
                            default:
                                System.out.println("Opción no válida");

                        }
                    }while (op!=0);

                    Compra compra= new Compra(documentoClienteVerificar,codigoCompra,fecha,metodosPago1,valorTotal,miLista);

                    if(supermercado.agregarCompra(compra)){
                        System.out.println();
                        System.out.println(compra);
                        System.out.println("Compra agregada correctamente al sistema ");
                        System.out.println();

                    }else{
                        System.out.println();
                        System.out.print("la compra ya existe");
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("_____==Registro de compras de un cliente==_____");
                    System.out.println("Ingrese el documento del cliente: ");
                    int documentoCompras= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Las compras realizadas por el cliente son: ");
                    System.out.println(supermercado.comprobarComprasCliente(documentoCompras));

                    break;

                case 5:
                    System.out.println("_____==Ventas totales==____");
                    System.out.println("Fecha de la compra (dd/mm/aaaa)");

                    System.out.println("Ingrese la fecha de la compra (dd/mm/aaaa): ");
                    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String textoFecha1 = sc.nextLine();
                    LocalDate fecha1 = LocalDate.parse(textoFecha1, formato1);
                    double ventasTotales=0;
                    System.out.println(supermercado.comprobarVentaTotalFecha(fecha1));
                    /*if (supermercado.verificarFechaCompra(fecha1)) {
                        for (Compra compra1 : supermercado.getListaCompras()) {
                            if (compra1.getFecha().equals(fecha1)) {
                                ventasTotales += compra1.getValorTotal();
                                System.out.println();
                                System.out.println("Las ventas totales del " + fecha1 + " son de: " + ventasTotales);
                                System.out.println();
                            }
                        }
                    }else{
                            System.out.println("Ingrese fecha válida");
                        }*/
                    break;

                case 6:
                    System.out.println("____==Inventario Disponible==____");
                    System.out.println(supermercado.getListaProductos());
                    break;

                case 0:
                    System.out.println("Programa finalizado.....");
                    break;
                default:
                    System.out.println("Opción no válida....");
                    break;

            }
        }while (opcion!=0);

    }

}
