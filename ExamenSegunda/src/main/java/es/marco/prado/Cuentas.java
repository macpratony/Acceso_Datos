package es.marco.prado;
// Generated 3 mar. 2021 10:05:04 by Hibernate Tools 5.2.12.Final

/**
 * Cuentas generated by hbm2java
 */
public class Cuentas implements java.io.Serializable {

	private int idCuenta;
	private Clientes clientes;
	private int saldo;

	public Cuentas() {
	}

	public Cuentas(int idCuenta, Clientes clientes, int saldo) {
		this.idCuenta = idCuenta;
		this.clientes = clientes;
		this.saldo = saldo;
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

}