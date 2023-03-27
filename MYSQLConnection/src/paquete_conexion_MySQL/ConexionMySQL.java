package paquete_conexion_MySQL;

// LIBRERIAS PARA CONECTAR AL JDBC //
import java.sql.Connection;
import java.sql.DriverManager;

// CLASE PRINCIPAL PARA LA CONEXIÓN //
public class ConexionMySQL {
	// Información de la base de datos
	public static final String URL = "jdbc:mysql://localhost:3306/prueba1_tecninova";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1426";
	
	// Aquí conseguimos la conexión a MySQL
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Conexion a MySQL Exitosa");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}
