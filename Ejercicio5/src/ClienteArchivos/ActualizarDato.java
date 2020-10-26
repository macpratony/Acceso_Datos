package ClienteArchivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class ActualizarDato extends JFrame {

	private JPanel contentPane;
	private JTextField textNif;
	private JTextField textNombre;
	private JTextField textEmail;
	private int nif1;
	private String nombre1;
	private String email1;
	RandomAccessFile raf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarDato frame = new ActualizarDato();
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
	public ActualizarDato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACTUALIZACION DE DATOS");
		lblNewLabel.setBounds(130, 11, 232, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIF");
		lblNewLabel_1.setBounds(10, 77, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(10, 121, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setBounds(10, 167, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textNif = new JTextField();
		textNif.setBounds(153, 74, 96, 20);
		contentPane.add(textNif);
		textNif.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(153, 118, 96, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(153, 164, 96, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					raf = new RandomAccessFile("archivo", "rw");
					Operaciones op = new Operaciones(raf);
					
					nif1 = Integer.parseInt(textNif.getText());
					nombre1 = textNombre.getText();
					email1 = textEmail.getText();
					 op.actualizar(nif1, nombre1, email1);
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				contentPane.setVisible(false);
			}
		});
		btnNewButton.setBounds(153, 227, 142, 23);
		contentPane.add(btnNewButton);
	}

}
