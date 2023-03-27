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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaNombres;
	private JTextField cajaApellidos;
	private JTextField cajaTelefono;
	private JTextField cajaEmail;
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
					VentanaClientes frame = new VentanaClientes();
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
	public VentanaClientes() {
		
//Frame
//=================================================================================================================
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 305);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaCli01 = new JLabel("Ingrese los datos del cliente");
		etiquetaCli01.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCli01.setBounds(78, 11, 196, 14);
		contentPane.add(etiquetaCli01);
		
		JLabel etiquetaNombres = new JLabel("Nombres:");
		etiquetaNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaNombres.setBounds(38, 50, 71, 14);
		contentPane.add(etiquetaNombres);
		
		JLabel etiquetaApellidos = new JLabel("Apellidos:");
		etiquetaApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaApellidos.setBounds(38, 95, 71, 14);
		contentPane.add(etiquetaApellidos);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono:");
		etiquetaTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaTelefono.setBounds(38, 140, 71, 14);
		contentPane.add(etiquetaTelefono);
		
		JLabel etiquetaEmail = new JLabel("Email:");
		etiquetaEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaEmail.setBounds(38, 185, 62, 14);
		contentPane.add(etiquetaEmail);
		
//Cajas de texto
//=================================================================================================================
		
		cajaNombres = new JTextField();
		cajaNombres.setBounds(120, 47, 203, 20);
		contentPane.add(cajaNombres);
		cajaNombres.setColumns(10);
		
		cajaApellidos = new JTextField();
		cajaApellidos.setBounds(120, 92, 203, 20);
		contentPane.add(cajaApellidos);
		cajaApellidos.setColumns(10);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(120, 137, 203, 20);
		contentPane.add(cajaTelefono);
		cajaTelefono.setColumns(10);
		
		cajaEmail = new JTextField();
		cajaEmail.setBounds(120, 182, 203, 20);
		contentPane.add(cajaEmail);
		cajaEmail.setColumns(10);
		
//Botones
//=================================================================================================================
		
		botonRegresar = new JButton("<");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 llamarVentana2 = new Ventana2();
				llamarVentana2.setVisible(true);	
				dispose();
			}
		});
		
		
		botonRegresar.setBounds(50, 230, 50, 23);
		contentPane.add(botonRegresar);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarCliente(cajaNombres.getText(), cajaApellidos.getText() , cajaTelefono.getText() , cajaEmail.getText());
				
				//JOptionPane.showMessageDialog(null, "Cliente guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		botonGuardar.setBounds(135, 230, 80, 23);
		contentPane.add(botonGuardar);
		
		botonSiguiente = new JButton(">");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDirecciones llamarVentanaDirecciones = new VentanaDirecciones();
				llamarVentanaDirecciones.setVisible(true);	
				dispose();
			}
		});
		botonSiguiente.setBounds(250, 230, 50, 23);
		contentPane.add(botonSiguiente);
	}
}
