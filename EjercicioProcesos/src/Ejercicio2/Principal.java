package Ejercicio2;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

public class Principal {
	
	private static int numero = 0;
	private static Semaphore se = new Semaphore(1);
	
	public static void main(String[] args) {
		
		
		
		Thread t = new Thread() {
			
			public void run() {
				for(int i=0; i<10000; i++) {
					try {
						se.acquire();
						numero++;
						se.release();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=0; i<10000; i++) {
					try {
						se.acquire();
						numero--;
						se.release();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		t.start();
		
		t2.start();
		
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println(numero);
	}
	
	public static void add() {
		numero++;
	}
	
	public static void sub() {
		numero--;
	}
	
	
}
