package proyecto;

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
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalir.setBounds(54, 192, 101, 23);
		contentPane.add(botonSalir);
		
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
		botonClientes.setBounds(118, 56, 109, 23);
		contentPane.add(botonClientes);
		
		JButton botonServicios = new JButton("Servicios");
		botonServicios.setBounds(118, 158, 109, 23);
		contentPane.add(botonServicios);
		
		JButton botonProductos = new JButton("Productos");
		botonProductos.setBounds(118, 124, 109, 23);
		contentPane.add(botonProductos);
		
		JButton botonDirecciones = new JButton("Direcciones");
		botonDirecciones.setBounds(118, 90, 109, 23);
		contentPane.add(botonDirecciones);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.background"));
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 63, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cambio de clave");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nueva tabla");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel etiquetaTablas = new JLabel("Tablas disponibles");
		etiquetaTablas.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaTablas.setBounds(103, 27, 139, 18);
		contentPane.add(etiquetaTablas);
	}
}
