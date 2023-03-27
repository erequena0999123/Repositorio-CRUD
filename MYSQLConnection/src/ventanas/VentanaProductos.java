package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paquete_conexion_MySQL.ProductosCRUD;
import paquete_conexion_Postgresql.CRUD_Postgresql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaProductos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaProducto;
	private JTextField cajaMarca;
	private JTextField cajaModelo;
	private JTextField cajaTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProductos frame = new VentanaProductos();
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
	public VentanaProductos() {
		
//Frame
//=================================================================================================================
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaProd01 = new JLabel("Ingrese los datos del producto");
		etiquetaProd01.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaProd01.setBounds(72, 10, 205, 14);
		contentPane.add(etiquetaProd01);
		
		JLabel etiquetaProducto = new JLabel("Producto:");
		etiquetaProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaProducto.setBounds(38, 50, 61, 14);
		contentPane.add(etiquetaProducto);
		
		JLabel etiquetaMarca = new JLabel("Marca:");
		etiquetaMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaMarca.setBounds(38, 85, 46, 14);
		contentPane.add(etiquetaMarca);
		
		JLabel etiquetaModelo = new JLabel("Modelo:");
		etiquetaModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaModelo.setBounds(38, 120, 46, 14);
		contentPane.add(etiquetaModelo);
		
		JLabel etiquetaTipo = new JLabel("Tipo:");
		etiquetaTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaTipo.setBounds(38, 155, 46, 14);
		contentPane.add(etiquetaTipo);
		
//Cajas de texto
//=================================================================================================================
		
		cajaProducto = new JTextField();
		cajaProducto.setBounds(120, 50, 200, 20);
		contentPane.add(cajaProducto);
		cajaProducto.setColumns(10);
		
		cajaMarca = new JTextField();
		cajaMarca.setBounds(120, 85, 200, 20);
		contentPane.add(cajaMarca);
		cajaMarca.setColumns(10);
		
		cajaModelo = new JTextField();
		cajaModelo.setBounds(120, 120, 200, 20);
		contentPane.add(cajaModelo);
		cajaModelo.setColumns(10);
		
		cajaTipo = new JTextField();
		cajaTipo.setBounds(120, 155, 200, 20);
		contentPane.add(cajaTipo);
		cajaTipo.setColumns(10);
		
//Botones
//=================================================================================================================
		
		JButton botonRegresar = new JButton("<");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDirecciones llamarVentanaDirecciones = new VentanaDirecciones();
				llamarVentanaDirecciones.setVisible(true);
				dispose();
			}
		});
		botonRegresar.setBounds(50, 202, 50, 23);
		contentPane.add(botonRegresar);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CRUD_Postgresql CRUD = new CRUD_Postgresql();
				//CRUD.insertarProducto(cajaProducto.getText(), cajaMarca.getText(), cajaModelo.getText(), cajaTipo.getText());
				ProductosCRUD nuevaConexion = new ProductosCRUD();
				nuevaConexion.Insertar(cajaProducto.getText(), cajaMarca.getText(), cajaModelo.getText(), cajaTipo.getText());
				
				JOptionPane.showMessageDialog(null, "Producto guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonGuardar.setBounds(135, 202, 80, 23);
		contentPane.add(botonGuardar);
		
		JButton botonSiguiente = new JButton(">");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				VentanaServicios llamarVentanaServicios = new VentanaServicios();
				llamarVentanaServicios.setVisible(true);
				dispose();				
			}
		});
		botonSiguiente.setBounds(250, 202, 50, 23);
		contentPane.add(botonSiguiente);
	}
}
