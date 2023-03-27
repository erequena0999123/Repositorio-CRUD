package ventanas;

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
import javax.swing.table.DefaultTableModel;

import paquete_conexion_MySQL.DireccionesCRUD;
//import paquete_conexion_Postgresql.CRUD_Postgresql;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class VisorDirecciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaDirecciones;
	private JTextField cajaID;
	private JTextField cajaCiudad;
	private JTextField cajaSector;
	private JTextField cajaCalles;
	private JTextField cajaNum;
	private JTextField cajaRef;
	public static String D = "direcciones";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorDirecciones frame = new VisorDirecciones();
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
	public VisorDirecciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel etiquetaClientes = new JLabel("Lista de direcciones");
		etiquetaClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaClientes.setBounds(242, 11, 138, 14);
		contentPane.add(etiquetaClientes);
		
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
		
		tablaDirecciones = new JTable();
		tablaDirecciones.setModel(new DefaultTableModel(
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
				"id", "Ciudad", "Sector", "Calles", "N\u00B0 de casa", "Referencia"
			}
		));
		scrollPane.setViewportView(tablaDirecciones);
		

//Interaccion con la tabla y el usuario
//=================================================================================================================
		//CRUD_Postgresql CRUD = new CRUD_Postgresql();
		//this.tablaDirecciones.setModel(CRUD.mostrar(D));
		DireccionesCRUD nuevaConexion = new DireccionesCRUD();
		this.tablaDirecciones.setModel(nuevaConexion.Seleccionar());
		
		tablaDirecciones.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				
				JTable tabla = (JTable) Mouse_evt.getSource();
				Point punto = Mouse_evt.getPoint();
				int row = tabla.rowAtPoint(punto);
				int col = tablaDirecciones.getSelectedRow();
				
				if(Mouse_evt.getClickCount() == 1) {
					cajaID.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 0).toString());
					cajaCiudad.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 1).toString());
					cajaSector.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 2).toString());
					cajaCalles.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 3).toString());
					cajaNum.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 4).toString());
					cajaRef.setText(tablaDirecciones.getValueAt(tablaDirecciones.getSelectedRow(), 5).toString());
				}
			}
		});
		
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaID = new JLabel("ID");
		etiquetaID.setBounds(600, 40, 46, 14);
		contentPane.add(etiquetaID);
		
		JLabel etiquetaCiudad = new JLabel("Ciudad");
		etiquetaCiudad.setBounds(600, 90, 46, 14);
		contentPane.add(etiquetaCiudad);
		
		JLabel etiquetaSector = new JLabel("Sector");
		etiquetaSector.setBounds(600, 140, 46, 14);
		contentPane.add(etiquetaSector);
		
		JLabel etiquetaCalles = new JLabel("Calles");
		etiquetaCalles.setBounds(600, 190, 46, 14);
		contentPane.add(etiquetaCalles);
		
		JLabel etiquetaNum = new JLabel("N° de casa");
		etiquetaNum.setBounds(600, 240, 70, 14);
		contentPane.add(etiquetaNum);
		
		JLabel etiquetaRef = new JLabel("Referencia");
		etiquetaRef.setBounds(600, 290, 70, 14);
		contentPane.add(etiquetaRef);
		
//Cajas de texto
//=================================================================================================================
		
		cajaID = new JTextField();
		cajaID.setBounds(600, 55, 150, 20);
		contentPane.add(cajaID);
		cajaID.setColumns(10);
		
		cajaCiudad = new JTextField();
		cajaCiudad.setBounds(600, 105, 150, 20);
		contentPane.add(cajaCiudad);
		cajaCiudad.setColumns(10);
		
		cajaSector = new JTextField();
		cajaSector.setBounds(600, 155, 150, 20);
		contentPane.add(cajaSector);
		cajaSector.setColumns(10);
		
		cajaCalles = new JTextField();
		cajaCalles.setBounds(600, 205, 150, 20);
		contentPane.add(cajaCalles);
		cajaCalles.setColumns(10);
		
		cajaNum = new JTextField();
		cajaNum.setBounds(600, 255, 150, 20);
		contentPane.add(cajaNum);
		cajaNum.setColumns(10);
		
		cajaRef = new JTextField();
		cajaRef.setBounds(600, 305, 150, 20);
		contentPane.add(cajaRef);
		cajaRef.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dato1 = cajaCiudad.getText();
				String dato2 = cajaSector.getText();
				String dato3 = cajaCalles.getText();
				String dato4 = cajaNum.getText();
				String dato5 = cajaRef.getText();
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
				tablaDirecciones.setModel(nuevaConexion.Seleccionar());
			}
		});
		botonSeleccionar.setBounds(625, 365, 98, 23);
		contentPane.add(botonSeleccionar);
	}

}
