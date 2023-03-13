package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class VisorClientes extends JFrame {

	private JPanel contentPane;
	private JTable tablaClientes;
	private JTextField cajaNombres;
	private JTextField cajaApellidos;
	private JTextField cajaTelefono;
	private JTextField cajaEmail;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		scrollPane.setBounds(0, 40, 575, 300);
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
		
		JLabel etiquetaNombre = new JLabel("Nombres");
		etiquetaNombre.setBounds(600, 40, 77, 14);
		contentPane.add(etiquetaNombre);
		
		JLabel etiquetaApellidos = new JLabel("Apellidos");
		etiquetaApellidos.setBounds(600, 90, 77, 14);
		contentPane.add(etiquetaApellidos);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setBounds(600, 140, 77, 14);
		contentPane.add(etiquetaTelefono);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setBounds(600, 190, 46, 14);
		contentPane.add(etiquetaEmail);
		
		cajaNombres = new JTextField();
		cajaNombres.setBounds(600, 55, 150, 20);
		contentPane.add(cajaNombres);
		cajaNombres.setColumns(10);
		
		cajaApellidos = new JTextField();
		cajaApellidos.setBounds(600, 105, 150, 20);
		contentPane.add(cajaApellidos);
		cajaApellidos.setColumns(10);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(600, 155, 150, 20);
		contentPane.add(cajaTelefono);
		cajaTelefono.setColumns(10);
		
		cajaEmail = new JTextField();
		cajaEmail.setBounds(600, 205, 155, 20);
		contentPane.add(cajaEmail);
		cajaEmail.setColumns(10);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(124, 252, 0));
		botonActualizar.setBounds(585, 310, 92, 23);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 0, 51));
		botonEliminar.setBounds(685, 310, 89, 23);
		contentPane.add(botonEliminar);
		
		
	}
}
