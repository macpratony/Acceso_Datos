package ProblemasHilos5;

public class HacerCola {
	
	private int NCajas=0;
	private int cajas[]={0,0,0,0,0};

	public synchronized void entrar(int cliente) {
		if (NCajas == 5) {			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		NCajas++;
		int k=0;
		for (k=0; k < 5; k++) 
			if ( cajas[k]==0) {
				cajas[k]=cliente;
				break;
		}
		System.out.println("ENTRADA: Cliente "+(cliente)+" entra en "+k+".");
		System.out.println("Cajas libres: "+ (5-NCajas)); 
		for (int i=0; i < 5; i++)
			System.out.print("["+cajas[i]+"] ");
		System.out.println("");
		
		
		
	}
	
	public synchronized void salir(int cliente) {
		System.out.println("SALIDA: Cliente "+cliente+" saliendo");
		
		if (NCajas == 5) {
			notify();
		}
		NCajas--;
		System.out.println("Cajas libres: "+ (5-NCajas)); 
		for (int i=0; i < 5; i++) 
			if ( cajas[i]==cliente) {
				cajas[i]=0;
				break;
			}
		for (int i=0; i < 5; i++)
			System.out.print("["+cajas[i]+"] ");
		System.out.println("");
	}
}

