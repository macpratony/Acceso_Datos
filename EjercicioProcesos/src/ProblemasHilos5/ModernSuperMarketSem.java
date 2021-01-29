package ProblemasHilos5;

import java.util.concurrent.Semaphore;

public class ModernSuperMarketSem {
	
	private static final int numCajas=5;
	private final static int num_clientes=10;
	private static int contador=0;
	private static Semaphore sem1=new Semaphore(1);
	private static Semaphore sem2=new Semaphore(1);
	private static int tiemposClientes[]=new int[num_clientes];
	
	public static void main(String[] args) {

		Thread clientes[]=new Thread[num_clientes];
		for (int i=0; i < num_clientes; i++) {
			int j=i;
			clientes[i]=new Thread() {
				public void run() {
					comprador(j);					
				}
			};
			clientes[i].start();
		}
		
		int media=0;
		for (int i=0; i < num_clientes; i++) {
			try {
				clientes[i].join();
				media+=tiemposClientes[i];
			}
			catch(InterruptedException e) {
				System.out.println("Exception: "+e.getLocalizedMessage());
			}
		}
		
		System.out.println("Tiempo medio: "+ media/num_clientes);
			
		
	}
	
	private static void comprador(int i) {
		
		try {
			 sem1.acquire();
			 if (contador == numCajas) {
				 sem1.release();
				 /* Espero a que quede una ventanilla libre */
				 sem2.acquire();
			 } else sem1.release();
			 sem1.acquire();
			 contador=contador+1; 
			 sem1.release();
			 
			 // Pagar
			 int tiempo =(int)(Math.random()*20);
			 tiemposClientes[i]=tiempo;
			 Thread.sleep(tiemposClientes[i]*1000);
			 System.out.println("Cliente "+i+" tarda en pagar "+tiemposClientes[i]+ " segundos"); 
			 sem1.acquire();
			 if (contador == numCajas) {
				 sem1.release();
				 sem2.release();
			 }  else sem1.release();
			 sem1.acquire(); 
			 contador=contador-1;
			 sem1.release();
			 
			 
		}	 
		catch(InterruptedException e) {
			System.out.println("Exception: "+e.getLocalizedMessage());
		}
			 
		 
	}

}
