package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import getset.Variables;
import paquete_conexion_Postgresql.CRUD_Postgresql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaResumen extends JFrame {

	private JPanel contentPane;
	private JTextField cajaTID;
	private JTextField cajaTTelef;
	private JTextField cajaTNombre;
	private JTextField cajaTApellido;
	private JTextField cajaTCorreo;
	private JButton botonAtras;
	private JButton botonInicio;
	private JButton botonMenosUno;
	private JButton botonMasUno;
	private JButton botonFinal;
	private JTable tablaMaster;
	
	CRUD_Postgresql CRUD = new CRUD_Postgresql();
	Variables var = new Variables();
	int idCliente = 1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaResumen frame = new VentanaResumen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaResumen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		

//Etiquetas
//==========================================================================================================================================
		
		JLabel etiquetaResumen = new JLabel("Resumen de clientes");
		etiquetaResumen.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaResumen.setBounds(239, 11, 151, 14);
		contentPane.add(etiquetaResumen);
		
		JLabel etiquetaCodigo = new JLabel("Código:");
		etiquetaCodigo.setBounds(20, 60, 46, 14);
		contentPane.add(etiquetaCodigo);
		
		JLabel etiquetasTelf = new JLabel("Teléfono:");
		etiquetasTelf.setBounds(20, 100, 57, 14);
		contentPane.add(etiquetasTelf);
		
		JLabel etiquetaNombres = new JLabel("Nombres:");
		etiquetaNombres.setBounds(200, 60, 57, 14);
		contentPane.add(etiquetaNombres);
		
		JLabel etiquetaApellidos = new JLabel("Apellidos:");
		etiquetaApellidos.setBounds(400, 60, 63, 14);
		contentPane.add(etiquetaApellidos);
		
		JLabel etiquetaCorreo = new JLabel("Correo:");
		etiquetaCorreo.setBounds(200, 100, 57, 14);
		contentPane.add(etiquetaCorreo);
		
//Cajas de texto
//==========================================================================================================================================
		cajaTID = new JTextField();
		cajaTID.setEditable(false);
		cajaTID.setBounds(80, 55, 86, 20);
		contentPane.add(cajaTID);
		cajaTID.setColumns(10);
		
		cajaTTelef = new JTextField();
		cajaTTelef.setEditable(false);
		cajaTTelef.setBounds(80, 95, 86, 20);
		contentPane.add(cajaTTelef);
		cajaTTelef.setColumns(10);
		
		cajaTNombre = new JTextField();
		cajaTNombre.setEditable(false);
		cajaTNombre.setBounds(260, 55, 120, 20);
		contentPane.add(cajaTNombre);
		cajaTNombre.setColumns(10);
		
		cajaTApellido = new JTextField();
		cajaTApellido.setEditable(false);
		cajaTApellido.setBounds(460, 55, 120, 20);
		contentPane.add(cajaTApellido);
		cajaTApellido.setColumns(10);
		
		cajaTCorreo = new JTextField();
		cajaTCorreo.setEditable(false);
		cajaTCorreo.setBounds(260, 95, 120, 20);
		contentPane.add(cajaTCorreo);
		cajaTCorreo.setColumns(10);
		
		cambioDatos();

//Tabla
//==================================================================================================================================================
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 189, 634, 192);
		contentPane.add(scrollPane);
		
		tablaMaster = new JTable();
		tablaMaster.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Fecha", "Servicio", "Producto", "Marca", "Costo"
			}
		));
		tablaMaster.getColumnModel().getColumn(0).setPreferredWidth(52);
		tablaMaster.getColumnModel().getColumn(1).setPreferredWidth(99);
		tablaMaster.getColumnModel().getColumn(2).setPreferredWidth(72);
		tablaMaster.getColumnModel().getColumn(3).setPreferredWidth(77);
		tablaMaster.getColumnModel().getColumn(4).setPreferredWidth(60);
		scrollPane.setViewportView(tablaMaster);
		
		this.tablaMaster.setModel(CRUD.mostrarTablaResumen(Integer.toString(idCliente)));

//Botones
//===================================================================================================================================================
		botonAtras = new JButton("Atrás");
		botonAtras.setBackground(new Color(204, 255, 0));
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 llamarVentana2 = new Ventana2();
				llamarVentana2.setVisible(true);
				dispose();
			}
		});
		
		botonAtras.setBounds(0, 0, 74, 23);
		contentPane.add(botonAtras);
		
		botonInicio = new JButton("|<<");
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente > 6) {
					idCliente -= 5;
				} else {
					idCliente = 1;
				}
				
				cambioDatos();
				tablaMaster.setModel(CRUD.mostrarTablaResumen(Integer.toString(idCliente)));
			}
		});
		botonInicio.setForeground(new Color(255, 255, 255));
		botonInicio.setBackground(new Color(0, 0, 0));
		botonInicio.setBounds(180, 145, 60, 23);
		contentPane.add(botonInicio);
		
		botonMenosUno = new JButton("<");
		botonMenosUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente > 1) {
					idCliente -= 1;
					cambioDatos();
					tablaMaster.setModel(CRUD.mostrarTablaResumen(Integer.toString(idCliente)));
				}
			}
		});
		botonMenosUno.setForeground(new Color(255, 255, 255));
		botonMenosUno.setBackground(new Color(0, 0, 0));
		botonMenosUno.setBounds(255, 145, 60, 23);
		contentPane.add(botonMenosUno);
		
		botonMasUno = new JButton(">");
		botonMasUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente >= 1) {
					idCliente += 1;
					cambioDatos();
					// Esta linea de código que parece innecesaria
					// sirve especialmente para cuando la variable idCliente
					// sobrepasa al id_cliente de la base de datos
					idCliente = Integer.parseInt(var.getId_cliente());
					tablaMaster.setModel(CRUD.mostrarTablaResumen(Integer.toString(idCliente)));
				}
				
			}
		});
		botonMasUno.setForeground(new Color(255, 255, 255));
		botonMasUno.setBackground(new Color(0, 0, 0));
		botonMasUno.setBounds(330, 145, 60, 23);
		contentPane.add(botonMasUno);
		
		botonFinal = new JButton(">>|");
		botonFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente >= 1) {
					idCliente += 5;
					cambioDatos();
					// Esta linea de código que parece innecesaria
					// sirve especialmente para cuando la variable idCliente
					// sobrepasa al id_cliente de la base de datos
					idCliente = Integer.parseInt(var.getId_cliente());
					tablaMaster.setModel(CRUD.mostrarTablaResumen(Integer.toString(idCliente)));
				}
			}
		});
		botonFinal.setForeground(new Color(255, 255, 255));
		botonFinal.setBackground(new Color(0, 0, 0));
		botonFinal.setBounds(405, 145, 60, 23);
		contentPane.add(botonFinal);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEliminarJTable("u");
			}
		});
		botonActualizar.setBounds(400, 96, 101, 23);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEliminarJTable("d");
			}
		});
		botonEliminar.setBounds(511, 96, 89, 23);
		contentPane.add(botonEliminar);
		
	}
	
// Mostrar los datos en cajas de texto
//--------------------------------------------------------------------------------------------------------
	public void cambioDatos() {
		CRUD.mostrarCliente(Integer.toString(idCliente));
		cajaTID.setText(var.getId_cliente());
		cajaTNombre.setText(var.getNombre());
		cajaTApellido.setText(var.getApellido());
		cajaTTelef.setText(var.getTelefono());
		cajaTCorreo.setText(var.getEmail());
	}
	
// Boton de actualizar y eliminar
//=========================================================================================================
	public void actualizarEliminarJTable(String accion) {
		try {
			int fila = tablaMaster.getSelectedRow();
			String id = cajaTID.getText();
			
			String fecha = tablaMaster.getValueAt(fila, 0).toString();
			String sevicio = tablaMaster.getValueAt(fila, 1).toString();
			String producto = tablaMaster.getValueAt(fila, 2).toString();
			String marca = tablaMaster.getValueAt(fila, 3).toString();
			String gF = tablaMaster.getValueAt(fila, 4).toString();
			
			// Actualizar (u) o eliminar (d) //
			if(accion == "u") {
				CRUD.actualizarTablaMaster(id, fecha, sevicio, gF, producto, marca);
				CRUD.mostrarTablaResumen(id);
			}
			if(accion == "d") {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?", "Aviso Importante", JOptionPane.YES_NO_OPTION);
				
				if(JOptionPane.OK_OPTION == confirmado) {
					CRUD.eliminarTablaMaster(id, fecha, sevicio, gF, producto, marca);
					CRUD.mostrarTablaResumen(id);
				}
					
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor selecciona antes un registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
