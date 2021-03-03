package es.marco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Operaciones {
	static BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));

	public static void altaLibro() throws IOException {
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("biblioteca");
		MongoCollection<Document> coleccion = db.getCollection("libros");
		
		Document libros = new Document();
		
		System.out.println("Ingrese el nombre del autor");
		String nombre = mac.readLine();
		
		System.out.println("Ingrese la tematica del libro");
		String tematica = mac.readLine();
		
		System.out.println("Ingrese el titulo del libro");
		String titulo = mac.readLine();
		
		libros.append("autor", nombre);
		libros.append("tematica",tematica);
		libros.append("titulo", titulo);
		
		coleccion.insertOne(libros);
		cliente.close();
	}
	
	//Eliminar todos los libros de un autor
	public static void eliminarLibro() throws IOException {
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("biblioteca");
		MongoCollection<Document> coleccion = db.getCollection("libros");
		
		System.out.println("Ingrese el nombre del autor");
		String autor = mac.readLine();
		
		//List<Document> documento = coleccion.find(Filters.eq("autor", autor)).into(new ArrayList<Document>());
		List<Document> documento = coleccion.find().into(new ArrayList<Document>());
		for (Document d : documento) {
			if(d.get("autor").equals(autor)) {
				coleccion.deleteMany(d);
			}
		}
		cliente.close();
	}
	
	// Mostrar todos los titulos que pertenecen a una tematica dada
	public static void mostrarTitulos() throws IOException {
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("biblioteca");
		MongoCollection<Document> coleccion = db.getCollection("libros");
		
		
		System.out.println("Ingrese la tematica del libro");
		String tematica = mac.readLine();
		
		List<Document> documento = coleccion.find().into(new ArrayList<Document>());
	}
}















