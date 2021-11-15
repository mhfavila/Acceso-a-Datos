package Actividades;
/**
 * 
 * @author Favila
 *
 */
/* Escribe un programa que calcule el n�mero de filas obtenidas en una consulta sin necesidad de 
recorrer todo el contenido del ResultSet obtenido*/
public class AD_2_5 {

	public static void muestraErrorSQL(SQLException e){
        System.err.println("SQL ERROR mensaje: "+e.getMessage());
        System.err.println("SQL Estado: "+e.getSQLState());
        System.err.println("SQL codigo especifico: "+e.getErrorCode());
    }
       public static void main(String[] args){
        String basedatos  = "ventas";
        String host = "localhost";
        String port = "3306";
        String info = "";
        String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos + info;
        String user = "root";
        String pwd = "root";
        
        try(
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES ")){
            rs.last();
            System.out.println("se van a ver "+rs.getRow()+" lineas");
            
            rs.first();
            int i = 1;
            while(rs.next()){
                if(i==1){
                    rs.first();
                }
                System.out.println("[" +(i++) +"]");
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
                System.out.println("CP: "+rs.getString("CP"));
            }
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }

}
