package es.marco;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String dni;
	
	//si el nombre del atributo se corresponde con el nombre que el de la base de datos
	//no hace falta poner la anotacion
	//@Column(name = "nom_emp") 
	private String nom_emp;
	
	//Este ejercicio tiene dos relaciones: 
	//La primera un empleado puede ser jefe de varios proyectos OneToMany
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jefe_proy")
	private Set<Proyecto> dirige;
	
	//Segunda un 
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
