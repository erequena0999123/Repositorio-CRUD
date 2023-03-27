package paquete_conexion_MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class DireccionesCRUD {
	// CONSULTAS REQUERIDAS PARA LAS TABLAS //
	
	// 2. Consultas para direcciones
	public static final String SELECT_D = "SELECT * FROM direcciones";
	public static final String INSERT_D = "INSERT INTO direcciones(CIUDAD, SECTOR, CALLE, NUM_CASA, REFERENCIA) VALUES(?, ?, ?, ?, ?)";
	public static final String UPDATE_D = "UPDATE direcciones SET CIUDAD = ?, SECTOR = ?, CALLE = ?, NUM_CASA = ?, REFERENCIA = ? WHERE ID_DIRECCIONES = ?";
	public static final String DELETE_D = "DELETE FROM direcciones WHERE ID_DIRECCIONES = ?";
	
	// METODOS PARA LAS TRANSACCIONES //
	Connection con = null;
	PreparedStatement ps;
	ResultSet res;
	
	// SELECCIONAR: FUNCIONANDO //
	public DefaultTableModel Seleccionar() {
		try {
			con = ConexionMySQL.getConnection();
			ps = con.prepareStatement(SELECT_D);
			String [] datos = new String[6];
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_DIRECCIONES");
			model.addColumn("CIUDAD");
			model.addColumn("SECTOR");
			model.addColumn("CALLE");
			model.addColumn("NUMERO DE CASA");
			model.addColumn("REFERENCIA");
			
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
	public void Insertar(String ciudad, String sector, String calle, String numCasa, String referencia) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(INSERT_D);
			ps.setString(1, ciudad);
			ps.setString(2, sector);
			ps.setString(3, calle);
			ps.setString(4, numCasa);
			ps.setString(5, referencia);
			
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
	public void Actualizar(String ciudad, String sector, String calle, String numCasa, String referencia, String id_direccion) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(UPDATE_D);
			ps.setString(1, ciudad);
			ps.setString(2, sector);
			ps.setString(3, calle);
			ps.setString(4, numCasa);
			ps.setString(5, referencia);
			ps.setString(6, id_direccion);
			
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
	public void Eliminar(String id_direccion) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(DELETE_D);
			ps.setString(1, id_direccion);
			
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
