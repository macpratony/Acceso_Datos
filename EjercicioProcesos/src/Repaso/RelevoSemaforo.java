package Repaso;

import java.util.concurrent.Semaphore;

public class RelevoSemaforo {

	static Semaphore s = new Semaphore(0);
	static int a = 1;
	
	public static void main(String[] args) {
		
		Thread[] t = new Thread[5];
		
		for (int i=0; i<t.length; i++) {
			t[i] = new Thread() {
				
				@Override
				public void run() {
					try {
						s.acquire();
						correr();
						a++;
						s.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			t[i].start();
		}
		
		System.out.println("Todos los hilos creados");
		System.out.println("Doy el pistoletazo");
		
		s.release();
		
		for(int i=0; i<5 ; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Soy el entrenador, todos mis alumnos terminaron");

	}
	
	public static void correr() {
		try {
			System.out.println("Soy el correrdor "+a+" corriendo.......");
			Thread.sleep(2000);
			if(a<4) {
				System.out.println("Terminé de correr. Paso el relevo al corredor " + (a+1));
			}else {
				System.out.println("Terminé de correr");
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
