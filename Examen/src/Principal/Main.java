package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Insertar Proyecto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operaciones op = new Operaciones();
				op.anadirProyecto();
			}
		});
		btnNewButton.setBounds(131, 11, 146, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mostrar empleados proyectos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operaciones.mostrarEmpleados();
			}
		});
		btnNewButton_1.setBounds(88, 45, 236, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generar XML");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operaciones.generarXml();
			}
		});
		btnNewButton_2.setBounds(131, 79, 158, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Generar Informe");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operaciones.generarPdf();
			}
		});
		btnNewButton_3.setBounds(131, 113, 158, 23);
		contentPane.add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 179, 414, 82);
		contentPane.add(textArea);
	}
}
