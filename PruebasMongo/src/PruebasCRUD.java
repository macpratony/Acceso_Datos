import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;

public class PruebasCRUD {

	public static void main(String[] args) {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("alumnos");
		MongoCollection<Document> coleccion = db.getCollection("dam2");

		//INSERTAR
		//insertamos documento que contiene array de documentos:
		Document d = new Document();
		d.append("nombre", "Carlos");
		d.append("edad", 20);
		
		ArrayList<String> telefonos = new ArrayList<>();
		telefonos.add("1234");
		telefonos.add("5678");
		
		d.append("telefonos", telefonos);
		
		ArrayList<Document> array = new ArrayList<Document>();
		array.add(new Document().append("nombre", "Acceso a datos").append("nota", 8));
		array.add(new Document().append("nombre", "Android").append("nota", 4));
		d.append("asignaturas", array);
		
		//coleccion.insertOne(d);
		
		
		//trabajamos con DBObject:
		BasicDBObject objJSON = new BasicDBObject();
		objJSON.put("nombre", "Sonia");
		objJSON.put("edad", 22);
		
		telefonos = new ArrayList<>();
		telefonos.add("9999");
		telefonos.add("5555");
		
		//objJSON.put("telefonos",telefonos);
		
		//DBList es una lista de DBObject:
		BasicDBList lista = new BasicDBList();
		lista.add(new BasicDBObject().append("nombre", "Android").append("nota", 6));
		lista.add(new BasicDBObject().append("nombre", "Acceso a datos").append("nota", 4));
		objJSON.put("asignaturas", lista);
		
		Document doc2 =  new Document(objJSON);
		//coleccion.insertOne(doc2);
		
		
		//CONSULTAS:
		
		// Visualizar los datos en formato cadena
		System.out.println(" - ----------------------------------------");
		List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
		for (int i = 0; i < consulta.size(); i++) {
			System.out.println(" - " + consulta.get(i).toString());
		}
				
		//recuperar datos con arrays de objetos:
		consulta = coleccion.find().into(new ArrayList<Document>());
		for(Document doc : consulta) {
					
			String nombre = doc.getString("nombre");
			System.out.println("Nombre: " + nombre);
			
			List<String> lista_telefonos = (ArrayList<String>) doc.get("telefonos");
			for(String tel : lista_telefonos)
				System.out.println(tel);
			
			List<Document> asignaturas = (ArrayList<Document>) doc.get("asignaturas");
			System.out.println("Número de asignaturas: "+asignaturas.size());
			for(Document asignatura : asignaturas) {
				String nomAsig = asignatura.getString("nombre");
				int nota = asignatura.getInteger("nota");
				System.out.println("--- Asignatura: " + nomAsig);
				System.out.println("--- Nota: " + nota);
			}
		}
		
		
		
		//CONSULTAS CON CRITERIOS:
		
		//búsqueda por campo:
		System.out.println(" - ----------------------------------------");
		consulta = coleccion.find(Filters.eq("nombre", "Luis")).into(new ArrayList<Document>());
		for (int i = 0; i < consulta.size(); i++) {
			System.out.println(" - " + consulta.get(i).toString());
		}
		
		//USO DEL MÉTODO FIND PASANDO UN DOCUMENT COMO QUERY Y RECUPERANDO CON ITERATOR:
		Document query = new Document().append("nombre", "Sonia");
		FindIterable<Document> fit = coleccion.find(query);
		MongoCursor<Document> it = fit.iterator();
		
		while(it.hasNext()) {
			//System.out.println(it.next().toJson());
		}
		
		//para usar $gt, $lt, $ne..... HABRÁ QUE CREAR EL DOCUMENTO
		//MEJOR PROBAR EN EL COMPASS LA CONSULTA ANTES
		query = new Document().append("edad", new Document().append("$gt", 21));
		fit = coleccion.find(query);
		it = fit.iterator();
		
		while(it.hasNext()) {
			//System.out.println(it.next().toJson());
		}
		
		//INVOLUCRAMOS ARRAYS
		
		//búsqueda por array es idéntico:
		array = new ArrayList<Document>();
		array.add(new Document().append("nombre", "Acceso a datos").append("nota", 10));
		
		query = new Document().append("asignaturas",array);
		fit = coleccion.find(query);
		it = fit.iterator();
		
		while(it.hasNext()) {
			//System.out.println("***"+it.next().toJson());
		}
		
		
		
		//AND, OR...
		//SE PUEDE HACER PASANDO UN DOCUMENT CON TODOS LOS CAMPOS DEL CRITERIO
		
		//Y TAMBIÉN CON CLASE FILTERS:
		
		//edad no estamos comparando con un campo simple, por eso hacemos un Document aparte para él
		query = new Document().append("$gt", 18);
		it = coleccion.find(Filters.and(Filters.eq("nombre", "Carlos"),Filters.eq("edad", query))).iterator();
		
		while(it.hasNext()) {
			//System.out.println("****"+it.next().toJson());
		}
		
		//buscar documentos cuya propiedad array contenga un valor
		//ejemplo: { "telefonos" : {"$in" : ["1234"]}}
		
		List<String> l = new ArrayList<>();
		l.add("1234");
		
		d = new Document().append("$in", l);
		query = new Document("telefonos",d);
		
		it = coleccion.find(Filters.eq("telefonos", d)).iterator();
		
		//y también valdría:
		it = coleccion.find(query).iterator();
		
		while(it.hasNext()) {
			//System.out.println("*****"+it.next().toJson());
		}
		
		//cuando el array es de objetos embebidos:
		//alumnos matriculados de Acceso a datos:
		//{ "asignaturas.nombre" : {"$in" : ["Acceso a datos"]}}
		//in("asignaturas.nombre", Arrays.asList("Acceso a datos"))
		l = new ArrayList<>();
		l.add("Acceso a datos");
		
		d = new Document().append("$in", l);
		
		it = coleccion.find(Filters.eq("asignaturas.nombre", d)).iterator();
		
		while(it.hasNext()) {
			//System.out.println("******"+it.next().toJson());
		}
		
		//alumnos aprobados en Acceso a datos
		//se puede coger los matriculados en Acceso a datos y de ahí seleccionar los aprobados
		
		l = new ArrayList<>();
		l.add("Acceso a datos");
		 
		d = new Document().append("$in", l);
		
		it = coleccion.find(Filters.eq("asignaturas.nombre", d)).iterator();
		while(it.hasNext()) {
			d = it.next();
			ArrayList<Document> asignaturas = (ArrayList<Document>) d.get("asignaturas");
			for(Document asig : asignaturas) {
				if(asig.getString("nombre").equals("Acceso a datos") &&
						asig.getInteger("nota")>=5)
					System.out.println("Ha aprobado "+d.getString("nombre"));
			}
		}
		
		//PARA RECUPERAR SOLO ALGUNOS CAMPOS DE LOS DOCUMENTOS SE INCLUYE PROJECTION:
		l = new ArrayList<>();
		l.add("Acceso a datos");
		
		d = new Document().append("$in", l);
		
		it = coleccion.find(Filters.eq("asignaturas.nombre", d)).projection(Projections.include("nombre","asignaturas")).iterator();
		while(it.hasNext()) {
			d = it.next();
			ArrayList<Document>  asignaturas = (ArrayList<Document>) d.get("asignaturas");
			for(Document asig : asignaturas) {
				if(asig.getString("nombre").equals("Acceso a datos") &&
						asig.getInteger("nota")>=5)
					System.out.println("Ha aprobado "+d.getString("nombre"));
			}
		}
		
		//ACTUALIZACIONES
		//EL CRITERIO SE FIJA DE LA MISMA MANERA:
		
		l = new ArrayList<>();
		l.add("Acceso a datos");
		
		d = new Document().append("$in", l);
		coleccion.updateMany(Filters.eq("asignaturas.nombre", d), Updates.set("edad", 18));
		//Updates admite más métodos...
		
		//POR EJEMPLO, PARA AÑADIR ASIGNATURAS A UN ALUMNO SE PODRÍA ACTUALIZAR EL CAMPO ASIGNATURAS...
		//Updates.addToSet("asignaturas", lo que fuera...) añade a un array
		
		//BORRADOS
		
		l = new ArrayList<>();
		l.add("Acceso a datos");
		
		d = new Document().append("$in", l);
		coleccion.deleteMany(Filters.eq("asignaturas.nombre", d));
		
		cliente.close();
	}

}
