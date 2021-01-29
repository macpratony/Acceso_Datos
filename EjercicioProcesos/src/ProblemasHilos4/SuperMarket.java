package ProblemasHilos4;

import java.util.concurrent.Semaphore;

public class SuperMarket extends Thread {

	private static Semaphore[] semaforo = new Semaphore[5];
	private static int tiempos[] = new int[10];
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			semaforo[i] = new Semaphore(1); //Iniciamos los semaforos
		}
		
		//Creamos los hilos que van a ser los clientes
		Thread[] clientes = new Thread[10];
		
		for(int i=0; i<10; i++) {
			int j=i+1;
			clientes[i] = new Thread() {
				public void run() {
					cajeros(j);
				}
			};
			clientes[i].start();
		}
		
		float media = 0;
		for(int i=0; i<10; i++) { //Hacemos que cada hilo se ejecute hasta su muerte
			try {
				clientes[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			media+=tiempos[i];
		}
		media=media/10;
		System.out.println("La media de tiempos es "+media);
	}
	
	public static void cajeros(int cliente) {
		
		int numero_caja = (int)Math.random()*5;
		System.out.println("El cliente "+cliente+" se pone en la cola "+(numero_caja+1));
		try {
			semaforo[numero_caja].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tiempos[cliente -1] = (int)(Math.random()*10+1);
			try {
				sleep(tiempos[cliente-1]*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int pago=(int)(Math.random()*95+5);
			System.out.println("El cliente "+cliente+" ha pagado: "+pago+" en la caja "+(numero_caja+1)+" con una duración de "+tiempos[cliente-1]);
			semaforo[numero_caja].release();
	}

}
