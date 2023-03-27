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
		setTitle("Tabla productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
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
		scrollPane.setBounds(0, 90, 575, 350);
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
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaProductos.setModel(CRUD.mostrar(P));
		
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
		
		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(50, 205, 50));	
		botonAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarProducto(cajaProducto.getText(), cajaMarca.getText(), cajaModelo.getText(), cajaTipo.getText());
				
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
				
				CRUD.mostrarProducto(cajaID.getText());
				
				cajaProducto.setText(var.getProducto());
				cajaMarca.setText(var.getMarca());
				cajaModelo.setText(var.getModelo());
				cajaTipo.setText(var.getTipo());
			}
			
		});
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(255, 255, 0));
		botonActualizar.setBounds(585, 415, 98, 23);
		contentPane.add(botonActualizar);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDeJTable();
				CRUD.actualizarProducto(cajaProducto.getText(), cajaMarca.getText(), cajaModelo.getText(), cajaTipo.getText(), cajaID.getText());
				tablaProductos.setModel(CRUD.mostrar(P));
		
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
					CRUD.eliminarProducto(cajaID.getText());
					tablaProductos.setModel(CRUD.mostrar(P));
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
				cajaProducto.setText("");
				cajaMarca.setText("");
				cajaModelo.setText("");
				cajaTipo.setText("");
				
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
			int fila = tablaProductos.getSelectedRow();
			
			String id = tablaProductos.getValueAt(fila, 0).toString();
			String producto = tablaProductos.getValueAt(fila, 2).toString();
			String marca = tablaProductos.getValueAt(fila, 3).toString();
			String modelo = tablaProductos.getValueAt(fila, 4).toString();
			String tipo = tablaProductos.getValueAt(fila, 5).toString();
			
			cajaID.setText(id);
			cajaProducto.setText(producto);
			cajaMarca.setText(marca);
			cajaModelo.setText(modelo);
			cajaTipo.setText(tipo);
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor selecciona antes un registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
