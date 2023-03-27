package paquete_conexion_Postgresql;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion_Postgresql {
	Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/Tecninova";
	String usuario = "postgres";
	String clave = "28138123";

	public Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, clave);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al conectar: " +e, "Error", JOptionPane.ERROR_MESSAGE);

		}
		return con;
	}

}
