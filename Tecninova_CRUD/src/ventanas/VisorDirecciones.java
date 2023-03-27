package ventanas;

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
import javax.swing.table.DefaultTableModel;

import getset.Variables;
import paquete_conexion_Postgresql.CRUD_Postgresql;

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
		setTitle("Tabla direcciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
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
		scrollPane.setBounds(0, 90, 575, 350);
		contentPane.add(scrollPane);

		tablaDirecciones = new JTable();
		tablaDirecciones.setModel(new DefaultTableModel(
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
				new String[] { "id", "Ciudad", "Sector", "Calles", "N\u00B0 de casa", "Referencia" }));
		scrollPane.setViewportView(tablaDirecciones);

//Interaccion con la tabla y el usuario
//=================================================================================================================
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaDirecciones.setModel(CRUD.mostrar(D));
		
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

		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(50, 205, 50));
		botonAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarDireccion(cajaCiudad.getText(), cajaSector.getText(), cajaCalles.getText(), cajaNum.getText(), cajaRef.getText());
				
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

				CRUD.mostrarDireccion(cajaID.getText());

				cajaCiudad.setText(var.getCiudad());
				cajaSector.setText(var.getSector());
				cajaCalles.setText(var.getCalle());
				cajaNum.setText(var.getNum_casa());
				cajaRef.setText(var.getReferencia());
			}

		});
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(255, 255, 0));
		botonActualizar.setBounds(585, 415, 98, 23);
		contentPane.add(botonActualizar);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDeJTable();
				CRUD.actualizarDireccion(cajaCiudad.getText(), cajaSector.getText(), cajaCalles.getText(), cajaNum.getText(), cajaRef.getText(), cajaID.getText());
				tablaDirecciones.setModel(CRUD.mostrar(D));

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
					CRUD.eliminarDireccion(cajaID.getText());
					tablaDirecciones.setModel(CRUD.mostrar(D));
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
				cajaCiudad.setText("");
				cajaSector.setText("");
				cajaCalles.setText("");
				cajaNum.setText("");
				cajaRef.setText("");
				
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
			int fila = tablaDirecciones.getSelectedRow();
			
			String id = tablaDirecciones.getValueAt(fila, 0).toString();
			String ciudad = tablaDirecciones.getValueAt(fila, 1).toString();
			String sector = tablaDirecciones.getValueAt(fila, 2).toString();
			String calle = tablaDirecciones.getValueAt(fila, 3).toString();
			String numero = tablaDirecciones.getValueAt(fila, 4).toString();
			String referencia = tablaDirecciones.getValueAt(fila, 5).toString();
			
			cajaID.setText(id);
			cajaCiudad.setText(ciudad);
			cajaSector.setText(sector);
			cajaCalles.setText(calle);
			cajaNum.setText(numero);
			cajaRef.setText(referencia);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor selecciona antes un registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
