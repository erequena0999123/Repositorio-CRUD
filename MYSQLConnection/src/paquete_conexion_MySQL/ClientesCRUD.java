package paquete_conexion_MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class ClientesCRUD {
	// CONSULTAS REQUERIDAS PARA LAS TABLAS //
	
	// 1. Consultas para clientes
	public static final String SELECT_C = "SELECT * FROM clientes ORDER BY ID_CLIENTE";
	public static final String INSERT_C = "INSERT INTO clientes(NOMBRE, APELLIDO, TELEFONO, EMAIL) VALUES(?, ?, ?, ?)";
	public static final String UPDATE_C = "UPDATE clientes SET NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, EMAIL = ? WHERE ID_CLIENTE = ?";
	public static final String DELETE_C = "DELETE FROM clientes WHERE ID_CLIENTE = ?";
	
	// METODOS PARA LAS TRANSACCIONES //
	Connection con = null;
	PreparedStatement ps;
	ResultSet res;
	
	// SELECCIONAR: FUNCIONANDO //
	public DefaultTableModel Seleccionar() {
		try {
			con = ConexionMySQL.getConnection();
			ps = con.prepareStatement(SELECT_C);
			String [] datos = new String[5];
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_CLIENTE");
			model.addColumn("NOMBRE");
			model.addColumn("APELLIDO");
			model.addColumn("TELEFONO");
			model.addColumn("EMAIL");
			
			res = ps.executeQuery();
			
			while(res.next()) {
				datos[0] = res.getString(1);
				datos[1] = res.getString(2);
				datos[2] = res.getString(3);
				datos[3] = res.getString(4);
				datos[4] = res.getString(5);
				model.addRow(datos);
			}
			con.close();
			return model;
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// INSERTAR: FUNCIONANDO //
	public void Insertar(String nombre, String apellido, String telefono, String email) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(INSERT_C);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, email);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				System.out.println("Registro Ingresado");
			} else {
				System.out.println("Ocurrio un Error, no se guardo el registro");
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// ACTUALIZAR: FUNCIONANDO //
	public void Actualizar(String nombre, String apellido, String telefono, String email, String id_cliente) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(UPDATE_C);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, email);
			ps.setString(5, id_cliente);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				System.out.println("Registro Actualizado");
			} else {
				System.out.println("Ocurrio un Error, no se actualizo el registro");
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// ELIMINAR: FUNCIONANDO //
	public void Eliminar(String id_cliente) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(DELETE_C);
			ps.setString(1, id_cliente);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {	
				System.out.println("Registro Eliminado");
			} else {
				System.out.println("Ocurrio un Error, no se elimino el registro");
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
