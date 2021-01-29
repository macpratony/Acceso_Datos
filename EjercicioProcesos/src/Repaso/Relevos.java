package Repaso;

public class Relevos {
	
	static Object o = new Object();
	static int a = 1;

	public static void main(String[] args) {
		Thread[] t = new Thread[4];
		
		for(int i=0; i<4; i++) {
			 t[i] = new Thread() {
				
				@Override
				public void run() {
					synchronized(o){
						
						try {
							o.wait();
							correr();
							a++;
							o.notify();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			};
			
			t[i].start();
		}
		
		System.out.println("Todos los hilos creados");
		System.out.println("Doy la salida");

		synchronized(o) {
			o.notifyAll();
		}
		
		for(int i=0; i<4; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Soy el entrenador todos mis aluimnos terminaron de correr");
	}
	
	public static void correr() {
		try {
			System.out.println("Soy el hilo "+a+", saliendo");
			Thread.sleep(3000);
			if(a<4) {
				System.out.println("Termine de correr paso el relevo al hijo " + (a+1) );
			}else {
				System.out.println("Terminé de correr");
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
