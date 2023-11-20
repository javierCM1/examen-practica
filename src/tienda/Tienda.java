package tienda;

import java.util.HashMap;
import java.util.Map;

public class Tienda {

	private String cuit;
	private String nombre;
	private Map<String, Vendible> inventario;
	private Map<String, Integer> stock;
	private Map<String, Cliente> clientes;
	private Map<String, Vendedor> vendedores;
	private Map<String, Venta> ventas;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.inventario = new HashMap<>();
		this.stock = new HashMap<>();
		this.clientes = new HashMap<>();
		this.vendedores = new HashMap<>();
		this.ventas = new HashMap<>();

	}

	public void agregarProducto(Producto producto) {
		inventario.put(producto.getCodigo(), producto);
	}

	public void agregarProducto(Producto producto, Integer cantidad) throws VendibleInexistenteException {
		inventario.put(producto.getCodigo(), producto);
		stock.put(producto.getCodigo(), cantidad);
	}

	public Integer getStock(Producto producto) throws VendibleInexistenteException {
		String codigo = producto.getCodigo();
		if (stock.containsKey(codigo)) {
			return stock.get(codigo);
		} else {
			throw new VendibleInexistenteException("Producto no encontrado en el inventario");
		}
	}

	public Vendible getVendible(String codigo) throws VendibleInexistenteException {
		if (inventario.containsKey(codigo)) {
			return inventario.get(codigo);
		} else {
			throw new VendibleInexistenteException("Producto no encontrado");
		}
	}

	public void agregarCliente(Cliente cliente) {
		clientes.put(cliente.getCuit(), cliente);

	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {
		if (clientes.containsKey(cuitEjemplo)) {
			return clientes.get(cuitEjemplo);
		}
		throw new ClienteInexistenteException("cliente no encontrado");
	}

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.put(vendedor.getDni(), vendedor);

	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {
		if (vendedores.containsKey(dniEjemplo)) {
			return vendedores.get(dniEjemplo);
		}
		throw new VendedorInexistenteException("vendedor inexistente");
	}

	public void agregarVenta(Venta ticket) {
		ventas.put(ticket.getCodigo(), ticket);
	}

	public void agregarProductoAVenta(String codigoVenta, Producto producto, Integer cantidad)
			throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		if (ventas.containsKey(codigoVenta)) {
			
			Venta venta = ventas.get(codigoVenta);
			
			if (inventario.containsKey(producto.getCodigo())) {
				
				Integer stockActual = stock.get(producto.getCodigo());
				
				if (stockActual >= cantidad) {
					venta.agregarItemVenta(producto, cantidad);
					stock.put(producto.getCodigo(), stockActual - cantidad);
				} else {
					throw new StockInsuficienteException("Stock insuficiente para la venta");
				}
				
			} else {
				throw new VendibleInexistenteException("Producto no encontrado en el inventario");
			}
			
		} else {
			throw new VentaInexistenteException("Venta no encontrada");
		}
	}

}