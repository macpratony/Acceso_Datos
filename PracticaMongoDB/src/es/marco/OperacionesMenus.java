package es.marco;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class OperacionesMenus {
	
	//1.- Insertar un nuevo menú
	public static void insertarNuevoMenu () {

		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
		Document menu = new Document();
		String op = "";
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del menu"));
		String nombreMenu = JOptionPane.showInputDialog("Ingrese el nombre del menu");
			
		menu.append("codigo", codigo);
		menu.append("nombre", nombreMenu);
		ArrayList<String> restaurantes = new ArrayList<>();
		
			do {
				
				String nombreRestaurante = JOptionPane.showInputDialog("Ingrese el nombre del restaurnte");
				restaurantes.add(nombreRestaurante);
				op = JOptionPane.showInputDialog("Desea añadir mas restaurantes si o no");
				
			}while(op.equals("si"));
		
		menu.append("restaurantes", restaurantes);
		
		ArrayList<Document> platos = new ArrayList<Document>();
		
			do {
				
				String nombrePlato = JOptionPane.showInputDialog("Ingrese el nombre del Plato");
				double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del plato"));
				
				platos.add(new Document().append("nombre", nombrePlato).append("precio", precio));
				op = JOptionPane.showInputDialog("Desea añadir mas platos si o no");
				
			}while(op.equals("si"));
			
		menu.append("platos", platos);
		
		coleccion.insertOne(menu);
		cliente.close();
		
		JOptionPane.showMessageDialog(null, "Menu ingresado correctamente");
		
		
	}
	
	//2.- Dado el codigo del menu, recuperar los nombres de los platos que lo forman
	public static void recuperarNombresPlatos() {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del menu"));
		String mostrar = "";
		List<Document> consulta = coleccion.find(Filters.eq("codigo", codigo)).into(new ArrayList<Document>());
		for(int i=0; i<consulta.size(); i++) {
			ArrayList<Document> platos = (ArrayList<Document>) consulta.get(i).get("platos");
			for (Document d : platos) {
				 mostrar += d.getString("nombre")+"\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, mostrar);
		
		cliente.close();
		
	}
	
	
	//3.- Dado el nombre de un plato, mostrar todos los menus que lo contienen
	public static void mostrarMenuPlatos() {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
	
		String nombrePlato = JOptionPane.showInputDialog("Ingrese el nombre del plato");
		String mostrar = "";
		boolean existe = false;
		
		List<String> platos = new ArrayList<>();
		platos.add(nombrePlato);

		Document query = new Document().append("$in", platos);
		MongoCursor<Document> it = coleccion.find(Filters.eq("platos.nombre", query)).iterator();

		
		
		while(it.hasNext()) {
			mostrar += it.next().getString("nombre")+"\n";
			existe = true;
		}
		if(existe == false) {
			JOptionPane.showMessageDialog(null, "No hay Ningun Menú que contenga el plato "+ platos.get(0));
		}else {
			JOptionPane.showMessageDialog(null, mostrar);
		}
		
		
		cliente.close();
		
	}
	
	//4.- Dado el codigo de menu, mostrar su precio
	public static void mostrarPrecio() {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Inserte el codigo del menú"));
		double total = 0;
		
		ArrayList<Document> menu = coleccion.find(Filters.eq("codigo", codigo)).into(new ArrayList<Document>());

		for (int i = 0; i < menu.size(); i++) {
			ArrayList<Document> platos = (ArrayList<Document>) menu.get(i).get("platos");
			for (Document d : platos) {
				total += Double.parseDouble(d.get("precio").toString());
				
			}
		}
		
		JOptionPane.showMessageDialog(null, "El precio total del menu es "+ total);
	
	}
	
	//5.- Mostrar los nombres de restaurantes donde se sirve el menu mas caro
	public static void menuMasCaro() {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
		double precio = 0;
		double precioMax = 0;
		String nombreRestaurante = "" ;
		ArrayList<String> res = null;
		ArrayList<Document> menu = coleccion.find().into(new ArrayList<Document>()); //Obtiene toda la informacion de la base de datos
		
		for (int i = 0; i < menu.size(); i++) {
			ArrayList<Document> platos = (ArrayList<Document>) menu.get(i).get("platos");
			for (Document d : platos) {
					precio = Double.parseDouble(d.get("precio").toString());
				
				if(precio > precioMax) {					
					 res = (ArrayList<String>) menu.get(i).get("restaurantes");
					precioMax = precio;
					precio = 0;
				}
			}
		}
		
		for (String s : res) {
			nombreRestaurante += s+", " ;
		}
		
		JOptionPane.showMessageDialog(null, "El restaurante "+nombreRestaurante+" tienen el menú mas caro con un precio de "+precioMax);
		
		cliente.close();
	}
	
	//6.- Añadir un plato a un menu dado su codigo
	public static void anadirPlatoMenu() {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("restaurantes");
		MongoCollection<Document> coleccion = db.getCollection("menus");
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del menu al que desea añadirle un plato"));
		
		String nombrePlato = JOptionPane.showInputDialog("Ingrese el nombre del plato del menu");
		double precioPlato = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del plato"));
		
		Document d = new Document();
		d.append("nombre", nombrePlato).append("precio", precioPlato);
				
			coleccion.updateMany(Filters.eq("codigo", codigo),Updates.addToSet("platos",d));
	
		cliente.close();
		
		JOptionPane.showMessageDialog(null,"Plato añadido correctamente" );		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
