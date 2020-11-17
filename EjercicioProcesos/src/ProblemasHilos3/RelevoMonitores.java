package ProblemasHilos3;

public class RelevoMonitores {
	
	private static int corredores=4;
	private static int x =1;
	
	public static void main(String[] args) {
		
		Thread[] correr = new Thread[corredores];
		
		try {
			
			System.out.println("Todos los hilos creados.");
			System.out.println("Doy la salida");
			Thread.sleep(1000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0; i<corredores; i++) {
			correr[i] = new Thread() {
				
				public void run() {
					pasarRelevo();
					x++;
				}
				
			};
			
			try {
				correr[i].start();
				correr[i].join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		System.out.println("Soy el entrenador, todos mis alumnos han terminado de correr");

	}
public  static synchronized void pasarRelevo() {
		
		try {
				
				System.out.println("Soy el corredor "+x +", corriendo.......");
				Thread.sleep(2000);
				
				if(x<corredores)
					System.out.println("Terminé de correr. Paso el relevo al corredor "+(x+1));
				else
					System.out.println("Terminé de correr.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
