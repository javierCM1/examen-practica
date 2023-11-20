package tienda;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private String codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemVenta> items;

    public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.items = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    public void agregarItemVenta(Producto producto, Integer cantidad) {
        ItemVenta item = new ItemVenta(producto, cantidad);
        items.add(item);
    }

	
}