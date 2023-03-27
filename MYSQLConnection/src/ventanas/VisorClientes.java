package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import paquete_conexion_MySQL.ClientesCRUD;

//import paquete_conexion_Postgresql.CRUD_Postgresql;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class VisorClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable tablaClientes;
	private JTextField cajaID;
	private JTextField cajaNom;
	private JTextField cajaApellidos;
	private JTextField cajaTelefono;
	private JTextField cajaEmail;
	public static String C = "clientes";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorClientes frame = new VisorClientes();
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
	public VisorClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel etiquetaClientes = new JLabel("Lista de clientes");
		etiquetaClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaClientes.setBounds(219, 11, 123, 14);
		contentPane.add(etiquetaClientes);
		
		JButton botonAtrás = new JButton("Atrás");
		botonAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 llamarVentana2 = new Ventana2();
				llamarVentana2.setVisible(true);
				dispose();
			}
		});
		botonAtrás.setBounds(0, 0, 70, 23);
		contentPane.add(botonAtrás);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 575, 400);
		contentPane.add(scrollPane);
		
		tablaClientes = new JTable();
		tablaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null},
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
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"id", "Nombres", "Apellidos", "Tel\u00E9fono", "Email"
			}
		));
		scrollPane.setViewportView(tablaClientes);
		
//Interaccion con la tabla y el usuario
//=================================================================================================================
		
		//CRUD_Postgresql CRUD = new CRUD_Postgresql();
		//this.tablaClientes.setModel(CRUD.mostrar(C));
		ClientesCRUD nuevaConexion = new ClientesCRUD();
		this.tablaClientes.setModel(nuevaConexion.Seleccionar());
		
		tablaClientes.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				
				JTable tabla = (JTable) Mouse_evt.getSource();
				Point punto = Mouse_evt.getPoint();
				int row = tabla.rowAtPoint(punto);
				int col = tablaClientes.getSelectedRow();
				
				if(Mouse_evt.getClickCount() == 1) {
					cajaID.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
					cajaNom.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString());
					cajaApellidos.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 2).toString());
					cajaTelefono.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3).toString());
					cajaEmail.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 4).toString());
				}
			}
		});
		
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaID = new JLabel("ID");
		etiquetaID.setBounds(600, 40, 46, 14);
		contentPane.add(etiquetaID);
		
		JLabel etiquetaNombre = new JLabel("Nombres");
		etiquetaNombre.setBounds(600, 90, 77, 14);
		contentPane.add(etiquetaNombre);
		
		JLabel etiquetaApellidos = new JLabel("Apellidos");
		etiquetaApellidos.setBounds(600, 140, 77, 14);
		contentPane.add(etiquetaApellidos);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setBounds(600, 190, 77, 14);
		contentPane.add(etiquetaTelefono);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setBounds(600, 240, 46, 14);
		contentPane.add(etiquetaEmail);
		
//Cajas de texto
//=================================================================================================================
		
		cajaID = new JTextField();
		cajaID.setBounds(600, 55, 150, 20);
		contentPane.add(cajaID);
		cajaID.setColumns(10);
		
		cajaNom = new JTextField();
		cajaNom.setBounds(600, 105, 150, 20);
		contentPane.add(cajaNom);
		cajaNom.setColumns(10);
		
		cajaApellidos = new JTextField();
		cajaApellidos.setBounds(600, 155, 150, 20);
		contentPane.add(cajaApellidos);
		cajaApellidos.setColumns(10);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(600, 205, 150, 20);
		contentPane.add(cajaTelefono);
		cajaTelefono.setColumns(10);
		
		cajaEmail = new JTextField();
		cajaEmail.setBounds(600, 255, 155, 20);
		contentPane.add(cajaEmail);
		cajaEmail.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dato1 = cajaNom.getText();
				String dato2 = cajaApellidos.getText();
				String dato3 = cajaTelefono.getText();
				String dato4 = cajaEmail.getText();
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
				tablaClientes.setModel(nuevaConexion.Seleccionar());
			}
		});
		botonSeleccionar.setBounds(625, 365, 98, 23);
		contentPane.add(botonSeleccionar);
		
		
	}
}
