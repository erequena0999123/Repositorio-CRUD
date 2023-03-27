package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import getset.Variables;
import paquete_conexion_Postgresql.CRUD_Postgresql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setTitle("Tabla clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
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
		scrollPane.setBounds(0, 90, 575, 350);
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
		
		CRUD_Postgresql CRUD = new CRUD_Postgresql();
		this.tablaClientes.setModel(CRUD.mostrar(C));
		
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
		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(50, 205, 50));	
		botonAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarCliente(cajaNom.getText(), cajaApellidos.getText() , cajaTelefono.getText() , cajaEmail.getText());
				
			}
		});
		botonAgregar.setBounds(585, 415, 98, 23);
		contentPane.add(botonAgregar);
		
		
		
		JButton botonSeleccionar = new JButton("Selecionar");
		botonSeleccionar.setBackground(new Color(65, 105, 225));
		Variables var = new Variables();
		botonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD.mostrarCliente(cajaID.getText());
				
				cajaNom.setText(var.getNombre());
				cajaApellidos.setText(var.getApellido());
				cajaTelefono.setText(var.getTelefono());
				cajaEmail.setText(var.getEmail());
			}
		});
		botonSeleccionar.setBounds(585, 415, 98, 23);
		contentPane.add(botonSeleccionar);
		
		
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(255, 255, 0));
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDeJTable();
				CRUD.actualizarCliente(cajaNom.getText(), cajaApellidos.getText(), cajaTelefono.getText(), cajaEmail.getText(), cajaID.getText());
				tablaClientes.setModel(CRUD.mostrar(C));
				
			}
			
		});
		botonActualizar.setBounds(585, 415, 98, 23);
		contentPane.add(botonActualizar);
		
		
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 69, 0));
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?", "Aviso Importante", JOptionPane.YES_NO_OPTION);
				
				if(JOptionPane.OK_OPTION == confirmado) {
					CRUD.eliminarCliente(cajaID.getText());
					tablaClientes.setModel(CRUD.mostrar(C));
				}				
			}
			
		});
		botonEliminar.setBounds(585, 415, 98, 23);
		contentPane.add(botonEliminar);	

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
				cajaNom.setText("");
				cajaApellidos.setText("");
				cajaTelefono.setText("");
				cajaEmail.setText("");
				
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
			int fila = tablaClientes.getSelectedRow();
			String id = tablaClientes.getValueAt(fila, 0).toString();
			String nombre = tablaClientes.getValueAt(fila, 1).toString();
			String apellido = tablaClientes.getValueAt(fila, 2).toString();
			String telefono = tablaClientes.getValueAt(fila, 3).toString();
			String email = tablaClientes.getValueAt(fila, 4).toString();
			
			cajaID.setText(id);
			cajaNom.setText(nombre);
			cajaApellidos.setText(apellido);
			cajaTelefono.setText(telefono);
			cajaEmail.setText(email);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor selecciona antes un registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
