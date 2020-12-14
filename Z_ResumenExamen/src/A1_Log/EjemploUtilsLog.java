package A1_Log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EjemploUtilsLog {

    
	public static Logger logger = Logger.getLogger("LoggerPrueba");
	
	public static void main(String... args){
    	
    	FileHandler fh;

        try {

            fh = new FileHandler(".\\archivo.log", true);
            logger.addHandler(fh);
            
            

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            
            

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    	logger.info("mensaje info");
    	
    	logger.log(Level.SEVERE,"Grave lo que ha pasado");
    	
    	ClaseAdicional.metodoConLog();
        
    }
}