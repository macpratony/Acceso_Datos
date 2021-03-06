package clases.marcoprado.com;
// Generated 18 ene. 2021 11:23:32 by Hibernate Tools 5.2.12.Final

/**
 * LineaEstacion generated by hbm2java
 */
public class LineaEstacion implements java.io.Serializable, Comparable<LineaEstacion>{

	private LineaEstacionId id;
	private Estaciones estaciones;
	private Lineas lineas;
	private int orden;

	public LineaEstacion() {
	}

	public LineaEstacion(LineaEstacionId id, Estaciones estaciones, Lineas lineas, int orden) {
		this.id = id;
		this.estaciones = estaciones;
		this.lineas = lineas;
		this.orden = orden;
	}

	public LineaEstacionId getId() {
		return this.id;
	}

	public void setId(LineaEstacionId id) {
		this.id = id;
	}

	public Estaciones getEstaciones() {
		return this.estaciones;
	}

	public void setEstaciones(Estaciones estaciones) {
		this.estaciones = estaciones;
	}

	public Lineas getLineas() {
		return this.lineas;
	}

	public void setLineas(Lineas lineas) {
		this.lineas = lineas;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int compareTo(LineaEstacion o) {
		
		if(o.getOrden()>orden) {
			return -1;
		}else if(o.getOrden()>orden) {
			return 0;
		}else {
			return 1;
		}
	}


}
