package Examen1;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre","cantidad", "precioUnidad", "pendiente"})
public class Producto {
	
	String nombre;
	String cantidad;
	String precioUnidad;
	String pendiente;
	
	
	public Producto() {
		super();
	}


	public Producto(String nombre, String cantidad, String precioUnidad, String pendiente) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		this.pendiente = pendiente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getPrecioUnidad() {
		return precioUnidad;
	}


	public void setPrecioUnidad(String precioUnidad) {
		this.precioUnidad = precioUnidad;
	}


	public String getPendiente() {
		return pendiente;
	}


	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}
	
	
	
	

}
