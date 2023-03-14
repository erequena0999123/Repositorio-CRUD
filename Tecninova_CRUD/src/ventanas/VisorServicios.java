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
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaServicios.setModel(CRUD.mostrar(S));
		
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
		botonActualizar.setBackground(new Color(124, 252, 0));
		botonActualizar.setBounds(585, 415, 92, 23);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 0, 51));
		botonEliminar.setBounds(685, 415, 89, 23);
		contentPane.add(botonEliminar);
		
		JButton botonSeleccionar = new JButton("Selecionar");
		botonSeleccionar.setBounds(625, 365, 98, 23);
		contentPane.add(botonSeleccionar);
	}

}
