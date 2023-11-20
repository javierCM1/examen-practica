package tienda;

import java.util.Date;

public class Servicio implements Vendible {

    private String codigo;
    private String nombre;
    private Double precio;
    private Date fechaInicio;
    private Date fechaFin;

    public Servicio(String codigo, String nombre, Double precio, Date fechaInicio, Date fechaFin) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

	
}