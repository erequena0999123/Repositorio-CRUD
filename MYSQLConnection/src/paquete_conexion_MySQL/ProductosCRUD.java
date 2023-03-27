package paquete_conexion_MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class ProductosCRUD {
	// CONSULTAS REQUERIDAS PARA LAS TABLAS //
	
	// 3. Consultas para productos
	public static final String SELECT_P = "SELECT * FROM productos ORDER BY ID_PRODUCTO";
	public static final String INSERT_P = "INSERT INTO productos(PRODUCTO, MARCA, MODELO, TIPO) VALUES(?, ?, ?, ?)";
	public static final String UPDATE_P = "UPDATE productos SET PRODUCTO = ?, MARCA = ?, MODELO = ?, TIPO = ? WHERE ID_PRODUCTO = ?";
	public static final String DELETE_P = "DELETE FROM productos WHERE ID_PRODUCTO = ?";
	
	// METODOS PARA LAS TRANSACCIONES //
	Connection con = null;
	PreparedStatement ps;
	ResultSet res;
	
	// SELECCIONAR: FUNCIONANDO //
	public DefaultTableModel Seleccionar() {
		try {
			con = ConexionMySQL.getConnection();
			ps = con.prepareStatement(SELECT_P);
			String [] datos = new String[6];
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_PRODUCTO");
			model.addColumn("ID_CLIENTE");
			model.addColumn("PRODUCTO");
			model.addColumn("MARCA");
			model.addColumn("MODELO");
			model.addColumn("TIPO");
			
			res = ps.executeQuery();
			
			while(res.next()) {
				datos[0] = res.getString(1);
				datos[1] = res.getString(2);
				datos[2] = res.getString(3);
				datos[3] = res.getString(4);
				datos[4] = res.getString(5);
				datos[5] = res.getString(6);
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
	public void Insertar(String producto, String marca, String modelo, String tipo) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(INSERT_P);
			ps.setString(1, producto);
			ps.setString(2, marca);
			ps.setString(3, modelo);
			ps.setString(4, tipo);
			
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
	public void Actualizar(String producto, String marca, String modelo, String tipo, String id_producto) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(UPDATE_P);
			ps.setString(1, producto);
			ps.setString(2, marca);
			ps.setString(3, modelo);
			ps.setString(4, tipo);
			ps.setString(5, id_producto);
			
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
	public void Eliminar(String id_producto) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(DELETE_P);
			ps.setString(1, id_producto);
			
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
