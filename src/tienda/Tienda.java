package tienda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tienda {

	private String cuit;
	private String nombre;
	private Set<Vendible> inventario;
	private Map<Producto, Integer> stock;
	private List<Cliente> clientes;
	private Set<Vendedor> vendedores;
	private Set<Venta> ventas;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.inventario = new HashSet<>();
		this.stock = new HashMap<>();
		this.clientes = new ArrayList<>();
		this.vendedores = new HashSet<>();
		this.ventas = new HashSet<>();

	}

	public void agregarServicio(Servicio servicio) {
		inventario.add(servicio);

	}

	public void agregarVenta(Venta ticket) {
		ventas.add(ticket);
	}

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);

	}

	public void agregarProducto(Producto producto) {
		inventario.add(producto);
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);

	}

	public void agregarProducto(Producto producto, Integer cantidad) throws VendibleInexistenteException {
		inventario.add(producto);
		stock.put(producto, cantidad);
	}

	public Integer getStock(Producto producto) throws VendibleInexistenteException {
		Integer stockProducto = stock.get(producto);

		if (stockProducto == null) {
			throw new VendibleInexistenteException("El producto no se encuentra en el stock");
		}

		return stockProducto;
	}

	public Vendible getVendible(String codigo) throws VendibleInexistenteException {
		for (Vendible v : inventario) {
			if (v.getCodigo().equals(codigo)) {
				return v;
			}
		}

		throw new VendibleInexistenteException("vendible no encontrado");
	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {
		for (Cliente cliente : clientes) {
			if (cliente.getCuit().equals(cuitEjemplo)) {
				return cliente;
			}
		}
		throw new ClienteInexistenteException("cliente no encontrado");
	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getDni().equals(dniEjemplo)) {
				return vendedor;
			}
		}
		throw new VendedorInexistenteException("vendedor inexistente");
	}

	public void agregarProductoAVenta(String codigoVenta, Producto producto, Integer cantidad)
			throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {

		Venta ventaAtual = null;

		for (Venta venta : ventas) {
			if (venta.getCodigo().equals(codigoVenta)) {
				ventaAtual = venta;
				break;
			}
		}

		if (ventaAtual == null) {
			throw new VentaInexistenteException("Venta inexistente");
		}

		Vendible vendible = getVendible(producto.getCodigo());

		if (vendible != null && vendible instanceof Producto) {
			Integer stockActual = stock.get(producto);

			if (stockActual != null && stockActual >= cantidad) {
				ventaAtual.agregarItem(producto,cantidad);
				stock.put(producto, stockActual - cantidad);
			} else {
				throw new StockInsuficienteException(
						"Stock insuficiente para el producto con código " + producto.getCodigo());
			}
			
		} else {
			throw new VendibleInexistenteException("Vendible inexistente o no es un producto");
		}
	}

	public void agregarServicioAVenta(String codigo, Servicio servicio) throws VendibleInexistenteException, VentaInexistenteException {
		
		Venta ventaActual = null;

		for (Venta venta : ventas) {
			if (venta.getCodigo().equals(codigo)) {
				ventaActual = venta;
				break;
			}
		}
		
		if(ventaActual == null) {
			throw new VentaInexistenteException("venta inexistente");
		}
		
		Vendible vendible = getVendible(servicio.getCodigo());
		
		if(vendible instanceof Servicio) {
			ventaActual.agregarItem(servicio);
		}
		
	}

}