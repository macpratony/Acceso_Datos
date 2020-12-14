package A7_Json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

public class MainLectura {

    public static void main(String[] args) {

    	//si conocemos exactamente la estructura, no necesitamos el has, por ejemplo
    	//Este String tambien se puede guardar leyendo un fichero de texto normal
    	
    	/*
    	 * 
    	  
    	 
            
    	 * 
    	 */
    			try {
					BufferedReader leer = new BufferedReader(new FileReader("aulas.json")); //Añade el archivo al BufferedReader
					
					String cadena = ""; //Variable para leer cada linea del archivo
					String aux = "";	//Variable para guardar cada linea que se lea
					
					while((cadena=leer.readLine()) != null) { //Si la cadena leida es diferente de vacio (null)
						aux += cadena;						//Guarda cada linea leida y cuando ya no haya lineas finaliza el bucle
					}
					
					//System.out.println(aux); //Imprime lo que ha leido del archivo
					
					leer.close();
					
					
					Gson gson = new Gson();
					Aulas au[] = gson.fromJson(aux,Aulas[].class);
					
					for (Aulas aulas : au) {
						System.out.println(aulas);
					}
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			
    			
    			
    	
    	
    	/*
        String jsonAll = "[{\"dorsal\":1,\"name\":\"Casillas\",\"demarcation\":[\"Goalkeeper\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":15,\"name\":\"Ramos\",\"demarcation\":[\"Right back\",\"Centre-back\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":3,\"name\":\"Pique\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":5,\"name\":\"Puyol\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":11,\"name\":\"Capdevila\",\"demarcation\":[\"Left back\"],\"team\":\"Villareal\"},"
                + "{\"dorsal\":14,\"name\":\"Xabi Alonso\",\"demarcation\":[\"Defensive midfield\",\"Midfield\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":16,\"name\":\"Busquets\",\"demarcation\":[\"Defensive midfield\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":8,\"name\":\"Xavi Hernandez\",\"demarcation\":[\"Midfielder\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":18,\"name\":\"Pedrito\",\"demarcation\":[\"Left winger\",\"False forward\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":6,\"name\":\"Iniesta\",\"demarcation\":[\"Right winger\",\"Midfielder\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":7,\"name\":\"Villa\",\"demarcation\":[\"Centre forward\"],\"team\":\"FC Barcelona\"}]";

        Gson gson = new Gson();
        FootballPlayer[] footballPlayers = gson.fromJson(jsonAll, FootballPlayer[].class);
        
        for (FootballPlayer footballPlayer : footballPlayers) {
            System.out.println(footballPlayer);
            if(footballPlayer.getDorsal() == 14) {
            	System.out.println(footballPlayer.getName()+" "+footballPlayer.getDemarcation()+" "+footballPlayer.getTeam());
            }
        }*/

    }
}
