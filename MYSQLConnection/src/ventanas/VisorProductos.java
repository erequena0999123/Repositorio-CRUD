package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import paquete_conexion_MySQL.DireccionesCRUD;
import paquete_conexion_MySQL.ProductosCRUD;

//import paquete_conexion_Postgresql.CRUD_Postgresql;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VisorProductos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProductos;
	private JTextField cajaID;
	private JTextField cajaProducto;
	private JTextField cajaMarca;
	private JTextField cajaModelo;
	private JTextField cajaTipo;
	public static String P = "productos";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorProductos frame = new VisorProductos();
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
	public VisorProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel etiquetaProductos = new JLabel("Lista de productos");
		etiquetaProductos.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaProductos.setBounds(248, 11, 155, 14);
		contentPane.add(etiquetaProductos);
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 llamarVentana2 = new Ventana2();
				llamarVentana2.setVisible(true);
				dispose();
			}
		});
		botonAtras.setBounds(0, 0, 70, 23);
		contentPane.add(botonAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 575, 400);
		contentPane.add(scrollPane);
		
		tablaProductos = new JTable();
		tablaProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, ""},
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
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"id", "Producto", "Marca", "Modelo", "Tipo"
			}
		));
		scrollPane.setViewportView(tablaProductos);
		

//Interaccion con la tabla y el usuario
//=================================================================================================================
		//CRUD_Postgresql CRUD = new CRUD_Postgresql();
		//this.tablaProductos.setModel(CRUD.mostrar(P));
		ProductosCRUD nuevaConexion = new ProductosCRUD();
		this.tablaProductos.setModel(nuevaConexion.Seleccionar());
		
		tablaProductos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				
				JTable tabla = (JTable) Mouse_evt.getSource();
				Point punto = Mouse_evt.getPoint();
				int row = tabla.rowAtPoint(punto);
				int col = tablaProductos.getSelectedRow();
				
				if(Mouse_evt.getClickCount() == 1) {
					cajaID.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0).toString());
					cajaProducto.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2).toString());
					cajaMarca.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3).toString());
					cajaModelo.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4).toString());
					cajaTipo.setText(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString());
				}
			}
		});
		
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaID = new JLabel("ID");
		etiquetaID.setBounds(600, 40, 46, 14);
		contentPane.add(etiquetaID);
		
		JLabel etiquetaProducto = new JLabel("Producto");
		etiquetaProducto.setBounds(600, 90, 56, 14);
		contentPane.add(etiquetaProducto);
		
		JLabel etiquetaMarca = new JLabel("Marca");
		etiquetaMarca.setBounds(600, 140, 46, 14);
		contentPane.add(etiquetaMarca);
		
		JLabel etiquetaModelo = new JLabel("Modelo");
		etiquetaModelo.setBounds(600, 190, 46, 14);
		contentPane.add(etiquetaModelo);
		
		JLabel etiquetaTipo = new JLabel("Tipo");
		etiquetaTipo.setBounds(600, 240, 46, 14);
		contentPane.add(etiquetaTipo);
		
//Cajas de texto
//=================================================================================================================
		
		cajaID = new JTextField();
		cajaID.setBounds(600, 55, 150, 20);
		contentPane.add(cajaID);
		cajaID.setColumns(10);
		
		cajaProducto = new JTextField();
		cajaProducto.setBounds(600, 105, 150, 20);
		contentPane.add(cajaProducto);
		cajaProducto.setColumns(10);
		
		cajaMarca = new JTextField();
		cajaMarca.setBounds(600, 155, 150, 20);
		contentPane.add(cajaMarca);
		cajaMarca.setColumns(10);
		
		cajaModelo = new JTextField();
		cajaModelo.setBounds(600, 205, 150, 20);
		contentPane.add(cajaModelo);
		cajaModelo.setColumns(10);
		
		cajaTipo = new JTextField();
		cajaTipo.setBounds(600, 255, 155, 20);
		contentPane.add(cajaTipo);
		cajaTipo.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dato1 = cajaProducto.getText();
				String dato2 = cajaMarca.getText();
				String dato3 = cajaModelo.getText();
				String dato4 = cajaTipo.getText();
				String dato5 = cajaID.getText();
				
				nuevaConexion.Actualizar(dato1, dato2, dato3, dato4, dato5);
			}
		});
		botonActualizar.setBackground(new Color(124, 252, 0));
		botonActualizar.setBounds(585, 415, 92, 23);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dato1 = cajaID.getText();
				nuevaConexion.Eliminar(dato1);
			}
		});
		botonEliminar.setBackground(new Color(255, 0, 51));
		botonEliminar.setBounds(685, 415, 89, 23);
		contentPane.add(botonEliminar);
		
		JButton botonSeleccionar = new JButton("Selecionar");
		botonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaProductos.setModel(nuevaConexion.Seleccionar());
			}
		});
		botonSeleccionar.setBounds(625, 365, 98, 23);
		contentPane.add(botonSeleccionar);
	}

}
