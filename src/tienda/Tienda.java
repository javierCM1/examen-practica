package tienda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tienda {

	private String nro;
	private String nombre;
	private Map<String, Vendible> productos;
	private Map<String, Cliente> clientes;
	private Map<String, Vendedor>vendedores;
	private Map<String, Venta>ventas;

	public Tienda(String nro, String nombre) {
		super();
		this.nro = nro;
		this.nombre = nombre;
		this.productos = new HashMap<>();
		this.clientes = new HashMap<>();
		this.vendedores = new HashMap<>();
		this.ventas = new HashMap<>();
	}

	public void agregarProducto(Producto producto) {
		productos.put(producto.getCodigo(), producto);

	}

	public void agregarProducto(Producto producto, Integer cantidad) {
		for (int i = 0; i < cantidad; i++) {
			productos.put(producto.getCodigo(), producto);
		}
	}

	public void agregarCliente(Cliente cliente) {
		clientes.put(cliente.getCuit(), cliente);
	}

	public Vendible getVendible(String codigo) throws VendibleInexistenteException {
		if (productos.containsKey(codigo)) {
			return productos.get(codigo);
		} else {
			throw new VendibleInexistenteException("Vendible con código " + codigo + " no encontrado");
		}
	}

	public Integer getStock(Producto producto) {
		Integer stock = 0;
		for (Vendible vendible : productos.values()) {
			if (vendible instanceof Producto && ((Producto) vendible).getCodigo().equals(producto.getCodigo())) {
				stock++;
			}
		}

		return stock;
	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {

		for (Cliente cliente : clientes.values()) {
			if (cliente.getCuit() == cuitEjemplo) {
				return cliente;
			}
		}

		throw new ClienteInexistenteException("Cliente no encontrado");
	}
	

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.put(vendedor.getDni(), vendedor);

	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException{
		if (vendedores.containsKey(dniEjemplo)) {
			return vendedores.get(dniEjemplo);
		}
		throw new VendedorInexistenteException("Vendedor no encontrado");
	}

	public void agregarVenta(Venta venta) {
		ventas.put(venta.getCodigo(), venta);
		
	}

	 public void agregarProductoAVenta(String codigoVenta, Producto producto, Integer cantidad)
	            throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
	        if (ventas.containsKey(codigoVenta)) {
	            Venta venta = ventas.get(codigoVenta);
	            if (productos.containsKey(producto.getCodigo())) {
	                for (int i = 0; i < cantidad; i++) {
	                    Producto productoVendido = (Producto) productos.get(producto.getCodigo());
	                    if (productoVendido != null) {
	                        venta.agregarProducto(productoVendido);
	                        productos.remove(producto.getCodigo());
	                    } else {
	                        throw new StockInsuficienteException("Stock insuficiente para el producto con código " + producto.getCodigo());
	                    }
	                }
	            } else {
	                throw new VendibleInexistenteException("Producto con código " + producto.getCodigo() + " no encontrado");
	            }
	        } else {
	            throw new VentaInexistenteException("Venta con código " + codigoVenta + " no encontrada");
	        }
	    }

}
