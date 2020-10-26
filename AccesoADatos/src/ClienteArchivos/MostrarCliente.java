package ClienteArchivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class MostrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	RandomAccessFile raf;
	private int nif1;
	private String nombre;
	private String email;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarCliente frame = new MostrarCliente();
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
	public MostrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("INFORMACION DEL CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 11, 290, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIF");
		lblNewLabel_1.setBounds(20, 123, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(20, 192, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setBounds(20, 257, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(139, 192, 151, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setBounds(159, 257, 151, 14);
		contentPane.add(lblEmail);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					raf = new RandomAccessFile("archivo", "r");
					Operaciones op = new Operaciones(raf);
					
					nif1 = Integer.parseInt(textField.getText());
					
					Cliente c = op.mostrarCliente(nif1);
					
					lblNombre.setText(c.getNombre());
					lblEmail.setText(c.getEmail());
					
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(49, 319, 126, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(139, 120, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ACEPTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});
		btnNewButton_1.setBounds(224, 319, 126, 23);
		contentPane.add(btnNewButton_1);
	}
}
