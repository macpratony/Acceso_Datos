package Gestiones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GestionCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCliente frame = new GestionCliente();
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
	public GestionCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DE CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(185, 11, 240, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder;
				try {
					
					builder = dbf.newDocumentBuilder();
					Document documento = builder.parse(new File("pedidos.xml"));
					
					Node nodo = documento.getFirstChild();
					
					
						InsertarPedido.insertaPedido(nodo,documento);
						
						
						
					} catch (TransformerFactoryConfigurationError e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					} catch (SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(39, 58, 177, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ELIMINAR PEDIDO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();					
				
					Document documento = builder.parse(new File("pedidos.xml"));
						Node nodo = documento.getFirstChild();
						
						EliminarPedido.eliminaPedido(documento);
						
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(310, 58, 177, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MOSTRAR PEDIDOS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				
					Document documento = builder.parse(new File("pedidos.xml"));
					
					Node nodo = documento.getFirstChild();
					
					MostrarPedido.mostrarPedido(nodo);
					
					
				} catch (SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(39, 139, 177, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("NOMBRE CLIENTE + PEDIDOS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
					
					Document documento = builder.parse(new File("pedidos.xml"));
					
					Node nodo = documento.getFirstChild();
					
					DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder1 = factory1.newDocumentBuilder();
						
						Document documento1 = builder1.parse(new File("clientes.xml"));
						
						Node nodo1 = documento1.getFirstChild();
				
					
					MostrarNombreMasPedido.clienteConMasPedidos(nodo,nodo1);
					
					
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setBounds(310, 139, 177, 39);
		contentPane.add(btnNewButton_3);
	}
}
