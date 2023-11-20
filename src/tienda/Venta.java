package tienda;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private String codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemVenta> items;
    private List<ItemServicio> itemsSer;
    
    public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.items = new ArrayList<>();
        this.itemsSer = new ArrayList<>();
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

    public void agregarItemServicio(Servicio servicio, Integer cantidad) {
        ItemServicio item = new ItemServicio(servicio, cantidad);
        itemsSer.add(item);
    }

    public Double getTotal() {
        double total = 0;

        for (ItemVenta item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }

        for (ItemServicio itemSer : itemsSer) {
            total += itemSer.getServicio().getPrecio() * itemSer.getCantidad();
        }

        return total;
    }
	

	
}