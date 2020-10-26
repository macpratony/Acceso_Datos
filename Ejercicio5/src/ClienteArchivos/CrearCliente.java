package ClienteArchivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.awt.event.ActionEvent;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField texNif;
	private JTextField textNombre;
	private JTextField textEmail;
	private int nif;
	private String nombre;
	private String email;
	private HashSet<Cliente> cli = new HashSet<Cliente>();
	private Cliente cliente;
	RandomAccessFile raf ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
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
	public CrearCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("CREAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(143, 11, 149, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIF");
		lblNewLabel_1.setBounds(20, 75, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(20, 120, 88, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setBounds(20, 170, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		texNif = new JTextField();
		texNif.setBounds(149, 72, 96, 20);
		contentPane.add(texNif);
		texNif.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(149, 117, 96, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(149, 167, 96, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 raf = new RandomAccessFile("archivo", "rw");
					nif = Integer.parseInt((texNif.getText()));
					nombre = textNombre.getText();
					email = textEmail.getText();
					cliente = new Cliente(nif, nombre, email);
							
					Operaciones op = new Operaciones(raf);
					op.altaCliente(cliente);
					
					JOptionPane.showMessageDialog(null,"Cliente creado con exito");
					
					texNif.setText("");
					textNombre.setText("");
					textEmail.setText("");
					
					
					
					
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		btnCrear.setBounds(287, 110, 105, 35);
		contentPane.add(btnCrear);
	}
	
}
