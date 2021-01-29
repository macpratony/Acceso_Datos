package ejemplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Ejemplo_JPA");
        EntityManager entityManager = factory.createEntityManager();
         
        entityManager.getTransaction().begin();
         
        Libro libro = new Libro();
        libro.setAutor("Cervantes4");
        libro.setIsbn("12345");
         
        entityManager.persist(libro);
        
        Integer id_pub = libro.getId_pub();
        
        System.out.println("Clave generada: "+id_pub);
         
        
        
        //actualizar:
        libro = new Libro();
        libro.setId_pub(id_pub);
        libro.setIsbn("5678");
        libro.setAutor("Cervantes3");
        
         
        entityManager.merge(libro);
        
        //recuperar por clave:
        Integer primaryKey = id_pub;
        Libro libro2 = entityManager.find(Libro.class, primaryKey);
         
        System.out.println(libro2.getAutor());
        System.out.println(libro2.getIsbn());
        
        //ejecutar JPQL:
        String sql = "SELECT l from Libro l where l.autor = :autor";
        Query query = entityManager.createQuery(sql);
        query.setParameter("autor", "Cervantes3");
        libro = (Libro) query.getSingleResult();
         
        System.out.println(libro.getAutor());
        System.out.println(libro.getIsbn());
        
        entityManager.getTransaction().commit();
         
        entityManager.close();
        factory.close();

	}

}
