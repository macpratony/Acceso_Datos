package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Chat2 extends JFrame {

	private JPanel contentPane;
	static JTextField textTexto1;
	static PipedOutputStream escribir = new PipedOutputStream();
	static PipedInputStream lee = new PipedInputStream();
	static JLabel lblRecibe = new JLabel("");
	//static PipedInputStream read = new PipedInputStream();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) throws Exception {
		escribir.connect(Chat2.leer);
		
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
	public Chat2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		//JLabel lblRecibe = new JLabel("");
		lblRecibe.setBounds(0, 43, 434, 171);
		contentPane.add(lblRecibe);
		
		textTexto1 = new JTextField();
		textTexto1.setBounds(0, 216, 277, 34);
		contentPane.add(textTexto1);
		textTexto1.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			/*
				Runnable r = new EscribirDos(escribir);
				Thread t = new Thread(r);
				
				Runnable r1 = new Leer(Chat1.leer);
				Thread t2 = new Thread(r1);
			
				t.start();
				t2.start();*/
				Thread w = new EscribirDos(escribir);
				w.start();
				
				Thread r = new Leer(Chat1.leer);
				r.start();
			
				
			
				
				textTexto1.setText("");
			}
			
		});
		btnEnviar.setBounds(298, 216, 126, 32);
		contentPane.add(btnEnviar);
		
		JLabel lblNewLabel = new JLabel("CHAT 2");
		lblNewLabel.setBounds(186, 0, 91, 14);
		contentPane.add(lblNewLabel);
	}
}
class LeerDos extends Thread{
	
	private PipedInputStream lee;

	public LeerDos(PipedInputStream read) {
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
			
				Chat2.lblRecibe.setText("Chat 1     "+cadena);
				
				lee.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
class EscribirDos extends Thread {
		
		private PipedOutputStream escribe;
	
		public EscribirDos(PipedOutputStream write) {
			super();
			escribe = write;
		}
		
		public void run() {
			try {
			
			String cadena = Chat2.textTexto1.getText();	
		
				for(int i=0; i<cadena.length(); i++) {
					int n = cadena.charAt(i);
					
						escribe.write(n);
					//escribe.flush();
		
		
				}
				
			
				
			//escribe.close();
			
			} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		}
		

	}
