package Actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Favila
 *
 */
/*
 *  Sobre la tabla clientes vista en las diapositivas elabora un programa en Java que permita imprimir los 
clientes de cada uno de los códigos postales*/
public class AD_2_2 {
	static final String basedatos = "ventas";
	static final String host = "localhost";
	static final String port = "3306";
	static final String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos;
	static final String user = "root";
	static final String pwd = "rootFavila";
	
	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(urlConnection,user,pwd);
				PreparedStatement s = c.prepareStatement("SELECT * FROM CLIENTES WHERE CP");
				ResultSet rs =s.executeQuery()
				
				){
			int i=1;
			while(rs.next()) {
				System.out.println("["+(i++)+"]");
				System.out.println("DNI: "+rs.getString("DNI"));
				System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
				System.out.println("CP: "+rs.getString("CP"));
			}
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		

	}

}
