package tienda;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Servicio implements Vendible {

    private String codigo;
    private String nombre;
    private Double precio;
    private Date fechaInicio;
    private Date fechaFin;

    public Servicio(String codigo, String nombre, Double precio, String fechaInicioStr, String fechaFinStr) throws ParseException {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaInicio = dateFormat.parse(fechaInicioStr);
        this.fechaFin = dateFormat.parse(fechaFinStr);
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

    
	
}