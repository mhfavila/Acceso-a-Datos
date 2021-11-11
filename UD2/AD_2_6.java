package Actividades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * 
 * @author Favila
 *
 */
public class AD_2_6 {
	static final String BD_URL = "jdbc:mysql://localhost/?zeroDateTimeBehavior=convertToNull";
	static final String USER = "root";
	static final String PASS = "rootFavila";

	static final String basedatos = "ejercicio6";
	static final String host = "localhost";
	static final String port = "3306";
	static final String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos;
	static final String user = "root";
	static final String pwd = "rootFavila";

	static Connection c = null;
	static Statement s = null;

	public static void main(String[] args) {
		/* crearBase(); */// Desomentar una vez acabado el ejercicio
		crearBase();
		crearTablas();
		meterDatosCliente();
		// meterDatosVentas();
		meterDatosVentas2();
		meterDatosOficina();
		meterEmpleados();

	}

	private static void meterEmpleados() {
		try(Connection c = DriverManager.getConnection(urlConnection,user,pwd);
				PreparedStatement sInsert = c.prepareStatement("INSERT INTO empleado(idE,nombre,apellidos,antiguedad,idOficina) VALUES(?,?,?,?);") ){
			int ano = 0;
			int mes =0;
			int dia =0;
			
			for(int i=0;i<15;i++) {
				i=i+1;
				ano=(int) Math.floor(Math.random()*(2000-1900+1)+1900);
				mes = (int) Math.floor(Math.random()*(30-1+1)+30);
				dia = 
				Date date=new Date(ano,mes,dia);
			sInsert.setInt(1, i);
			sInsert.setString(2, "algo");
			sInsert.setString(3, "algo");
			//'1995-01-29'
			
			sInsert.setDate(4, date);
			sInsert.setInt(5,10);
			sInsert.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
	}

	private static void meterDatosOficina() {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c
						.prepareStatement("INSERT INTO oficina(idO,calle,localidad,provincia) VALUES(?,?,?,?);")) {
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private static void meterDatosVentas2() {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c
						.prepareStatement("INSERT INTO ventas(idV,concepto,idVendedor,idCliente) VALUES(?,?,?,?);")) {
			int idVndedor = 0;
			int idCliente = 0;
			for (int i = 0; i < 30; i++) {
				i = i + 1;
				idVndedor = (int) (Math.random() * 16 + 1);
				idCliente = (int) (Math.random() * 11 + 1);
				sInsert.setInt(1, i);
				sInsert.setString(2, "algo");
				sInsert.setInt(3, idVndedor);
				sInsert.setInt(4, idCliente);
				sInsert.executeUpdate();

				System.out.println("Venta " + i + " añadida");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private static void meterDatosVentas() {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c
						.prepareStatement("INSERT INTO ventas(idV,concepto,idVendedor,idCliente) VALUES(?,?,?,?);")) {

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 2);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 3);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();
			sInsert.setInt(1, 1);
			sInsert.setString(2, "algo");
			sInsert.setInt(3, 15);
			sInsert.setInt(4, 10);
			sInsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private static void meterDatosCliente() {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c
						.prepareStatement("INSERT INTO CLIENTES2(idC,nombre,apellidos,telefono) VALUES(?,?,?,?);")) {

			sInsert.setString(1, "1");
			sInsert.setString(2, "jose");
			sInsert.setString(3, "merlin");
			sInsert.setInt(4, 456555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "2");
			sInsert.setString(2, "david");
			sInsert.setString(3, "ferrer");
			sInsert.setInt(4, 44126555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "3");
			sInsert.setString(2, "ABDO");
			sInsert.setString(3, "FRANCIS");
			sInsert.setInt(4, 44126555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "4");
			sInsert.setString(2, "JUAN MIGUEL");
			sInsert.setString(3, "HERNÁNDEZ");
			sInsert.setInt(4, 44126555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "5");
			sInsert.setString(2, "ÁLVARO");
			sInsert.setString(3, "TORRES");
			sInsert.setInt(4, 44126555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "6");
			sInsert.setString(2, "ANTONIO");
			sInsert.setString(3, "nada");
			sInsert.setInt(4, 44126555);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "7");
			sInsert.setString(2, "JUAN");
			sInsert.setString(3, "x");
			sInsert.setInt(4, 983407279);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "8");
			sInsert.setString(2, "ana");
			sInsert.setString(3, "gomez");
			sInsert.setInt(4, 727325515);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "9");
			sInsert.setString(2, "lucia");
			sInsert.setString(3, "presa");
			sInsert.setInt(4, 797325515);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

			sInsert.setString(1, "10");
			sInsert.setString(2, "ancar");
			sInsert.setString(3, "rot");
			sInsert.setInt(4, 698525515);
			sInsert.executeUpdate();
			System.out.println("Cliente añadido");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private static void crearTablas() {
		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);

			s = c.createStatement();
			System.out.println("Conexion realizada");

			s.execute("CREATE TABLE CLIENTES2 (idC INTEGER NOT NULL,"
					+ "NOMBRE VARCHAR(50) NOT NULL ,APELLIDOS VARCHAR(50) NOT NULL, TELEFONO INTEGER,"
					+ "PRIMARY KEY(idC));");
			System.out.println("TABLA CLIENTES CREADA");

			s.execute("CREATE TABLE OFICINA(idO INTEGER NOT NULL,"
					+ "CALLE VARCHAR(50) NOT NULL, LOCALIDAD VARCHAR(50) NOT NULL, PROVINCIA VARCHAR(50) NOT NULL,"
					+ "PRIMARY KEY(idO));");
			System.out.println("TABLA OFICINA CREADA");

			s.execute("CREATE TABLE EMPLEADOS(idE INTEGER NOT NULL,"
					+ "NOMBRE VARCHAR(50) NOT NULL,APELLIDOS VARCHAR(50) NOT NULL,Antiguedad DATE,idOficina INTEGER ,"
					+ " PRIMARY KEY(idE), FOREIGN KEY(idOficina) REFERENCES OFICINA(idO));");
			System.out.println("TABLAEMPLEADOS CREADA");

			s.execute("CREATE TABLE VENTAS(idV INTEGER NOT NULL,"
					+ "concepto VARCHAR(50) NOT NULL,idVendedor INTEGER NOT NULL,idCliente INTEGER NOT NULL,"
					+ "PRIMARY KEY(idV), FOREIGN KEY(idVendedor) REFERENCES EMPLEADOS(idE),   FOREIGN KEY(idCliente) REFERENCES CLIENTES2(idC));");
			System.out.println("TABLA VENTAS CREADA");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL mensaje: " + e.getMessage());
			System.out.println("SQL Estado: " + e.getSQLState());
			System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}

	}

	private static void crearBase() {
		try {
			c = DriverManager.getConnection(BD_URL, USER, PASS);
			s = c.createStatement();
			String sql = "CREATE DATABASE ejercicio6";
			s.execute(sql);
			System.out.println("BASE DE DATOS CREADA");
			String sql1 = "use ejercicio6";
			s.execute(sql1);
			System.out.println("BASE DE en uso ");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
