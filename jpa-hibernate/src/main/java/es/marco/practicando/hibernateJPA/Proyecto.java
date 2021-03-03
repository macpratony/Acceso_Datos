package es.marco.practicando.hibernateJPA;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_proy;
	
	@Column(name="nom_proy")
	private String nom_proy;
	
	@ManyToOne
	@JoinColumn(name = "dni_jefe_proy", nullable = false) //especifica donde esta la clave ajena 
	private Empleado jefe_proy;
	
	@JoinTable(
			name = "asig_proyecto",
			joinColumns = @JoinColumn(name = "id_proy", referencedColumnName = "id_proy", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "dni_emp", referencedColumnName = "dni", nullable = false))
	
	//@ManyToMany(mappedBy = "proyecto") //Esto hace que sea bidireccional
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Empleado> empleado;

	public Proyecto() {
		super();
	}

	
	public Proyecto(Integer id_proy, String nom_proy, Empleado dni_jefe_proy, Set<Empleado> empleado) {
		super();
		this.id_proy = id_proy;
		this.nom_proy = nom_proy;
		this.jefe_proy = dni_jefe_proy;
		this.empleado = empleado;
	}


	public Integer getId_proy() {
		return id_proy;
	}


	public void setId_proy(Integer id_proy) {
		this.id_proy = id_proy;
	}


	public String getNom_proy() {
		return nom_proy;
	}


	public void setNom_proy(String nom_proy) {
		this.nom_proy = nom_proy;
	}


	public Empleado getJefe_proy() {
		return jefe_proy;
	}


	public void setJefe_proy(Empleado jefe_proy) {
		this.jefe_proy = jefe_proy;
	}


	public Set<Empleado> getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}

	
	
	

}
