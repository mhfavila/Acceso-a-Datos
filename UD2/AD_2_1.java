package Actividades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author Favila
 *
 */

/*
 * 
 * Utilizando sentencias de tipo UPDATE y DELETE modifica la tabla clientes
 * vista en las diapositivas para que almacene el siguiente contenido:
 * (‘78901234X’,’NADALES’,’44126’) (‘89012345E’,’ROJAS’,null)
 * (‘56789012B’,’SAMPER’,’29730’)
 */
public class AD_2_1 {
	static final String basedatos = "ventas";
	static final String host = "localhost";
	static final String port = "3306";
	static final String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos;
	static final String user = "root";
	static final String pwd = "rootFavila";

	public static void main(String[] args) {
		//creamos una connexion con la base y despues un prepareStatement con la orden
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement ps = c.prepareStatement("INSERT INTO CLIENTES(DNI,APELLIDOS,CP) VALUES(?,?,?);")) {
			//vamos rellenado los campos y despues de cada cliente ejecutamos un update para actualizar la tabla con los valores
			ps.setString(1, "78901234X");
			ps.setString(2, "NADALES");
			ps.setInt(3,44126);
			ps.executeUpdate();
			
			ps.setString(1, "89012345E");
			ps.setString(2, "ROJAS");
			ps.setNull(3,Types.INTEGER);
			ps.executeUpdate();
			
			ps.setString(1, "56789012B");
			ps.setString(2, "SAMPER");
			ps.setInt(3,29730);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
