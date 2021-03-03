package es.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.marco.hibernate.Empresa;
import es.marco.hibernate.Reserva;
import es.marco.hibernate.ReservaId;
import es.marco.hibernate.Sala;


public class Principal {

	public static void main(String[] args) {
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
				@SuppressWarnings("unused")
			    Logger logger = Logger.getLogger("org.hibernate");
			    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need

			    BufferedReader mac = new BufferedReader (new InputStreamReader(System.in));
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				
				Session sesion = sessionFactory.openSession();
				
				Transaction tx = sesion.beginTransaction(); //Permite ejecutar todo un bloque en conjunto
				
				System.out.println("Elija una de las siguientes opciones");
				System.out.println("1.- Dar de alta salas");
				System.out.println("2.- Dar de alta empresas");
				System.out.println("3.- Dar de alta una reserva");
				System.out.println("4.- Eliminar Todas las reservas de una sala dado su nombre");
				System.out.println("5.- Mostrar el nombre de la empresa que mas ha gastado en alquileres de sala");
				
				try {
					int numero = Integer.parseInt(mac.readLine());
					
					switch (numero) {
					case 1:
						Sala sala = new Sala();
						
						System.out.println("Ingrese el codigo de la sala");
						String codigoSala = mac.readLine();
						
						System.out.println("Ingrese la descripcion de la sala");
						String descripcion = mac.readLine();
						
						System.out.println("Ingrese el precio de la sala");
						double precioSala = Double.parseDouble(mac.readLine());
						
						
						sala.setCodSala(codigoSala);
						sala.setDescripcion(descripcion);
						sala.setPrecio(precioSala);
						
						sesion.save(sala);
						tx.commit();
						sesion.close();
						
						break;
						
					case 2:
						
						Empresa empresa = new Empresa();
						
						System.out.println("Ingrese el codigo de la empresa");
						String codigoEmpresa = mac.readLine();
						
						System.out.println("Ingrese el nombre de ala empresa");
						String nombreEmpresa = mac.readLine();
						
						empresa.setCodEmpresa(codigoEmpresa);
						empresa.setNombre(nombreEmpresa);
						
						sesion.save(empresa);
						tx.commit();
						sesion.close();
						
						break;
						
					case 3:
						
						System.out.println("Ingrese el nombre de la sala");
						String nombreSala = mac.readLine();
						
						Query query = sesion.createQuery("FROM Sala WHERE descripcion = :descripcion");
						query.setParameter("descripcion", nombreSala);
						
						Sala s = (Sala) query.getSingleResult();
						
						System.out.println("Ingrese el nombre de la empresa");
						String nombreE = mac.readLine();
						
						Query sentencia = sesion.createQuery("FROM Empresa WHERE nombre = :nombre");
						sentencia.setParameter("nombre", nombreE);
						
						Empresa e = (Empresa)sentencia.getSingleResult();
						
						System.out.println("Ingrese el nombre de la actividad");
						String nombreActividad = mac.readLine();
						
						Reserva reserva = new Reserva();
						reserva.setEmpresa(e);
						reserva.setSala(s);
						reserva.setNomActividad(nombreActividad);
						
							ReservaId rId = new ReservaId();
							System.out.println("Ingrese el dia del mes");
							int diaMes = Integer.parseInt(mac.readLine());
							rId.setCodSala(s.getCodSala());
							rId.setDiaMes(diaMes);
							
						reserva.setId(rId);
						
						sesion.save(reserva);
						tx.commit();
						sesion.close();

						
						break;
						
					case 4:
						
						System.out.println("Ingrese el nombre de la sala");
						String nombreSala1 = mac.readLine();
						
						Query sentencia1 = sesion.createQuery("FROM Sala WHERE descripcion = :descripcion ");
						sentencia1.setParameter("descripcion", nombreSala1);
						
						Sala sala1 = (Sala)sentencia1.getSingleResult();
						
						Query sentencia2 = sesion.createQuery("FROM Reserva WHERE id.codSala = :codSala");
						sentencia2.setParameter("codSala", sala1.getCodSala());
						
						Reserva re = (Reserva)sentencia2.getSingleResult();
						
						sesion.remove(re);
						tx.commit();
						sesion.close();
						
						
						break;
						
					case 5:
						
						int suma = 0;
						int sumaAux = 0;
						String codEmpresa = "";
						
						Query sentencia3 = sesion.createQuery("FROM Reserva");
						List<Reserva> res = sentencia3.getResultList();
						Set<String> st = new HashSet<String>();
						
						for (Reserva r : res) {
							st.add(r.getEmpresa().getCodEmpresa());
						}
						
						for (String string : st) {
							for (Reserva r : res) {
								if(string == r.getEmpresa().getCodEmpresa()) {
									suma += r.getSala().getPrecio();
								}
							}
							if(suma > sumaAux) {
								sumaAux = suma;
								codEmpresa = string;
								suma = 0;
							}
								
							
						}
						
						Query sentencia4 = sesion.createQuery("FROM Empresa WHERE codEmpresa = :codEmpresa");
						sentencia4.setParameter("codEmpresa", codEmpresa);
						
						Empresa em = (Empresa) sentencia4.getSingleResult();
						
						System.out.println("La empresa que mas a gastado en reservas es:  "+em.getNombre());
						
						break;

					default:
						break;
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
