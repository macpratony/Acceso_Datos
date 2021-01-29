package ProblemasHilos5;

import java.lang.Thread;

import java.lang.Math;


public class ModernSuperMarket {
	
	
	public static void main(String[] args) { 
		Thread clientes[]=new Thread[10];
		HacerCola hcola=new HacerCola();

		for (int i=0; i<10; i++) {
			int j=i;
			clientes[i]=new Thread("Cliente" + (j+1)) {
				public void run() {
					hcola.entrar(j+1);
					int t=(int)(Math.random()*10);
					try {
						Thread.sleep(t*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					hcola.salir(j+1);
					
				} 
			};
			clientes[j].start();
		}
	}
	
	

}