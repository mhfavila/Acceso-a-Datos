package Actividades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AD_2_7 {
	
	static final String BD_URL = "jdbc:mysql://localhost/?zeroDateTimeBehavior=convertToNull";
	static final String USER = "root";
	static final String PASS = "rootFavila";
	
	static final String basedatos="ejercicio7";
	static final String host = "localhost";
	static final String port = "3306";
	static final String urlConnection = "jdbc:mysql://"+host+ ":"+port+ "/" +basedatos;
	static final String user = "root";
	static final String pwd = "rootFavila";
	
	static Connection c = null;
	static PreparedStatement ps = null;
	
	static ArrayList<String> DNI ;
	static ArrayList<Integer> id;
	
	public static void main(String[] args) {
		//crearBase(basedatos);
		//conexion();
		//crearTablas();
		//polacionBBDD();
		//consultaB();
		//consultaC();
		consultaD();
	}
	

	private static void consultaD() {
		try {
			c=DriverManager.getConnection(urlConnection, user, pwd);
			ps=c.prepareStatement("select dniCliente from alquiler where fecha BETWEEN '2010/01/16' AND '2016/01/17' ;");
			
			ResultSet rs = ps.executeQuery();
			int i=0;
			
			while(rs.next()) {
				String dni =rs.getString("dniCliente");
				System.out.println("DNI = "+ dni);
				PreparedStatement ps1 = c.prepareStatement("Select * from cliente where dni = "+rs.getString("dniCliente"));
				ResultSet rs2=ps1.executeQuery();
				while(rs2.next()) {
					System.out.println("DNI Cliente: "+rs2.getString("dni"));
					System.out.println("Nombre Cliente: "+rs2.getString("nombre"));
					System.out.println("Apellidos Cliente: "+rs2.getString("apellidos"));
					System.out.println("domicilio Cliente: "+rs2.getString("domicilio"));
					System.out.println("ntarjeta Cliente: "+rs2.getString("nTarjeta"));
					
					
				}
				
				
			}
			
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
	}


	private static void consultaC() {
		try {
			c=DriverManager.getConnection(urlConnection, user, PASS);
			System.out.println("Suponiendo que el dia de hoy es 16 de enero de 2010");
			ps=c.prepareStatement(" select * from alquiler where fecha BETWEEN '2010/01/16' AND '2016/01/17' ;");
			ResultSet rs = ps.executeQuery();
			int i=1;
			System.out.println("Codigo alquiler que no a finalizado: ");
			while(rs.next()) {
				
				System.out.println("--> "+rs.getInt("idAlquiler"));
				
				
				
			}
		} catch (SQLException e) {
		muestraErrorSQL(e);
		}
		
	}


	private static void consultaB() {
		try {
			c=DriverManager.getConnection(urlConnection, user, pwd);
			ps=c.prepareStatement("Select nombre,apellidos from cliente;");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()) {
				System.out.println("Nombre: "+rs.getString("nombre"));
				System.out.println("Apellidos: "+rs.getString("apellidos"));
			}
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
	}


	private static void polacionBBDD() {
		meterDatosCiente();
		meterDatosOficina();
		meterDatosMarca();
		meterDatosVehiculo();
		meterDatosAlquiler();
		
		
		
	}


	

	private static void meterDatosVehiculo() {
		ArrayList<String> tipoCombus = new ArrayList<String>();
		ArrayList<Integer> plazas = new ArrayList<Integer>();
		ArrayList<String> modelo = new ArrayList<String>();
		ArrayList<Integer> id1 = new ArrayList<Integer>();
		tipoCombus.add("Gasolina");
		tipoCombus.add("Diesel");
		tipoCombus.add("Hibrido");
		tipoCombus.add("Electrico");
		plazas.add(4);
		plazas.add(5);
		plazas.add(7);
		
		
		modelo.add("4X4");
		modelo.add("Berlina");
		modelo.add("Deportivo");
		for(int i=0;i<5;i++) {
			id1.add(i);
		}
		
		try {
			c=DriverManager.getConnection(urlConnection, user, pwd);
			ps=c.prepareStatement("insert into vehiculo(idVehiculo,idMarca,modelo,tipoCombustible,plazas) values (?,?,?,?,?);");
			int contador=0;
			int plaza=0;
			int idMa=0;
			String modelo1;
			String tipoCom;
			int n=0;
			for(int i=0;i<20;i++) {
				n=(int) Math.floor(Math.random()*4+1);
				idMa=id1.get(n);
				modelo1=modelo.get( (int) Math.floor(Math.random()*2+1));
				tipoCom=tipoCombus.get( (int) Math.floor(Math.random()*3+1));
				plaza=plazas.get( (int) Math.floor(Math.random()*2+1));
				
				
				ps.setInt(1, i);
				ps.setInt(2, idMa);
				ps.setString(3, modelo1);
				ps.setString(4,tipoCom);
				ps.setInt(5, plaza);
				contador =contador+ps.executeUpdate();
				
				 System.out.println("vehiculo "+i+" creado");
				 
				 
				 
			}
			System.out.println("vehiculo creados "+ contador);
				
			
			
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
	}


	private static void meterDatosMarca() {
		ArrayList<String> marcas =new ArrayList<String>();
		ArrayList<String> pais =new ArrayList<String>();
		id = new ArrayList<Integer>();
		marcas.add("SEAT");
		marcas.add("RENAULT");
		marcas.add("FORD");
		marcas.add("ALFA ROMEO");
		marcas.add("CITROEN");
		
		pais.add("espana");
		pais.add("Francia");
		pais.add("Alemania");
		pais.add("Italia");
		pais.add("Irlanda");
		
		for(int i=0;i<5;i++) {
			id.add(i);
		}
		
		try {
			c=DriverManager.getConnection(urlConnection, user, pwd);
			ps=c.prepareStatement("insert into marca(idMarca,pais,tipoMarca) values (?,?,?);");
			String p;
			String marca;
			int id1 =0;
			int contador=0;
			
			for(int i=0;i<5;i++) {
				p=pais.get(i);
				marca=marcas.get(i);
				id1=id.get(i);
				ps.setInt(1, id1);
				ps.setString(2, p);
				ps.setString(3, marca);
				contador =contador+ps.executeUpdate();
				
				 System.out.println("marca "+i+" creado");
				 
				 
				 
			}
			System.out.println("Marcas creados "+ contador);
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
		
	}


	private static void meterDatosOficina() {
		ArrayList<String> calle = new ArrayList<String>();
		ArrayList<Integer> numero = new ArrayList<Integer>();
		ArrayList<Integer> telefono = new ArrayList<Integer>();
		ArrayList<String> provincia = new ArrayList<String>();
		ArrayList<String> localidad = new ArrayList<String>();
		telefono.add(678934567);
		telefono.add(689934977);
		telefono.add(613434456);
		telefono.add(657890123);
		telefono.add(656565747);
		provincia.add("Soria");
		provincia.add("Murcia");
		provincia.add("Barcelona");
		provincia.add("Santander");
		provincia.add("Madrid");
		
		localidad.add("Arroyo de la Encomienda");
		localidad.add("La vega");
		localidad.add("Pucela");
		localidad.add("Alcorcon");
		localidad.add("Monte mayor");
		calle.add("vazquez");
		calle.add("sanchez");
		calle.add("senoria");
		calle.add("lenguado");
		calle.add("san pablo");
		numero.add(11);
		numero.add(5);
		numero.add(74);
		numero.add(90);
		numero.add(24);
		
		try {
			ps=c.prepareStatement("insert into oficina (codigoOficina,direccion,telefono,localidad,provincia) values (?,?,?,?,?);");
			int codigoOficina =0;
			int telefono1=0;
			String direccion;
			String localidad1;
			String provincia1;
			int contador=0;
			int n1=0;
			int n2=0;
			int n3=0;
			int n4=0;
			
			
			for(int i=0;i<10;i++) {
				
				 n1=(int) Math.floor(Math.random()*4+1);
				 n2=(int) Math.floor(Math.random()*4+1);
				 n3=(int) Math.floor(Math.random()*4+1);
				 n4=(int) Math.floor(Math.random()*4+1);
				 codigoOficina=i;
				 direccion = calle.get(n4)+numero.get(n1);
				 localidad1=localidad.get(n3);
				 provincia1=provincia.get(n2);
				 telefono1= telefono.get(n4);
			
				 
				 ps.setInt(1,codigoOficina);
				 ps.setString(2, direccion);
				 ps.setInt(3, telefono1);
				 ps.setString(4, localidad1);
				 ps.setString(5,provincia1);
				 contador=contador+ ps.executeUpdate();
				 System.out.println("oficina "+i+" creado");
				 
			 
			 
			}
			System.out.println("Oficina creados "+ contador);
			
			
			
		} catch (SQLException e) {
		muestraErrorSQL(e);
		}
		
	}


	private static void meterDatosCiente() {
		ArrayList<String> nombre = new ArrayList<String>();
		ArrayList<String> apellidos = new ArrayList<String>();
		ArrayList<Integer> ndni = new ArrayList<Integer>();
		ArrayList<String> ldni = new ArrayList<String>();
		ArrayList<String> calle = new ArrayList<String>();
		ArrayList<Integer> numero = new ArrayList<Integer>();
		ArrayList<Integer> numeroTarjeta = new ArrayList<Integer>();
		DNI = new ArrayList<String>();
		
		calle.add("Isabela");
		calle.add("maria");
		calle.add("joaquina");
		calle.add("mayor");
		calle.add("zorrilla");
		numero.add(1);
		numero.add(3);
		numero.add(7);
		numero.add(9);
		numero.add(2);
		nombre.add("Favila");
		nombre.add("Javier");
		nombre.add("Ana");
		nombre.add("Julia");
		nombre.add("Pedro");
		apellidos.add("Montero");
		apellidos.add("Pastor");
		apellidos.add("Crespo");
		apellidos.add("Hernandez");
		apellidos.add("guzman");
		ndni.add(71182547);
		ndni.add(56789099);
		ndni.add(89293377);
		ndni.add(56789099);
		ndni.add(72345547);
		ndni.add(89293377);
		ndni.add(75687543);
		ndni.add(45678901);
		ndni.add(75898000);
		ndni.add(45678234);
		
		
		ldni.add("A");
		ldni.add("M");
		ldni.add("N");
		ldni.add("V");
		ldni.add("H");
		ldni.add("F");
		ldni.add("L");
		ldni.add("P");
		ldni.add("X");
		ldni.add("J");
		ldni.add("B");
		
		numeroTarjeta.add(3456);
		numeroTarjeta.add(2345);
		numeroTarjeta.add(1234);
		numeroTarjeta.add(5678);
		numeroTarjeta.add(4678);
		
		
		
		
		
		
		
		try {
			ps=c.prepareStatement("insert into cliente (dni,nombre,apellidos,domicilio,nTarjeta) values (?,?,?,?,?);");
			
			String  nombre1;
			String apellidos1;
			int nPDni=0;
			int lPDni=0;
			int n=0;
			int n1=0;
			int n2=0;
			int n3=0;
			int n4=0;
			int contador=0;
			int numero1=0;
			String letra;
			String letrai;
			String Dni;
			String Dniii;
			String domicilio;
			int tarjeta=0;
			
			for(int i=0;i<11;i++) {
				nPDni=(int) Math.floor(Math.random()*9+1);
				 lPDni=(int) Math.floor(Math.random()*9+1);
				 Dni=ndni.get(nPDni)+ldni.get(i);	
				 DNI.add(Dni);
			}
			
			for(int i=0;i<10;i++) {
			 	 
			 	 
				 n1=(int) Math.floor(Math.random()*4+1);
				 n2=(int) Math.floor(Math.random()*4+1);
				 n3=(int) Math.floor(Math.random()*4+1);
				 n4=(int) Math.floor(Math.random()*4+1);
				 nombre1=nombre.get(n1);
				 apellidos1=apellidos.get(n4);
				
				 Dniii=DNI.get(i);
				 domicilio=calle.get(n4)+numero.get(n1);
				 tarjeta = numeroTarjeta.get(n3);
				 
				 ps.setString(1,Dniii);
				 ps.setString(2, nombre1);
				 ps.setString(3, apellidos1);
				 ps.setString(4, domicilio);
				 ps.setInt(5,tarjeta);
				 contador=contador+ ps.executeUpdate();
				 System.out.println("Cliente "+i+" creado");
				 
			 
			 
			}
			System.out.println("Clientes creados "+ contador);
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
	}
	private static void meterDatosAlquiler() {
		ArrayList<Integer>idVehi=new ArrayList<Integer>();
		
		for(int i=0;i<20;i++) {
			idVehi.add(i);
		}
		
		try {
			c=DriverManager.getConnection(urlConnection, user, pwd);
			ps =c.prepareStatement("insert into alquiler(idAlquiler,fecha,nDias,kmInicio,kmFinal,oficinaInicio,oficinaFinal,idvehiculo,dniCliente) values (?,?,?,?,?,?,?,?,?);");
			int idAlquiler=0;
			int contador=0;
			int numero=0;
			int numero2=0;
			int ano=0;
			int mes=0;
			int dia=0;
			int dni=0;
			String DNII;
			int nDias=0;
			int oInicio=0;
			int oFinal=0;
			int kmInicial=0;
			int kmFinal=0;
			int idVehiculo=0;
			
			for(int i =0;i<200;i++) {
				numero = (int) Math.floor(Math.random() * (7 - 0) + 0);
				numero2 = (int) Math.floor(Math.random() * (10 - 0) + 0);
				ano = (int) Math.floor(Math.random() * (2022 - 1900 + 1) + 0);
				mes = (int) Math.floor(Math.random() * (12 - 1 + 1) + 12);
				dia = (int) Math.floor(Math.random() * (30 - 1 + 1) + 30);
				DNII = DNI.get((int) Math.floor(Math.random() * (10 - 0) + 0));
				nDias = (int) Math.floor(Math.random() * (30 - 1 + 1) + 30);
				idAlquiler=i;
				oInicio= (int) Math.floor(Math.random() * (10 - 0) + 0);
				oFinal= (int) Math.floor(Math.random() * (10 - 0) + 0);
				kmInicial=(int) Math.floor(Math.random() * (2000 - 1900 + 1) + 0);
				kmFinal=(int) Math.floor(Math.random() * (2000 - 1900 + 1) + 0);
				idVehiculo=(int) Math.floor(Math.random() * (20 - 0) + 0);
				Date date = new Date(ano, mes, dia);
				
				ps.setInt(1,idAlquiler );
				ps.setDate(2, date);
				ps.setInt(3, nDias);
				ps.setInt(4, kmInicial);
				ps.setInt(5, kmFinal);
				ps.setInt(6, oInicio);
				ps.setInt(7, oFinal);
				ps.setInt(8, idVehiculo);
				ps.setString(9, DNII);
				contador = contador+ps.executeUpdate();
				System.out.println("alquiler "+i+ " creado");
			}
			System.out.println("alquileres creados "+contador);
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
		
	}



	private static void crearTablas() {
		String sqlCreacionCliente="create table cliente ("
				+ "dni varchar(50) primary key,"
				+ "nombre varchar(50),"
				+ "apellidos varchar(50),"
				+ "domicilio  varchar(50),"
				+ "nTarjeta integer"
				+ ");";
		String sqlCreacionOficina="create table oficina("
				+ "codigoOficina integer primary key,"
				+ "direccion varchar(50),"
				+ "telefono integer,"
				+ "localidad varchar(50),"
				+ "provincia varchar(50)"
				+ ");";
		String sqlCreacionAlquiler="create table alquiler("
				+ "idAlquiler integer primary key,"
				+ "fecha date,"
				+ "nDias integer,"
				+ "kmInicio integer,\r\n"
				+ "kmFinal integer,\r\n"
				+ "oficinaInicio integer,\r\n"
				+ "oficinaFinal  integer,\r\n"
				+ "idVehiculo integer,\r\n"
				+ "dniCliente varchar(50),\r\n"
				+ "foreign key(oficinaInicio) references oficina(codigoOficina),\r\n"
				+ "foreign key(oficinaFinal) references oficina(codigoOficina),\r\n"
				+ "foreign key(dniCliente) references cliente(dni),\r\n"
				+ "foreign key(idVehiculo) references vehiculo(idVehiculo)\r\n"
				+ "\r\n"
				+ ");";
		String sqlCreacionMarca = "create table marca(\r\n"
				+ "idMarca integer primary key,\r\n"
				+ "pais varchar(50),\r\n"
				+ "tipoMarca varchar(50)\r\n"
				+ ");";
		String sqlCreacionVehiculo="create table vehiculo(\r\n"
				+ "idVehiculo integer primary key,\r\n"
				+ "idMarca integer,\r\n"
				+ "modelo varchar(50),\r\n"
				+ "tipoCombustible varchar(50),\r\n"
				+ "plazas integer,\r\n"
				+ "foreign key(idMarca) references marca(idMarca)\r\n"
				+ "\r\n"
				+ ");";
		
		
		try {
			c=DriverManager.getConnection(BD_URL, USER, PASS);
			
			ps =c.prepareStatement("USE "+basedatos);
			ps.execute();
		
			
			
			
			ps=c.prepareStatement(sqlCreacionCliente);
			ps.execute();
			System.out.println("Tabla 1 creada");
			ps=c.prepareStatement(sqlCreacionOficina);
			ps.execute();
			System.out.println("Tabla 2 creada");
			
			ps=c.prepareStatement(sqlCreacionMarca);
			ps.execute();
			System.out.println("Tabla 3 creada");
			
			ps=c.prepareStatement(sqlCreacionVehiculo);
			ps.execute();
			System.out.println("Tabla 4 creada");
			
			ps=c.prepareStatement(sqlCreacionAlquiler);
			ps.execute();
			System.out.println("Tabla 5 creada");
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
		
	}


	private static void conexion() {
		try {
			c = DriverManager.getConnection(urlConnection, user, pwd);
			System.out.println("conectaddo");
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
	}


	private static void muestraErrorSQL(SQLException e) {
		System.out.println("Se a producido un error. El codigo es " + e.getErrorCode());
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		
	}


	private static void crearBase(String nombre) {
		try {
			c = DriverManager.getConnection(BD_URL, USER, PASS);
			ps=c.prepareStatement("CREATE DATABASE "+nombre);
			ps.execute();
			System.out.println("BAse de datos creada");
			ps =c.prepareStatement("use "+nombre);
			ps.execute();
			System.out.println("usando la base de datos ");
		} catch (SQLException e) {
			muestraErrorSQL(e);
		}
		
		
	}

	

}
