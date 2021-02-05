package ejemplo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "libro") //si es el mismo nombre no es necesario
public class Libro {
	
	
    private Integer id_pub;
    private String isbn;
    private String autor;
    
 
    @Column(name = "id_pub") 	//solo es necesario porque el nombre es distinto
    							//si no, lo infiere automáticamente
    @Id							//para indicar que es clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //porque es AI
    public Integer getId_pub() {
        return id_pub;
    }
 
    public void setId_pub(Integer id_pub) {
        this.id_pub = id_pub;
    }
 
    public String getIsbn() {
        return isbn;
    }
 
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    public String getAutor() {
        return autor;
    }
 
    public void setAutor(String autor) {
        this.autor = autor;
    }
 
    
}