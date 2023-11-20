package tienda;

public class ItemServicio {

	private Servicio servicio;
	private Integer cantidad;

	public ItemServicio(Servicio servicio, Integer cantidad) {
		super();
		this.servicio = servicio;
		this.cantidad = cantidad;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
