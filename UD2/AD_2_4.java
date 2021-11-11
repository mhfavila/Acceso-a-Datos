package Actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Favila
 *
 */
/*
 * Escribe un programa en Java que permita obtener todos los datos de una
 * determinada tabla y después los obtenga en orden inverso. Debe hacer uso de
 * objetos ResultSet scrollable.
 */
public class AD_2_4 {
	static final String basedatos = "ventas";
	static final String host = "localhost";
	static final String port = "3306";
	static final String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos;
	static final String user = "root";
	static final String pwd = "rootFavila";

	public static void main(String[] args) {

		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
			try (Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

				ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES ORDER BY CP DESC");
				c.setAutoCommit(false);
				
				int i=1;
				while(rs.next()) {
					System.out.println("["+(i++)+"]");
					System.out.println("DNI: "+rs.getString("DNI"));
					System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
					System.out.println("CP: "+rs.getString("CP"));
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
