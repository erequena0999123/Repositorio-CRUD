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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		setBackground(new Color(32, 178, 170));
		setTitle("Menú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 351);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton botonCerrarS = new JButton("Cerrar sesión");
		botonCerrarS.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCerrarS.setForeground(new Color(0, 102, 255));
		botonCerrarS.setBackground(new Color(255, 255, 0));
		botonCerrarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana1 llamarVentana1 = new Ventana1();
				llamarVentana1.setVisible(true);
				dispose();
			}
		});
		botonCerrarS.setBounds(10, 255, 125, 48);
		contentPane.add(botonCerrarS);
		
		/*
		JButton botonNuevoR = new JButton("Nuevo Registro");
		botonNuevoR.setForeground(new Color(0, 102, 255));
		botonNuevoR.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonNuevoR.setBackground(new Color(255, 255, 0));
		botonNuevoR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaClientes llamarVentanaClientes = new VentanaClientes();
				llamarVentanaClientes.setVisible(true);
				dispose();
			}
		});
		botonNuevoR.setBounds(10, 175, 125, 48);
		contentPane.add(botonNuevoR);
		*/
		
		JButton botonResumen = new JButton("Tabla Master");
		botonResumen.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonResumen.setForeground(new Color(0, 102, 255));
		botonResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaResumen llamarVentanaResumen = new VentanaResumen();
				llamarVentanaResumen.setVisible(true);
				dispose();
			}
		});
		botonResumen.setBackground(new Color(255, 255, 0));
		botonResumen.setBounds(10, 100, 125, 48);
		contentPane.add(botonResumen);
		
		JPanel panel01 = new JPanel();
		panel01.setBackground(new Color(0, 102, 255));
		panel01.setBounds(168, 100, 177, 210);
		contentPane.add(panel01);
		panel01.setLayout(null);
		
		JLabel etiquetaTablas = new JLabel("Tablas disponibles");
		etiquetaTablas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTablas.setBounds(25, 11, 139, 18);
		panel01.add(etiquetaTablas);
		etiquetaTablas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton botonProductos = new JButton("Productos");
		botonProductos.setBounds(40, 124, 102, 31);
		panel01.add(botonProductos);
		botonProductos.setBackground(new Color(255, 255, 0));
		
		JButton botonServicios = new JButton("Servicios");
		botonServicios.setBounds(40, 166, 102, 31);
		panel01.add(botonServicios);
		botonServicios.setBackground(new Color(255, 255, 0));
		
		JButton botonClientes = new JButton("Clientes");
		botonClientes.setBounds(40, 40, 102, 31);
		panel01.add(botonClientes);
		botonClientes.setBackground(new Color(255, 255, 0));
		
		JButton botonDirecciones = new JButton("Direcciones");
		botonDirecciones.setBounds(40, 82, 102, 31);
		panel01.add(botonDirecciones);
		botonDirecciones.setBackground(new Color(255, 255, 0));
		botonDirecciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorDirecciones llamarVisorDirecciones = new VisorDirecciones();
				llamarVisorDirecciones.setVisible(true);
				dispose();
			}
		});
		botonClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorClientes llamarVisorClientes = new VisorClientes();
				llamarVisorClientes.setVisible(true);
				dispose();
			}
		});
		
		JLabel etiquelaLogo = new JLabel("");
		etiquelaLogo.setIcon(new ImageIcon(Ventana2.class.getResource("/Imagenes/logoTec.jpg")));
		etiquelaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquelaLogo.setBounds(62, 11, 224, 69);
		contentPane.add(etiquelaLogo);
		botonServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorServicios llamarVisorServicios = new VisorServicios();
				llamarVisorServicios.setVisible(true);
				dispose();
			}
		});
		botonProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisorProductos llamarVisorProductos = new VisorProductos();
				llamarVisorProductos.setVisible(true);
				dispose();
			}
		});
	}
}
