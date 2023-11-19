package tienda;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vededor;

	public Venta(String idVenta, Cliente cliente, Vendedor vededor) {
		super();
		this.codigo = idVenta;
		this.cliente = cliente;
		this.vededor = vededor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVededor() {
		return vededor;
	}

	public void setVededor(Vendedor vededor) {
		this.vededor = vededor;
	}

	
}
