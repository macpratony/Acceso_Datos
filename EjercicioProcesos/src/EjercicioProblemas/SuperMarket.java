package EjercicioProblemas;

public class SuperMarket extends Thread {

	static int clientes = 10;
	static int caja = 5;
	static int x=0;
	static Boolean[] cajas = new Boolean[5];
	
	public static void main(String[] args) {

		Thread[] cliente = new Thread[clientes];
		
		
		
		for(int i=0; i<clientes; i++) {
			x = i+1;
			cliente[i] = new Thread(){
				
				public void run() {					
					

				}
			};
			
			cliente[i].start();
		}
		
	}
	
	public static void operacion(int cliente) {
		
		int eligeCaja = (int) Math.abs(Math.random()*4+1);
		int espera = (int) Math.abs(Math.random()*1000+1);
		
		cajas[eligeCaja] = false;
		
		if(cajas[eligeCaja] = false) {
			cajas[eligeCaja] = true;
			try {
				sleep(espera);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
