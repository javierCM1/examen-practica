package tienda;

public class ItemVenta {

    private Producto producto;
    private Integer cantidad;

    public ItemVenta(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}