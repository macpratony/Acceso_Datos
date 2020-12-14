package A1_Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClaseAdicional2 {
	
	static final Logger logger = LogManager.getLogger(ClaseAdicional2.class);

	public static void metodoConLog() {
		
		logger.debug("Entrando en método de ClaseAdicional");
		logger.error("Se ha producido un error en método de ClaseAdicional");
		System.out.println("Comprobando que funciona con github");
		
	}

}
