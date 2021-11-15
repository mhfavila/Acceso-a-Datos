package Actividades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

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
		/*
		 * crearBase(); crearTablas(); meterDatosCliente();
		 * 
		 * 
		 * meterDatosOficina(); meterEmpleados(); meterDatosVentas2();
		 */
		// informacionOficinasEmpresa();
		// numeroTotalVentas();
		// consulta4();
		// consulta5();
		//consulta6();
		//consulta7();
		//consulta8();
		consulta9();
		//consulta10();
		
		
	}
	
	
	
	private static void consulta8(){
        try{
        	c= DriverManager.getConnection(urlConnection, user, pwd);
			Statement s = c.createStatement();
           ResultSet rs = s.executeQuery(" SELECT c.idC,c.nombre,c.apellidos,c.telefono,COUNT(v.idCliente)as compras FROM Clientes c" +
                                           " INNER JOIN Ventas v ONv.idCliente = c.idC GROUP BY c.idC ORDER BY compras DESC;");

           int i = 1;
           while(rs.next()){
               System.out.println("[" +(i++) +"]");
               System.out.println("Nombre: "+rs.getString("nombre"));
               System.out.println("Apellido: "+rs.getString("apellidos"));
               System.out.println("Telefono: "+rs.getString("telefono"));
               System.out.println("Compras: "+rs.getString("compras"));
           }
          s.close();
        }catch(SQLException e){
           
       }catch(Exception e){
           e.printStackTrace(System.err);
       }
   }
   private static void consulta9(){
        try{
        	c= DriverManager.getConnection(urlConnection, user, pwd);
			Statement s = c.createStatement();
           PreparedStatement ps = c.prepareStatement("SELECT o.calle,o.localidad,o.provincia FROM Oficina o WHERE localidad=?;");
           String localidad = "Palencia";
           ps.setString(1, localidad);
           ResultSet rs=ps.executeQuery();
           int i = 1;
           while(rs.next()){
               System.out.println("[" +(i++) +"]");
               System.out.println("Calle: "+rs.getString("calle"));
               System.out.println("Localidad: "+rs.getString("localidad"));
               System.out.println("Provincia: "+rs.getString("provincia"));
           }
          s.close();
        }catch(SQLException e){
           
       }catch(Exception e){
           e.printStackTrace(System.err);
       }
   }
   private static void consulta10(){
        try {
        	c= DriverManager.getConnection(urlConnection, user, pwd);
			Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT idE FROM Empleados e");

           //int i = 1;
           while(rs.next()){
               PreparedStatement ps = c.prepareStatement("SELECT * FROM Empleados e WHERE e.idE = ?;");
               ps.setInt(1, rs.getInt("idE"));
               ResultSet rs1=ps.executeQuery();
               int i = 1;
               while(rs1.next()){
                   System.out.println("[" +(i++) +"]");
                   System.out.println("idEmpleado: "+rs1.getString("idE"));
                   System.out.println("nombre: "+rs1.getString("nombre"));
                   System.out.println("apellidos: "+rs1.getString("apellidos"));
                   System.out.println("antiguedad: "+rs1.getString("antiguedad"));
                   System.out.println("idOficina: "+rs1.getString("idOficina"));
               }
           }
          s.close();
        }catch(SQLException e){
           
       }catch(Exception e){
           e.printStackTrace(System.err);
       }
   }



	private static void consulta7() {
		
		try{
			c= DriverManager.getConnection(urlConnection, user, pwd);
			Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT e.idE,e.nombre,e.apellidos FROM Empleados e" );

            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("IdVendedor: "+rs.getInt("idE"));
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Apellido: "+rs.getString("apellidos"));

                ResultSet rs1 = s.executeQuery("SELECT idV,concepto FROM Ventas v WHERE idVendedor="+rs.getInt("idE"));
                while(rs1.next()){
                    System.out.println("[" +(i++) +"]");
                    System.out.println("IdVenta: "+rs.getInt("idV"));
                    System.out.println("Concepto: "+rs.getString("concepto"));
                }
            }
           s.close();
         }catch(SQLException e){
           
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }

    
		
	

	private static void consulta6() {
		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);
			PreparedStatement s = c.prepareStatement(
					"select e.nombre,e.apellidos,COUNT(v.idVendedor) as ventas FROM empleados e inner join ventas v on v.idVendedor = e.idE group by e.idE order by ventas DESC;");

			ResultSet rs = s.executeQuery();
			int i = 1;
			while (rs.next()) {

				System.out.println("[OFICINA: " + (i++) + "]");
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Apellido: " + rs.getString("apellidos"));

				System.out.println("N de ventas: " + rs.getString("ventas"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static void consulta5() {
		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);
			PreparedStatement s = c.prepareStatement(
					"select o.idO,o.calle,o.localidad,o.provincia,COUNT(e.idE)as ventas From oficina o Inner Join empleados e ON o.idO = e.idOficina Inner join  ventas v on v.idVendedor Group by o.idO;");

			ResultSet rs = s.executeQuery();
			int i = 1;
			while (rs.next()) {

				System.out.println("[OFICINA: " + (i++) + "]");
				System.out.println("Id: " + rs.getString("idO"));
				System.out.println("Calle: " + rs.getString("calle"));
				System.out.println("Localidad: " + rs.getString("Localidad"));
				System.out.println("Provincia: " + rs.getString("provincia"));
				System.out.println("N de ventas: " + rs.getString("ventas"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static void consulta4() {
		// select o.idO,o.calle,o.localidad,o.provincia,COUNT(e.idE)as num From oficina
		// o Inner Join empleados e ON o.idO = e.idOficina Group by o.idO

		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);
			PreparedStatement s = c.prepareStatement(
					"select o.idO,o.calle,o.localidad,o.provincia,COUNT(e.idE)as num From oficina o Inner Join empleados e ON o.idO = e.idOficina Group by o.idO;");
			ResultSet rs = s.executeQuery();
			int i = 1;
			while (rs.next()) {

				System.out.println("[OFICINA: " + (i++) + "]");
				System.out.println("Id: " + rs.getString("idO"));
				System.out.println("Calle: " + rs.getString("calle"));
				System.out.println("Localidad: " + rs.getString("Localidad"));
				System.out.println("Provincia: " + rs.getString("provincia"));
				System.out.println("N de empleados: " + rs.getString("num"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void numeroTotalVentas() {
		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);
			PreparedStatement s = c.prepareStatement("select count(*) from ventas");
			ResultSet rs = s.executeQuery();
			int i = 1;
			while (rs.next()) {

				System.out.println("El nuemero total de ventas es : " + rs.getString(1));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void informacionOficinasEmpresa() {

		try {
			Connection c = DriverManager.getConnection(urlConnection, user, pwd);

			PreparedStatement s = c.prepareStatement("Select * from oficina");
			ResultSet rs = s.executeQuery();
			int i = 1;
			while (rs.next()) {
				System.out.println("[OFICINA: " + (i++) + "]");
				System.out.println("Id: " + rs.getString("idO"));
				System.out.println("Calle: " + rs.getString("calle"));
				System.out.println("Localidad: " + rs.getString("Localidad"));
				System.out.println("Provincia: " + rs.getString("provincia"));

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void meterEmpleados() {
		ArrayList<String> listaNombre = new ArrayList<String>();
		listaNombre.add("pedro");
		listaNombre.add("marcos");
		listaNombre.add("juan");
		listaNombre.add("raul");
		listaNombre.add("favila");
		listaNombre.add("ramon");
		listaNombre.add("julia");
		ArrayList<String> listaApellido = new ArrayList<String>();
		listaApellido.add("montero");
		listaApellido.add("herredia");
		listaApellido.add("stuani");
		listaApellido.add("ramirez");
		listaApellido.add("jimenez");
		listaApellido.add("fuente");
		listaApellido.add("crespo");
		listaApellido.add("escan");
		listaApellido.add("hidra");
		listaApellido.add("suat");
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c.prepareStatement(
						"INSERT INTO empleados(idE,nombre,apellidos,antiguedad,idOficina) VALUES(?,?,?,?,?);")) {
			int ano = 0;
			int mes = 0;
			int dia = 0;
			int ofi = 0;
			String nombre;
			String apellido;
			int numero = 0;
			int numero2 = 0;
			for (int i = 1; i < 16; i++) {
				numero = (int) Math.floor(Math.random() * (7 - 0) + 0);
				numero2 = (int) Math.floor(Math.random() * (10 - 0) + 0);
				ano = (int) Math.floor(Math.random() * (2000 - 1900 + 1) + 1900);
				mes = (int) Math.floor(Math.random() * (12 - 1 + 1) + 12);
				dia = (int) Math.floor(Math.random() * (30 - 1 + 1) + 30);
				;
				Date date = new Date(ano, mes, dia);
				ofi = (int) (Math.random() * 5 + 1);
				System.out.println("idOficina generado = " + ofi);
				nombre = listaNombre.get(numero);
				apellido = listaApellido.get(numero2);
				sInsert.setInt(1, i);
				sInsert.setString(2, nombre);
				sInsert.setString(3, apellido);
				sInsert.setDate(4, date);
				sInsert.setInt(5, ofi);
				sInsert.executeUpdate();

				System.out.println("empleado " + i + "creado");
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
			for (int i = 1; i < 6; i++) {

				sInsert.setInt(1, i);
				sInsert.setString(2, "algo");
				sInsert.setString(3, "algo");
				sInsert.setString(4, "algo");
				sInsert.executeUpdate();
				System.out.println("Ofcina " + i + "creada");
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

	private static void meterDatosVentas2() {

		ArrayList<String> listaConcepto = new ArrayList<String>();
		listaConcepto.add("compra");
		listaConcepto.add("venta");
		listaConcepto.add("regalo");
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement sInsert = c

						.prepareStatement("INSERT INTO ventas(idV,concepto,idVendedor,idCliente) VALUES(?,?,?,?);")) {

			int idVndedor = 0;
			int idCliente = 0;
			int numero = 0;
			for (int i = 1; i < 30; i++) {

				idVndedor = (int) (Math.random() * 15 + 1);
				idCliente = (int) (Math.random() * 10 + 1);
				numero = (int) Math.floor(Math.random() * (3 - 0) + 0);
				String concepto = listaConcepto.get(numero);
				sInsert.setInt(1, i);
				sInsert.setString(2, concepto);
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
