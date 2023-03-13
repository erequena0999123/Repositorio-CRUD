package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Ventana2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2() {
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton botonCerrarS = new JButton("Cerrar sesión");
		botonCerrarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana1 llamarVentana1 = new Ventana1();
				llamarVentana1.setVisible(true);
				dispose();
			}
		});
		botonCerrarS.setBounds(38, 192, 115, 23);
		contentPane.add(botonCerrarS);
		
		JButton botonNuevoR = new JButton("Nuevo Registro");
		botonNuevoR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes llamarVentanaClientes = new VentanaClientes();
				llamarVentanaClientes.setVisible(true);
				dispose();
			}
		});
		botonNuevoR.setBounds(187, 192, 126, 23);
		contentPane.add(botonNuevoR);
		
		JButton botonClientes = new JButton("Clientes");
		botonClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorClientes llamarVisorClientes = new VisorClientes();
				llamarVisorClientes.setVisible(true);
				dispose();
			}
		});
		botonClientes.setBounds(118, 40, 109, 23);
		contentPane.add(botonClientes);
		
		JButton botonServicios = new JButton("Servicios");
		botonServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorServicios llamarVisorServicios = new VisorServicios();
				llamarVisorServicios.setVisible(true);
				dispose();
			}
		});
		botonServicios.setBounds(118, 142, 109, 23);
		contentPane.add(botonServicios);
		
		JButton botonProductos = new JButton("Productos");
		botonProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorProductos llamarVisorProductos = new VisorProductos();
				llamarVisorProductos.setVisible(true);
				dispose();
			}
		});
		botonProductos.setBounds(118, 108, 109, 23);
		contentPane.add(botonProductos);
		
		JButton botonDirecciones = new JButton("Direcciones");
		botonDirecciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorDirecciones llamarVisorDirecciones = new VisorDirecciones();
				llamarVisorDirecciones.setVisible(true);
				dispose();
			}
		});
		botonDirecciones.setBounds(118, 74, 109, 23);
		contentPane.add(botonDirecciones);
		
		JLabel etiquetaTablas = new JLabel("Tablas disponibles");
		etiquetaTablas.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaTablas.setBounds(103, 11, 139, 18);
		contentPane.add(etiquetaTablas);
	}
}
