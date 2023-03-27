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

import paquete_conexion_MySQL.ServiciosCRUD;

//import paquete_conexion_Postgresql.CRUD_Postgresql;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VisorServicios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaServicios;
	private JTextField cajaID;
	private JTextField cajaFecha;
	private JTextField cajaServicio;
	private JTextField cajaRepuestos;
	private JTextField cajaMesesG;
	private JTextField cajaGF;
	public static String S = "servicios";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorServicios frame = new VisorServicios();
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
	public VisorServicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel etiquetaServicios = new JLabel("Lista de servicios");
		etiquetaServicios.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaServicios.setBounds(238, 9, 118, 14);
		contentPane.add(etiquetaServicios);
		
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
		
		tablaServicios = new JTable();
		tablaServicios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "Fecha", "Servicio", "Repuestos", "Meses garant\u00EDa", "G/F"
			}
		));
		scrollPane.setViewportView(tablaServicios);

		
//Interaccion con la tabla y el usuario
//=================================================================================================================
		//CRUD_Postgresql CRUD = new CRUD_Postgresql();
		//this.tablaServicios.setModel(CRUD.mostrar(S));
		ServiciosCRUD nuevaConexion = new ServiciosCRUD();
		this.tablaServicios.setModel(nuevaConexion.Seleccionar());
		
		tablaServicios.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				
				JTable tabla = (JTable) Mouse_evt.getSource();
				Point punto = Mouse_evt.getPoint();
				int row = tabla.rowAtPoint(punto);
				int col = tablaServicios.getSelectedRow();
				
				if(Mouse_evt.getClickCount() == 1) {
					cajaID.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0).toString());
					cajaFecha.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 3).toString());
					cajaServicio.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 4).toString());
					cajaRepuestos.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 5).toString());
					cajaMesesG.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 6).toString());
					cajaGF.setText(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 7).toString());
				}
			}
		});
		
			
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaID = new JLabel("ID");
		etiquetaID.setBounds(600, 40, 46, 14);
		contentPane.add(etiquetaID);
		
		JLabel etiquetaFecha = new JLabel("Fecha");
		etiquetaFecha.setBounds(600, 90, 46, 14);
		contentPane.add(etiquetaFecha);
		
		JLabel etiquetaServicio = new JLabel("Servicio");
		etiquetaServicio.setBounds(600, 140, 70, 14);
		contentPane.add(etiquetaServicio);
		
		JLabel etiquetaRepuestos = new JLabel("Repuestos");
		etiquetaRepuestos.setBounds(600, 190, 70, 14);
		contentPane.add(etiquetaRepuestos);
		
		JLabel etiquetaMesesG = new JLabel("Meses de garantía");
		etiquetaMesesG.setBounds(600, 240, 105, 14);
		contentPane.add(etiquetaMesesG);	
		
		JLabel etiquetaGF = new JLabel("G/F");
		etiquetaGF.setBounds(600, 290, 70, 14);
		contentPane.add(etiquetaGF);
		
//Cajas de texto
//=================================================================================================================
		
		cajaID = new JTextField();
		cajaID.setBounds(600, 55, 150, 20);
		contentPane.add(cajaID);
		cajaID.setColumns(10);
		
		cajaFecha = new JTextField();
		cajaFecha.setBounds(600, 105, 150, 20);
		contentPane.add(cajaFecha);
		cajaFecha.setColumns(10);
		
		cajaServicio = new JTextField();
		cajaServicio.setBounds(600, 155, 150, 20);
		contentPane.add(cajaServicio);
		cajaServicio.setColumns(10);
		
		cajaRepuestos = new JTextField();
		cajaRepuestos.setBounds(600, 205, 150, 20);
		contentPane.add(cajaRepuestos);
		cajaRepuestos.setColumns(10);
		
		cajaMesesG = new JTextField();
		cajaMesesG.setBounds(600, 255, 150, 20);
		contentPane.add(cajaMesesG);
		cajaMesesG.setColumns(10);
		
		cajaGF = new JTextField();
		cajaGF.setBounds(600, 305, 150, 20);
		contentPane.add(cajaGF);
		cajaGF.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dato1 = cajaFecha.getText();
				String dato2 = cajaServicio.getText();
				String dato3 = cajaRepuestos.getText();
				String dato4 = cajaMesesG.getText();
				String dato5 = cajaGF.getText();
				String dato6 = cajaID.getText();
				
				nuevaConexion.Actualizar(dato1, dato2, dato3, dato4, dato5, dato6);
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
				tablaServicios.setModel(nuevaConexion.Seleccionar());
			}
		});
		botonSeleccionar.setBounds(625, 365, 98, 23);
		contentPane.add(botonSeleccionar);
	}

}
