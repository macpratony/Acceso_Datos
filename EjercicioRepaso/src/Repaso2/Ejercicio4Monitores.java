package Repaso2;

public class Ejercicio4Monitores {
	
	static Object[] caja = new Object[5];
	
	public static void main(String[] args) {
		
		
		Thread[] cliente = new Thread[10];
		
		for(int i=0; i<5; i++) {
			caja[i] = new Object();
		}
		
		for(int i=0; i<cliente.length; i++) {
			cliente[i] = new Thread() {
				
				@Override
				public void run() {
					
					int numCaja = (int)(Math.random()*5);
					
					synchronized(caja[numCaja]) {
						try {
							caja[numCaja].wait();
							System.out.println("Cliente comprando en la caja " + (numCaja+1));
							Thread.sleep(2000);
							caja[numCaja].notifyAll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
				
			};
			cliente[i].start();
		}
		
		for(int i=0; i<5; i++) {
			synchronized(caja[i]) {
				caja[i].notifyAll();
			}
		}
		
		for(int i=0; i<10; i++) {
			try {
				cliente[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Todos los clientes terminaron de comprar");
		

	}

}
