package ClienteArchivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Archivo_Cliente extends JFrame {

	private JPanel contentPane;
	CrearCliente c ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Archivo_Cliente frame = new Archivo_Cliente();
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
	public Archivo_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ARCHIVO CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(114, 11, 226, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnCrearCliente = new JButton("CREAR");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = new CrearCliente();
				c.setVisible(true);
				
			}
		});
		btnCrearCliente.setBounds(10, 76, 127, 45);
		contentPane.add(btnCrearCliente);
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarCliente mos = new MostrarCliente();
				mos.setVisible(true);
				
				
			}
		});
		btnMostrar.setBounds(297, 76, 127, 45);
		contentPane.add(btnMostrar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActualizarDato ac = new ActualizarDato();
				ac.setVisible(true);
			}
		});
		btnActualizar.setBounds(10, 151, 127, 45);
		contentPane.add(btnActualizar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarCliente eli = new EliminarCliente();
				eli.setVisible(true);
			}
		});
		btnBorrar.setBounds(297, 151, 127, 45);
		contentPane.add(btnBorrar);
	}
}
