package tienda;


public class Servicio extends Item {

	private String fechaInicio;
	private String fechaFin;

	public Servicio(String codigo, String nombre, Double precio, String fechaInicio, String fechaFin) {
		super(codigo, nombre, precio);
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

}