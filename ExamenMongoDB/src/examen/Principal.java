package examen;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




public class Principal {
	

	public static void main(String[] args) throws IOException {
		BufferedReader mac = new BufferedReader (new InputStreamReader(System.in));
		
		MongoClient cliente = new MongoClient();
		MongoDatabase db = cliente.getDatabase("equipos");
		MongoCollection<Document> coleccion = db.getCollection("equipos");
		
		
		
		System.out.println("1.- Dado el nombre de un jugador mostrar en que equipo juega");
		System.out.println("2.- Mostrar el equipo con mas jugadores");
		int op = Integer.parseInt(mac.readLine());
		
		switch (op) {
		
			case 1:
				
				System.out.println("Ingrese el nombre de un jugador");
				String nombre = mac.readLine();

				List<Document> equipos = coleccion.find().into(new ArrayList<Document>());
				
				for (Document equipo : equipos) {

					List<Document> jugadores = (ArrayList<Document>) equipo.get("jugadores");

					for (Document jugador : jugadores) {
						if (jugador.getString("nombre").equals(nombre)) {
							System.out.println("El jugador "+nombre+" juega en el equipo de: "+equipo.getString("nombreEquipo"));
						}
					}

				}

				cliente.close();

			
				break ;
				
			case 2:
				
				List<Document> equi = coleccion.find().into(new ArrayList<Document>());
				
				int max = 0;
				String nombreEquipo = "";
				
				for(Document equipo : equi) {
					
					List<Document> jugadores = (ArrayList<Document>) equipo.get("jugadores");
					
					if (jugadores.size() > max) {
						max = jugadores.size();
						nombreEquipo = equipo.getString("nombreEquipo");
					}
					
				}
				
				System.out.println("El equipo con mas jugadores es: "+nombreEquipo);
				
				cliente.close();
				
				break;
				
				
			}
		
				
	
		}		
		
	}
