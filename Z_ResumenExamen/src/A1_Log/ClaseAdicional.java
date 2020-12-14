package A1_Log;

import java.util.logging.Logger;

public class ClaseAdicional {
	
	public static Logger logger = Logger.getLogger("LoggerPrueba");

	public static void metodoConLog() {
		
		logger.info("He entrado en ClaseAdicional");
		
	}

}
