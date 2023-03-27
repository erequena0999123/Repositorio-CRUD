package paquete_conexion_MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class ServiciosCRUD {
	// CONSULTAS REQUERIDAS PARA LAS TABLAS //
	
	// 4. Consultas para servicios
	public static final String SELECT_S = "SELECT * FROM servicios ORDER BY ID_SERVICIO";
	public static final String INSERT_S = "INSERT INTO servicios(FECHA_VISITA, SERVICIO_REALIZADO, REPUESTO, MESES_GARANTIA, G_F) VALUES(?, ?, ?, ?, ?)";
	public static final String UPDATE_S = "UPDATE servicios FECHA_VISITA = ?, SERVICIO_REALIZADO = ?, REPUESTO = ?, MESES_GARANTIA = ?, G_F = ? WHERE ID_SERVICIO = ?";
	public static final String DELETE_S = "DELETE FROM servicios WHERE ID_SERVICIO = ?";
	
	// METODOS PARA LAS TRANSACCIONES //
	Connection con = null;
	PreparedStatement ps;
	ResultSet res;
	
	// SELECCIONAR: FUNCIONANDO //
	public DefaultTableModel Seleccionar() {
		try {
			con = ConexionMySQL.getConnection();
			ps = con.prepareStatement(SELECT_S);
			String [] datos = new String[8];
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SERVICIO");
			model.addColumn("ID_PRODUCTO");
			model.addColumn("ID_CLIENTE");
			model.addColumn("ÚLTIMA VISITA");
			model.addColumn("SERVICIO REALIZADO");
			model.addColumn("REPUESTO");
			model.addColumn("MESES DE GARANTÍA");
			model.addColumn("G / F");
			
			res = ps.executeQuery();
			
			while(res.next()) {
				datos[0] = res.getString(1);
				datos[1] = res.getString(2);
				datos[2] = res.getString(3);
				datos[3] = res.getString(4);
				datos[4] = res.getString(5);
				datos[5] = res.getString(6);
				datos[6] = res.getString(7);
				datos[7] = res.getString(8);
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
	public void Insertar(String fecha_visita, String servicio_realizado, String repuesto, String meses_garantia, String g_f) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(INSERT_S);
			ps.setString(1, fecha_visita);
			ps.setString(2, servicio_realizado);
			ps.setString(3, repuesto);
			ps.setString(4, meses_garantia);
			ps.setString(5, g_f);
			
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
	public void Actualizar(String fecha_visita, String servicio_realizado, String repuesto, String meses_garantia, String g_f, String id_servicio) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(UPDATE_S);
			ps.setString(1, fecha_visita);
			ps.setString(2, servicio_realizado);
			ps.setString(3, repuesto);
			ps.setString(4, meses_garantia);
			ps.setString(5, g_f);
			ps.setString(6, id_servicio);
			
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
	public void Eliminar(String id_servicio) {
		try {
			con = ConexionMySQL.getConnection();
			
			ps = con.prepareStatement(DELETE_S);
			ps.setString(1, id_servicio);
			
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
