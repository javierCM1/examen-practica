package tienda;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Venta {

    private String codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private Map <Vendible, Integer>items;
   
    
    public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.items = new HashMap<Vendible, Integer>();
   
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

    public void agregarItem(Item item) {
    	items.put(item, 1);
    }
    
    public void agregarItem(Item item,Integer cantidad) {
    	items.put(item, cantidad);
    }

    public Double getTotal() {
        Double total = 0.0;
        for (Map.Entry<Vendible, Integer> entry : items.entrySet()) {
            Vendible vendible = entry.getKey();
            Integer cantidad = entry.getValue();
            total += vendible.getPrecio() * cantidad;
        }
        return total;
    }
     
	
}