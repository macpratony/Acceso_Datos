package es.marco.practicando.hibernateJPA;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name= "empleado")
public class Empleado {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) ESTA ANOTACION SE PONE SOLO SI QUEREMOS QUE LA CLAVE SEA AUTOINCREMENT
	private String dni;
	
	@Column(name = "nom_emp")
	private String nom_emp;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jefe_proy")
	private Set<Proyecto> dirige;
	
	@ManyToMany(mappedBy = "empleado")
	private Set<Proyecto> proyecto;
	
	public Empleado() {
		super();
	}

	public Empleado(String dni, String nom_emp) {
		super();
		this.dni = dni;
		this.nom_emp = nom_emp;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_emp() {
		return nom_emp;
	}

	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	
	

}
