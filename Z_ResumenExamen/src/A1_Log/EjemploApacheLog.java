package A1_Log;
	
import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;

public class EjemploApacheLog {

	/*Se crea el archivo logger con modificador de acceso final para que no se pueda modificar
	 * y las demas clases no puedan modificarlo
	 * ES INDISPENSABLE CREAR EL ARCHIVO log4j2.xml ya que en ese archivo se especifica toda lo que queremos capturar
	 * se copia directamente el archivo al proyecto y se importan las librerias 
	 */
	
    private static final Logger logger = LogManager.getLogger(EjemploApacheLog.class);

    public static void main(String[] args) {

    	//sin archivo de configuración en src, coge uno por defecto con nivel en error
    	
    	logger.info("Entrando en main");
    	logger.debug("Soy un aviso de depuración Log4j 2");
    	logger.warn("Aviso");
    	logger.error("Error");
        logger.fatal("Error fatal");
        
        
        //uso otra clase:
        ClaseAdicional2.metodoConLog();

        
    }

    
}