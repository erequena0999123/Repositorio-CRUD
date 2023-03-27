package paquete_conexion_Postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import getset.Variables;

public class CRUD_Postgresql extends Conexion_Postgresql {
	java.sql.Statement st;
	ResultSet rs;
	Variables var = new Variables();

	public void insertarCliente(String nombre, String apellido, String telefono, String email) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();

			String sql = "insert into clientes(nombre, apellido, telefono, email) values('" + nombre + "','" + apellido
					+ "','" + telefono + "','" + email + "');";
			st.execute(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El registro no se guardo "+e, "Mensaje", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void insertarDireccion(String ciudad, String sector, String calle, String num_casa, String referencia) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();

			String sql = "insert into direcciones(ciudad,sector,calle,num_casa,referencia) values('" + ciudad + "','"
					+ sector + "','" + calle + "','" + num_casa + "', '" + referencia + "');";
			st.execute(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El registro no se guardo", "Mensaje", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void insertarProducto(String producto, String marca, String modelo, String tipo) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();

			String sql = "insert into productos(producto,marca,modelo,tipo) values('" + producto + "','" + marca + "','"
					+ modelo + "','" + tipo + "');";
			st.execute(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El registro no se guardo " +e, "Mensaje", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void insertarServicio(String fecha_visita, String servicio_realizado, String repuesto, String meses_garantia,
			String g_f) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();

			String sql = "insert into servicios(fecha_visita,servicio_realizado,repuesto,meses_garantia,g_f) values('" + fecha_visita
					+ "','" + servicio_realizado + "','" + repuesto + "','" + meses_garantia + "', '" + g_f + "');";
			st.execute(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El registro no se guardo "+e, "Mensaje", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	// AGREGADO ERICK
	public void actualizarTablaMaster(String idCliente, String fechaVisita, String servicioRealizado, String gF, String producto, String marca) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String queryTablaServicios = "UPDATE servicios set fecha_visita ='" + fechaVisita + "', servicio_realizado='" + servicioRealizado + "', g_f='" + gF + "' where id_cliente= '" + idCliente + "';";
			st.executeUpdate(queryTablaServicios);
			
			st = conexion.createStatement();
			String queryTablaProductos = "UPDATE productos set producto ='" + producto + "', marca='" + marca + "' where id_cliente= '" + idCliente + "';";
			st.executeUpdate(queryTablaProductos);
			
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
		
	}
	
	public void eliminarTablaMaster(String idCliente, String fechaVisita, String servicioRealizado, String gF, String producto, String marca) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String queryTablaServicios = "DELETE FROM servicios WHERE (id_cliente ='" + idCliente + "') and (fecha_visita='" + fechaVisita + "') and (servicio_realizado='" + servicioRealizado + "') and (g_f='" + gF +"')";
			st.executeUpdate(queryTablaServicios);
			
			st = conexion.createStatement();
			String queryTablaProductos = "DELETE FROM productos WHERE (id_cliente ='" + idCliente + "') and (producto='" + producto + "') and (marca='" + marca + "')";
			st.executeUpdate(queryTablaProductos);
			
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	public DefaultTableModel mostrarTablaResumen(String idCliente) {
		try {
			String queryTablaServicios = "SELECT fecha_visita, servicio_realizado, g_f FROM servicios WHERE id_cliente = " + idCliente;
			String queryTablaProductos = "SELECT producto, marca FROM productos WHERE id_cliente = " + idCliente;
			Connection conexion = conectar();
			DefaultTableModel model = new DefaultTableModel();
			
			model.addColumn("Fecha");
			model.addColumn("Servicio");
			model.addColumn("Producto");
			model.addColumn("Marca");
			model.addColumn("G / F");
			
			String[] datos = new String[5];
			
			// Ejecución de la primera Query
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(queryTablaServicios);
			
			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[4] = rs.getString(3);
			}
			
			// Ejecución de la segunda Query
			st = conexion.createStatement();
			rs = st.executeQuery(queryTablaProductos);
			
			while (rs.next()) {
				datos[2] = rs.getString(1);
				datos[3] = rs.getString(2);
				model.addRow(datos);
			}
			
			conexion.close();
			return model;
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error con la recuperacion de datos: "+e,"Mensaje", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public DefaultTableModel mostrar(String tabla) {
		if (tabla == "clientes") {
			
			String sql = "SELECT * FROM " + tabla + " ORDER BY id_cliente";
			Connection conexion = conectar();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Apellido");
			model.addColumn("Teléfono");
			model.addColumn("Email");

			String[] datos = new String[5];

			try {
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					model.addRow(datos);
				}
				return model;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la tabla clientes " + e, "Error", JOptionPane.ERROR_MESSAGE);
			}
			

		} else if (tabla == "direcciones") {
			
			String sql = "SELECT * FROM " + tabla + " ORDER BY id_direcciones";
			Connection conexion = conectar();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Ciudad");
			model.addColumn("Sector");
			model.addColumn("Calle");
			model.addColumn("Número de casa");
			model.addColumn("Referencia");

			String[] datos = new String[6];

			try {
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					datos[5] = rs.getString(6);
					model.addRow(datos);
				}
				return model;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la tabla direcciones " + e, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (tabla == "productos") {
			
			String sql = "SELECT * FROM " + tabla + " ORDER BY id_producto";
			Connection conexion = conectar();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID producto");
			model.addColumn("ID cliente");
			model.addColumn("Producto");
			model.addColumn("Marca");
			model.addColumn("Modelo");
			model.addColumn("Tipo");

			String[] datos = new String[6];

			try {
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					datos[5] = rs.getString(6);
					model.addRow(datos);
				}
				return model;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la tabla productos " + e, "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (tabla == "servicios") {
			
			String sql = "SELECT * FROM " + tabla + " ORDER BY id_servicio";
			Connection conexion = conectar();
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID servicio");
			model.addColumn("ID producto");
			model.addColumn("ID cliente");
			model.addColumn("Fecha de visita");
			model.addColumn("Servicio realizado");
			model.addColumn("Repuesto");
			model.addColumn("Meses de garantía");
			model.addColumn("G / F");
			

			String[] datos = new String[8];

			try {
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					datos[5] = rs.getString(6);
					datos[6] = rs.getString(7);
					datos[7] = rs.getString(8);
					model.addRow(datos);
				}
				return model;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la tabla servicios " + e, "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encuentra la tabla seleccionada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}
	
	public void mostrarCliente(String id_cliente) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "select * from clientes where id_cliente='"+ id_cliente +"'";
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				var.setId_cliente(rs.getString("id_cliente"));
				var.setNombre(rs.getString("nombre"));
				var.setApellido(rs.getString("apellido"));
				var.setTelefono(rs.getString("telefono"));
				var.setEmail(rs.getString("email"));
				
			}
			else {
				// Modificado Erick
				String sqlRegistroFinal = "SELECT * FROM clientes ORDER BY id_cliente DESC LIMIT 1";
				rs = st.executeQuery(sqlRegistroFinal);
				if(rs.next() ) {
					var.setId_cliente(rs.getString("id_cliente"));
					var.setNombre(rs.getString("nombre"));
					var.setApellido(rs.getString("apellido"));
					var.setTelefono(rs.getString("telefono"));
					var.setEmail(rs.getString("email"));
					
					//JOptionPane.showMessageDialog(null, "Ha llegado al registro final", "Aviso de Limite", JOptionPane.INFORMATION_MESSAGE);
				}								
			}
			st.close();
			conexion.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda " + e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void mostrarDireccion(String id_direcciones) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "select * from direcciones where id_direcciones='"+id_direcciones+"'";
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				var.setId_direcciones(rs.getString("id_direcciones"));
				var.setCiudad(rs.getString("ciudad"));
				var.setSector(rs.getString("sector"));
				var.setCalle(rs.getString("calle"));
				var.setNum_casa(rs.getString("num_casa"));
				var.setReferencia(rs.getString("referencia"));
				
			}
			else {
				var.setId_direcciones("");
				var.setCiudad("");
				var.setSector("");
				var.setCalle("");
				var.setNum_casa("");
				var.setReferencia("");
				JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);				
			}
			st.close();
			conexion.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda " + e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void mostrarProducto(String id_producto) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "select * from productos where id_producto='"+id_producto+"'";
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				var.setId_producto(rs.getString("id_producto"));
				var.setProducto(rs.getString("producto"));
				var.setMarca(rs.getString("marca"));
				var.setModelo(rs.getString("modelo"));
				var.setTipo(rs.getString("tipo"));
				
			}
			else {
				var.setId_producto("");
				var.setProducto("");
				var.setMarca("");
				var.setModelo("");
				var.setTipo("");
				JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);				
			}
			st.close();
			conexion.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda " + e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void mostrarServicio(String id_servicio) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "select * from servicios where id_servicio='"+id_servicio+"'";
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				var.setId_servicio(rs.getString("id_servicio"));
				var.setFecha_visita(rs.getString("fecha_visita"));
				var.setServicio_realizado(rs.getString("servicio_realizado"));
				var.setRepuesto(rs.getString("repuesto"));
				var.setMeses_garantia(rs.getString("meses_garantia"));
				var.setG_f(rs.getString("g_f"));
				
				
			}
			else {
				var.setId_servicio("");
				var.setFecha_visita("");
				var.setServicio_realizado("");
				var.setRepuesto("");
				var.setMeses_garantia("");
				var.setG_f("");
				JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);				
			}
			st.close();
			conexion.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda " + e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	public void actualizarCliente(String nombre, String apellido, String telefono, String email, String id_cliente) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "update clientes set nombre='" + nombre + "', apellido='" + apellido + "', telefono='"
					+ telefono + "', email='" + email + "' where id_cliente= '" + id_cliente + "';";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarDireccion(String ciudad, String sector, String calle, String num_casa, String referencia,
			String id_direcciones) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "update direcciones set ciudad='" + ciudad + "', sector='" + sector + "', calle='" + calle
					+ "', num_casa='" + num_casa + "', referencia='" + referencia + "' where id_direcciones= '"
					+ id_direcciones + "';";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarProducto(String producto, String marca, String modelo, String tipo, String id_producto) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "update productos set producto='" + producto + "', marca='" + marca + "', modelo='" + modelo
					+ "', tipo='" + tipo + "' where id_producto= '" + id_producto + "';";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void actualizarServicio(String fecha_visita, String servicio_realizado, String repuesto,
			String meses_garantia, String g_f, String id_servicio) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "update servicios set fecha_visita='" + fecha_visita + "', servicio_realizado='"
					+ servicio_realizado + "', repuesto='" + repuesto + "', meses_garantia='" + meses_garantia
					+ "', g_f='" + g_f + "' where id_servicio= '" + id_servicio + "';";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarCliente(String id_cliente) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "delete from clientes where id_cliente= '" + id_cliente + "'";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarDireccion(String id_direcciones) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "delete from direcciones where id_direcciones= '" + id_direcciones + "'";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarProducto(String id_producto) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "delete from productos where id_producto= '" + id_producto + "'";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarServicio(String id_servicio) {
		try {
			Connection conexion = conectar();
			st = conexion.createStatement();
			String sql = "delete from servicios where id_servicio= '" + id_servicio + "'";
			st.executeUpdate(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e, "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	

}
