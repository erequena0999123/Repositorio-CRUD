package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import getset.Variables;
import paquete_conexion_Postgresql.CRUD_Postgresql;

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
		setTitle("Tabla servicios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
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
		scrollPane.setBounds(0, 90, 575, 350);
		contentPane.add(scrollPane);

		tablaServicios = new JTable();
		tablaServicios.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "id", "Fecha", "Servicio", "Repuestos", "Meses garant\u00EDa", "G/F" }));
		scrollPane.setViewportView(tablaServicios);

//Interaccion con la tabla y el usuario
//=================================================================================================================	
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaServicios.setModel(CRUD.mostrar(S));

		tablaServicios.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {

				JTable tabla = (JTable) Mouse_evt.getSource();
				Point punto = Mouse_evt.getPoint();
				int row = tabla.rowAtPoint(punto);
				int col = tablaServicios.getSelectedRow();

				if (Mouse_evt.getClickCount() == 1) {
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

		JLabel etiquetaMesesG = new JLabel("Meses Garantía");
		etiquetaMesesG.setBounds(600, 240, 105, 14);
		contentPane.add(etiquetaMesesG);

		JLabel etiquetaGF = new JLabel("G / F");
		etiquetaGF.setBounds(600, 290, 105, 14);
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

		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(50, 205, 50));
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarServicio(cajaFecha.getText(), cajaServicio.getText(), cajaRepuestos.getText(),
						cajaMesesG.getText(), cajaGF.getText());

			}
		});
		botonAgregar.setBounds(585, 415, 98, 23);
		contentPane.add(botonAgregar);

		JButton botonSeleccionar = new JButton("Selecionar");
		botonSeleccionar.setBackground(new Color(65, 105, 225));
		botonSeleccionar.setBounds(585, 415, 98, 23);
		contentPane.add(botonSeleccionar);
		Variables var = new Variables();
		botonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CRUD.mostrarServicio(cajaID.getText());

				cajaFecha.setText(var.getFecha_visita());
				cajaServicio.setText(var.getServicio_realizado());
				cajaRepuestos.setText(var.getRepuesto());
				cajaMesesG.setText(var.getMeses_garantia());
				cajaGF.setText(var.getG_f());
			}

		});

		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(255, 255, 0));
		botonActualizar.setBounds(585, 415, 98, 23);
		contentPane.add(botonActualizar);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDeJTable();
				CRUD.actualizarServicio(cajaFecha.getText(), cajaServicio.getText(), cajaRepuestos.getText(),
						cajaMesesG.getText(), cajaGF.getText(), cajaID.getText());
				tablaServicios.setModel(CRUD.mostrar(S));

			}

		});

		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 0, 51));
		botonEliminar.setBounds(585, 415, 98, 23);
		contentPane.add(botonEliminar);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?", "Aviso Importante", JOptionPane.YES_NO_OPTION);
				
				if(JOptionPane.OK_OPTION == confirmado) {
					CRUD.eliminarServicio(cajaID.getText());
					tablaServicios.setModel(CRUD.mostrar(S));
				}
			}
		});

//Botones1
//***************************************************************************************************************************

		JButton botonAgregar1 = new JButton("Agregar");
		botonAgregar1.setBackground(new Color(50, 205, 50));
		botonAgregar1.setBounds(70, 36, 102, 23);
		contentPane.add(botonAgregar1);

		JButton botonSeleccionar1 = new JButton("Seleccionar");
		botonSeleccionar1.setBackground(new Color(65, 105, 225));
		botonSeleccionar1.setBounds(175, 36, 102, 23);
		contentPane.add(botonSeleccionar1);

		JButton botonActualizar1 = new JButton("Actualizar");
		botonActualizar1.setBackground(new Color(255, 255, 0));
		botonActualizar1.setBounds(280, 36, 102, 23);
		contentPane.add(botonActualizar1);

		JButton botonEliminar1 = new JButton("Eliminar");
		botonEliminar1.setBackground(new Color(255, 69, 0));
		botonEliminar1.setBounds(385, 36, 102, 23);
		contentPane.add(botonEliminar1);

//Métodos
//****************************************************************************************************************************************

		botonAgregar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar1.setVisible(false);
				setBounds(100, 100, 800, 500);
				setLocationRelativeTo(null);

				cajaID.setEditable(false);
				cajaID.setText("");
				cajaFecha.setText("");
				cajaServicio.setText("");
				cajaRepuestos.setText("");
				cajaMesesG.setText("");
				cajaGF.setText("");

				botonAgregar.setVisible(true);
				botonSeleccionar.setVisible(false);
				botonActualizar.setVisible(false);
				botonEliminar.setVisible(false);

				botonSeleccionar1.setVisible(true);
				botonActualizar1.setVisible(true);
				botonEliminar1.setVisible(true);
			}
		});

		botonSeleccionar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSeleccionar1.setVisible(false);
				setBounds(100, 100, 800, 500);
				setLocationRelativeTo(null);

				cajaID.setEditable(true);

				botonAgregar.setVisible(false);
				botonSeleccionar.setVisible(true);
				botonActualizar.setVisible(false);
				botonEliminar.setVisible(false);

				botonAgregar1.setVisible(true);
				botonActualizar1.setVisible(true);
				botonEliminar1.setVisible(true);
			}
		});

		botonActualizar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonActualizar1.setVisible(false);
				setBounds(100, 100, 800, 500);
				setLocationRelativeTo(null);

				cajaID.setEditable(true);

				botonAgregar.setVisible(false);
				botonSeleccionar.setVisible(false);
				botonActualizar.setVisible(true);
				botonEliminar.setVisible(false);

				botonAgregar1.setVisible(true);
				botonSeleccionar1.setVisible(true);
				botonEliminar1.setVisible(true);
			}
		});

		botonEliminar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonEliminar1.setVisible(false);
				setBounds(100, 100, 800, 500);
				setLocationRelativeTo(null);

				cajaID.setEditable(true);

				botonAgregar.setVisible(false);
				botonSeleccionar.setVisible(false);
				botonActualizar.setVisible(false);
				botonEliminar.setVisible(true);

				botonAgregar1.setVisible(true);
				botonSeleccionar1.setVisible(true);
				botonActualizar1.setVisible(true);
			}
		});

//Cerrar
//********************************************************************************************************************************************************

		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar1.setVisible(true);
				botonSeleccionar1.setVisible(true);
				botonActualizar1.setVisible(true);
				botonEliminar1.setVisible(true);
				setBounds(100, 100, 600, 500);
				setLocationRelativeTo(null);
				botonAgregar.setVisible(false);
				botonSeleccionar.setVisible(false);
				botonActualizar.setVisible(false);
				botonEliminar.setVisible(false);
			}
		});
		botonCerrar.setBounds(685, 415, 89, 23);
		contentPane.add(botonCerrar);
	}

	public void actualizarDeJTable() {
		try {
			int fila = tablaServicios.getSelectedRow();

			String id = tablaServicios.getValueAt(fila, 0).toString();
			String fecha = tablaServicios.getValueAt(fila, 3).toString();
			String servicio = tablaServicios.getValueAt(fila, 4).toString();
			String repuesto = tablaServicios.getValueAt(fila, 5).toString();
			String mesesG = tablaServicios.getValueAt(fila, 6).toString();
			String gF = tablaServicios.getValueAt(fila, 7).toString();

			cajaID.setText(id);
			cajaFecha.setText(fecha);
			cajaServicio.setText(servicio);
			cajaRepuestos.setText(repuesto);
			cajaMesesG.setText(mesesG);
			cajaGF.setText(gF);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor selecciona antes un registro", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
