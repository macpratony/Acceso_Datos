package EjercicioChat;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	 PipedInputStream leer = new PipedInputStream();
	 PipedOutputStream escribir = new PipedOutputStream();
	 JTextArea textDatos;
	 JTextArea textTexto;
	 String cadena;
	 JLabel lblNewLabel = new JLabel("");
	 String resultado = "";
	
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//JLabel lblNewLabel = new JLabel("CHAT ");
		lblNewLabel.setBounds(159, 11, 48, 14);
		contentPane.add(lblNewLabel);
		
		textTexto = new JTextArea();
		textTexto.setBounds(10, 228, 235, 22);
		contentPane.add(textTexto);
		
		 textDatos = new JTextArea();
		textDatos.setBounds(10, 39, 414, 178);
		contentPane.add(textDatos);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqui solo va ingresar el texto recibido por pantalla a la tuberia cada vez que haga clic en ENVIAR
				 cadena = textTexto.getText().trim();
				int n;
				try {
					for(int i=0; i<cadena.length();i++) {
						n = cadena.charAt(i);
						escribir.write(n);
					}
					resultado += cadena+ "          escribe...."+lblNewLabel.getText()+"\n";
					textDatos.setText(resultado);
					
				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
					textTexto.setText("");			
				
			}
		});
		btnNewButton.setBounds(293, 229, 89, 23);
		contentPane.add(btnNewButton);
	}
			
	
}
