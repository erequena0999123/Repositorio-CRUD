package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paquete_conexion_Postgresql.CRUD_Postgresql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDirecciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaCiudad;
	private JTextField cajaSector;
	private JTextField cajaCalles;
	private JTextField cajaNum;
	private JTextField cajaRef;
	private JButton botonRegresar;
	private JButton botonGuardar;
	private JButton botonSiguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDirecciones frame = new VentanaDirecciones();
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
	public VentanaDirecciones() {
		
//Frame
//=================================================================================================================
		setTitle("Direcciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaDir01 = new JLabel("Ingrese la dirección del cliente");
		etiquetaDir01.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaDir01.setBounds(81, 11, 208, 14);
		contentPane.add(etiquetaDir01);
		
		JLabel etiquetaCiudad = new JLabel("Ciudad:");
		etiquetaCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaCiudad.setBounds(38, 50, 46, 14);
		contentPane.add(etiquetaCiudad);
		
		JLabel etiquetaSector = new JLabel("Sector:");
		etiquetaSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaSector.setBounds(38, 90, 46, 14);
		contentPane.add(etiquetaSector);
		
		JLabel etiquetaCalles = new JLabel("Calles:");
		etiquetaCalles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaCalles.setBounds(38, 130, 46, 14);
		contentPane.add(etiquetaCalles);
		
		JLabel etiquetaNum = new JLabel("N° de casa:");
		etiquetaNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaNum.setBounds(38, 170, 68, 14);
		contentPane.add(etiquetaNum);
		
		JLabel etiquetaRef = new JLabel("Referencia:");
		etiquetaRef.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaRef.setBounds(38, 210, 68, 14);
		contentPane.add(etiquetaRef);
		
//Cajas de texto
//=================================================================================================================
		
		cajaCiudad = new JTextField();
		cajaCiudad.setBounds(120, 47, 200, 20);
		contentPane.add(cajaCiudad);
		cajaCiudad.setColumns(10);
		
		cajaSector = new JTextField();
		cajaSector.setBounds(120, 87, 200, 20);
		contentPane.add(cajaSector);
		cajaSector.setColumns(10);
		
		cajaCalles = new JTextField();
		cajaCalles.setBounds(120, 127, 200, 20);
		contentPane.add(cajaCalles);
		cajaCalles.setColumns(10);
		
		cajaNum = new JTextField();
		cajaNum.setBounds(120, 167, 200, 20);
		contentPane.add(cajaNum);
		cajaNum.setColumns(10);
		
		cajaRef = new JTextField();
		cajaRef.setBounds(120, 207, 200, 20);
		contentPane.add(cajaRef);
		cajaRef.setColumns(10);
		
//Botones
//=================================================================================================================
		
		botonRegresar = new JButton("<");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes llamarVentanaClientes = new VentanaClientes();
				llamarVentanaClientes.setVisible(true);	
				dispose();
			}
		});
		botonRegresar.setBounds(50, 250, 50, 23);
		contentPane.add(botonRegresar);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarDireccion(cajaCiudad.getText(), cajaSector.getText(), cajaCalles.getText(), cajaNum.getText(), cajaRef.getText());
				
				//JOptionPane.showMessageDialog(null, "Dirección guardada", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonGuardar.setBounds(135, 250, 80, 23);
		contentPane.add(botonGuardar);
		
		botonSiguiente = new JButton(">");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProductos llamarVentanaProductos = new VentanaProductos();
				llamarVentanaProductos.setVisible(true);	
				dispose();
			}
		});
		botonSiguiente.setBounds(250, 250, 50, 23);
		contentPane.add(botonSiguiente);
	}

}
