package ProblemasHilos3;

import java.util.concurrent.Semaphore;

public class Relevos extends Thread {
	private static Semaphore se = new Semaphore(0);
	private static int x=1;
	private static int corredores=4;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread [] relevo = new Thread[corredores];
		
		System.out.println("Todos los hilos creados.");
		System.out.println("Doy la salida");
		Thread.sleep(1000);
		
		for(int i=0; i<corredores; i++) { //Se crean los hilos
			relevo[i] = new Thread() {
				public void run() {
							
						try {	
							se.acquire();
							pasarRelevo();
							x++;
							se.release();	
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
				}
				
			};
					
			relevo[i].start();
		}
		
		se.release();  //Se da luz verde al semaforo para que empiecen a ejecutarse los hilos
	
		for(int i=0; i<corredores;i++) { //Obliga a todos los hilos a ejecutarse uno a uno 	
			relevo[i].join();		
		}
			
		System.out.println("Soy el entrenador, todos mis alumnos han terminado de correr");

	}
	
	public static void pasarRelevo() {
		
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
