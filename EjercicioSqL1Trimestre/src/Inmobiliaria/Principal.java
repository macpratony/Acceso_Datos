package Inmobiliaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Insertar Empleado");
		btnNewButton.setBounds(43, 11, 156, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Insertar Piso");
		btnNewButton_1.setBounds(239, 11, 173, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar Mensualidad Piso");
		btnNewButton_2.setBounds(97, 72, 264, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cambiar Empleado / Piso");
		btnNewButton_3.setBounds(97, 113, 264, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Alquilar piso");
		btnNewButton_4.setBounds(97, 147, 264, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Mostrar Nombre  Empleado que lleva el piso");
		btnNewButton_5.setBounds(90, 181, 289, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Sueldo de Empleado");
		btnNewButton_6.setBounds(97, 227, 264, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Empleado con mas piso Aqluilados");
		btnNewButton_7.setBounds(97, 272, 264, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Generar Informe");
		btnNewButton_8.setBounds(97, 306, 264, 23);
		contentPane.add(btnNewButton_8);
	}
}
