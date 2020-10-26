package ClienteArchivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.awt.event.ActionEvent;

public class EliminarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNif;
	RandomAccessFile raf;
	private int nif1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarCliente frame = new EliminarCliente();
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
	public EliminarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELIMINAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(103, 11, 216, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INTRODUZCA EL NIF DEL CLIENTE A ELININAR");
		lblNewLabel_1.setBounds(38, 66, 303, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NIF");
		lblNewLabel_2.setBounds(29, 103, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		textNif = new JTextField();
		textNif.setBounds(141, 100, 96, 20);
		contentPane.add(textNif);
		textNif.setColumns(10);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					raf = new RandomAccessFile("archivo", "r");
					Operaciones op = new Operaciones(raf);
					
					nif1 = Integer.parseInt(textNif.getText());
					op.eliminar(nif1);
					
					
					
					
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(135, 180, 125, 23);
		contentPane.add(btnNewButton);
	}

}
