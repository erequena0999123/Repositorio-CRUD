package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import paquete_conexion_Postgresql.CRUD_Postgresql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisorProductos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProductos;
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
		setBounds(100, 100, 800, 400);
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
		scrollPane.setBounds(0, 40, 575, 300);
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
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaProductos.setModel(CRUD.mostrar(P));
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaProducto = new JLabel("Producto");
		etiquetaProducto.setBounds(600, 40, 56, 14);
		contentPane.add(etiquetaProducto);
		
		JLabel etiquetaMarca = new JLabel("Marca");
		etiquetaMarca.setBounds(600, 90, 46, 14);
		contentPane.add(etiquetaMarca);
		
		JLabel etiquetaModelo = new JLabel("Modelo");
		etiquetaModelo.setBounds(600, 140, 46, 14);
		contentPane.add(etiquetaModelo);
		
		JLabel etiquetaTipo = new JLabel("Tipo");
		etiquetaTipo.setBounds(600, 190, 46, 14);
		contentPane.add(etiquetaTipo);
		
//Cajas de texto
//=================================================================================================================
		
		cajaProducto = new JTextField();
		cajaProducto.setBounds(600, 55, 150, 20);
		contentPane.add(cajaProducto);
		cajaProducto.setColumns(10);
		
		cajaMarca = new JTextField();
		cajaMarca.setBounds(600, 105, 150, 20);
		contentPane.add(cajaMarca);
		cajaMarca.setColumns(10);
		
		cajaModelo = new JTextField();
		cajaModelo.setBounds(600, 155, 150, 20);
		contentPane.add(cajaModelo);
		cajaModelo.setColumns(10);
		
		cajaTipo = new JTextField();
		cajaTipo.setBounds(600, 205, 155, 20);
		contentPane.add(cajaTipo);
		cajaTipo.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(124, 252, 0));
		botonActualizar.setBounds(585, 310, 92, 23);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 0, 51));
		botonEliminar.setBounds(685, 310, 89, 23);
		contentPane.add(botonEliminar);
	}

}
