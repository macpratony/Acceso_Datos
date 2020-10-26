package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat1 extends JFrame {

	private JPanel contentPane;
	static JTextField textTexto2;
	static PipedInputStream leer = new PipedInputStream();
	static PipedOutputStream escribe = new PipedOutputStream();
	static JLabel lblRecibe2 = new JLabel("");
	//static PipedOutputStream write = new PipedOutputStream();
	//static PipedOutputStream escribir = new PipedOutputStream();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) throws Exception {
		 leer.connect(ChatConHilos.escribir);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat2 frame = new Chat2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chat1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblRecibe2 = new JLabel("");
		lblRecibe2.setBounds(0, 37, 434, 182);
		contentPane.add(lblRecibe2);
		
		textTexto2 = new JTextField();
		textTexto2.setBounds(0, 224, 270, 37);
		contentPane.add(textTexto2);
		textTexto2.setColumns(10);
		
		JButton btnEnviar2 = new JButton("ENVIAR");
		btnEnviar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Runnable r = new Escribir(escribe);
					Thread t = new Thread(r);
					
					Runnable r1 = new LeerDos(Chat2.lee);
					Thread t1 = new Thread(r1);
				
					t.start();
					t1.start();
					
				textTexto2.setText("");
				
			}
		});
		btnEnviar2.setBounds(295, 224, 139, 37);
		contentPane.add(btnEnviar2);
		
		JLabel lblNewLabel = new JLabel("CHAT 1");
		lblNewLabel.setBounds(165, 0, 139, 25);
		contentPane.add(lblNewLabel);
	}

}

 class Leer implements Runnable{
	
	private  PipedInputStream lee;

	public Leer(PipedInputStream read) {
		super();
		lee = read;
	}
	
	public void run() {
		int n;
		String cadena = "";
	
		try {
			
			
			while((n=lee.read()) != -1) {
				char a = (char) n;
				cadena += a;
			
			}
			
			Chat1.lblRecibe2.setText(cadena +"                 "+"Chat 2.1");
			
			lee.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
 class Escribir implements Runnable {
		
		private  PipedOutputStream escribe;

		public Escribir(PipedOutputStream write) {
			super();
			escribe = write;
		}
		
		public void run() {
			try {
			
			String cadena = Chat1.textTexto2.getText();
			
			
			
				for(int i=0; i<cadena.length(); i++) {
					int n = cadena.charAt(i);
					
						escribe.write(n);
					//escribe.flush();
					
				}
			
			
			escribe.close();
			
			} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		}
		

	}
