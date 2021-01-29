package Ejercicio3;

import java.util.concurrent.Semaphore;

public class Relevos {
	private static Semaphore se = new Semaphore(0);
    static int i = 1;
	public static void main(String[] args) {
		
		Corredor c1 = new Corredor("Corredor 1");
		Corredor c2 = new Corredor("Corredor 2");
		Corredor c3 = new Corredor("Corredor 3");
		Corredor c4 = new Corredor("Corredor 4");
		
		try {
			
		System.out.println("La carrera empieza");
		Thread.sleep(1000);
		
			
			c1.start();
			c2.start();
			c3.start();
			c4.start();
			
			se.release(1);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	static class Corredor extends Thread{
		 
		 String corredor;

		public Corredor(String corredor) {
			super();
			this.corredor = corredor;
		}
		 
		 public void run() {
			 
			 	try {
			 		se.acquire();
					System.out.println("Soy "+corredor+" he terminado de correr y le paso el relevo al "+corredor);
					se.release();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		
	}

}
