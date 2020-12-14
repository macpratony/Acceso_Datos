package A7_Json;

import java.util.Arrays;

import java.util.List;
import com.google.gson.Gson;

public class MainEscritura {

	public static void main(String[] args) {
		
		
		//Se crea un array con toda la informacion, se puede pasar cualquier objeto con esta libreria
		List<FootballPlayer> spanishTeam = Arrays.asList(
		        new FootballPlayer(1, "Casillas", Arrays.asList("Goalkeeper"), "Real Madrid"),
				new FootballPlayer(15, "Ramos", Arrays.asList("Right back", "Centre-back"), "Real Madrid"),
				new FootballPlayer(3, "Pique", Arrays.asList("Centre-back"), "FC Barcelona"),
				new FootballPlayer(5, "Puyol", Arrays.asList("Centre-back"), "FC Barcelona"),
				new FootballPlayer(11, "Capdevila", Arrays.asList("Left back"), "Villareal"),
				new FootballPlayer(14, "Xabi Alonso", Arrays.asList("Defensive midfield", "Midfield"), "Real Madrid"),
				new FootballPlayer(16, "Busquets", Arrays.asList("Defensive midfield"), "FC Barcelona"),
				new FootballPlayer(8, "Xavi Hernandez", Arrays.asList("Midfielder"), "FC Barcelona"),
				new FootballPlayer(18, "Pedrito", Arrays.asList("Left winger", "False forward"), "FC Barcelona"),
				new FootballPlayer(6, "Iniesta", Arrays.asList("Right winger", "Midfielder"), "FC Barcelona"),
				new FootballPlayer(7, "Villa", Arrays.asList("Centre forward"), "FC Barcelona")
				);
		
		//Guarda en un string el JSON generado,
		//Para guardarlo en un fichero externo se puede hacer como si fuera un fichero de texto normal,
		//con las metodos de la clase: FileWriter
		
		
		/*
		 * 
			
			//CODIGO NO COMPROBADO PUEDE DAR ERRORES
			
			FileWriter escritura = new FileWriter("fich.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(escritura);
			
			bfwriter.write(json);//se le pasa el string con la informacion del JSON

		 * 
		 */
		
		String json = new Gson().toJson(spanishTeam);
		System.out.println(json);
		

	}

}
