package Examen1;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaCompra {
	
	List<Producto> producto;
	
	

	public ListaCompra() {
		super();
	}

	public ListaCompra(List<Producto> producto) {
		super();
		this.producto = producto;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	
	

}
