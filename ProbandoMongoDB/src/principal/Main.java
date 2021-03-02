package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		MongoClient cliente = new MongoClient();//Si se dea conectar al atlas dentro de los parentesis se introduciria 
		MongoDatabase db = cliente.getDatabase("alumnos");
		MongoCollection<Document> coleccion = db.getCollection("dam2");

//		// Visualizar los datos en formato cadena
//		System.out.println(" - ----------------------------------------");
//		List<Document> consulta = coleccion.find().into(new ArrayList<Document>());
//		for (int i = 0; i < consulta.size(); i++) {
//			System.out.println(" - " + consulta.get(i).toString());
//			System.out.println(consulta.get(i).get("nombre"));
//			System.out.println(consulta.get(i).get("edad"));
//		}
		Document amigo = new Document();
		amigo.put("nombre", "Pepito2");
		amigo.put("edad", 25);
		
		coleccion.insertOne(amigo);

//		// insertar otro documento en amigos
//		Document amigo2 = new Document("nombre", "Pedro").append("edad", 35);
//
//		coleccion.insertOne(amigo2);

		// insertar varios documentos de una lista
//		System.out.println("start");
//				List<Document> listadocs = new ArrayList<Document>();
//				String op = "";
//				do {
//					Document doc = new Document();
//					String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
//					int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario"));
//					
//					doc.put("nombre", nombre);
//					doc.put("edad", edad);
//					
//					listadocs.add(doc);
//					
//					
//					System.out.println("desea seguir añadiendo mas usuarios si o no ");
//					op = JOptionPane.showInputDialog("Ingrese la opcion");
//				}while(op.equals("si"));
//				
//				coleccion.insertMany(listadocs);
		

	}

}
