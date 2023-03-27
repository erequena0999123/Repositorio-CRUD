package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import paquete_conexion_Postgresql.CRUD_Postgresql;

public class VentanaServicios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaFecha;
	private JTextField cajaServicio;
	private JTextField cajaRepuestos;
	private JTextField cajaGarantia;
	private JTextField cajaGF;
	private JButton botonRegresar;
	private JButton botonFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaServicios frame = new VentanaServicios();
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
	public VentanaServicios() {
		setTitle("Servicios");
		
//Frame
//=================================================================================================================
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
		
		JLabel etiquetaServ01 = new JLabel("Ingrese el servicio realizado");
		etiquetaServ01.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaServ01.setBounds(81, 11, 208, 14);
		contentPane.add(etiquetaServ01);
		
		JLabel etiquetaFecha = new JLabel("Fecha:");
		etiquetaFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaFecha.setBounds(38, 50, 46, 14);
		contentPane.add(etiquetaFecha);
		
		JLabel etiquetaServicio = new JLabel("Servicio:");
		etiquetaServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaServicio.setBounds(38, 90, 46, 14);
		contentPane.add(etiquetaServicio);
		
		JLabel etiquetaRepuestos = new JLabel("Repuestos:");
		etiquetaRepuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaRepuestos.setBounds(38, 130, 82, 14);
		contentPane.add(etiquetaRepuestos);
		
		JLabel etiquetaGarantia = new JLabel("Meses Garantía:");
		etiquetaGarantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaGarantia.setBounds(38, 170, 95, 14);
		contentPane.add(etiquetaGarantia);
		
		JLabel etiquetaGF = new JLabel("G/F:");
		etiquetaGF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etiquetaGF.setBounds(38, 210, 68, 14);
		contentPane.add(etiquetaGF);
		
//Cajas de texto
//=================================================================================================================
		
		cajaFecha = new JTextField();
		cajaFecha.setBounds(130, 47, 190, 20);
		contentPane.add(cajaFecha);
		cajaFecha.setColumns(10);
		
		cajaServicio = new JTextField();
		cajaServicio.setBounds(130, 87, 190, 20);
		contentPane.add(cajaServicio);
		cajaServicio.setColumns(10);
		
		cajaRepuestos = new JTextField();
		cajaRepuestos.setBounds(130, 127, 190, 20);
		contentPane.add(cajaRepuestos);
		cajaRepuestos.setColumns(10);
		
		cajaGarantia = new JTextField();
		cajaGarantia.setBounds(130, 168, 190, 20);
		contentPane.add(cajaGarantia);
		cajaGarantia.setColumns(10);
		
		cajaGF = new JTextField();
		cajaGF.setBounds(129, 207, 190, 20);
		contentPane.add(cajaGF);
		cajaGF.setColumns(10);
		
//Botones
//=================================================================================================================
		
		botonRegresar = new JButton("<");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProductos llamarVentanaProductos = new VentanaProductos();
				llamarVentanaProductos.setVisible(true);	
				dispose();
			}
		});
		botonRegresar.setBounds(93, 250, 50, 23);
		contentPane.add(botonRegresar);
		
		botonFinalizar = new JButton("Finalizar");
		botonFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 llamarVentana2 = new Ventana2();
				llamarVentana2.setVisible(true);
				dispose();
				
				
				CRUD_Postgresql CRUD = new CRUD_Postgresql();
				CRUD.insertarServicio(cajaFecha.getText(), cajaServicio.getText(), cajaRepuestos.getText(), cajaGarantia.getText(), cajaGF.getText());
				
				//JOptionPane.showMessageDialog(null, "Registro exitoso", "Info", JOptionPane.INFORMATION_MESSAGE
				dispose();
			}
		});
		botonFinalizar.setBounds(185, 250, 87, 23);
		contentPane.add(botonFinalizar);
	}

}
