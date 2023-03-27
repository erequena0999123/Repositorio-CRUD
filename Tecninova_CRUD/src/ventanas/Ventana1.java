package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaUsuario;
	private JPasswordField cajaContras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
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
	public Ventana1() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 201);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
//Etiquetas
//=================================================================================================================
		
		JLabel etiquetaLog01 = new JLabel("Usuario");
		etiquetaLog01.setBounds(69, 34, 60, 14);
		contentPane.add(etiquetaLog01);
		
		JLabel etiquetaLog02 = new JLabel("Contraseña");
		etiquetaLog02.setBounds(69, 65, 74, 14);
		contentPane.add(etiquetaLog02);
		
//Cajas de texto
//=================================================================================================================
		
		cajaUsuario = new JTextField();
		cajaUsuario.setBounds(150, 31, 86, 20);
		contentPane.add(cajaUsuario);
		cajaUsuario.setColumns(10);
		
		cajaContras = new JPasswordField();
		cajaContras.setBounds(150, 59, 86, 20);
		contentPane.add(cajaContras);
		
//Botones
//=================================================================================================================
		
		JButton boton01 = new JButton("Ingresar");
		boton01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "Grupo1";
				String contrasena = "intesud";
				
				char[] clave = cajaContras.getPassword();
				String claveFinal = new String(clave);
				if(cajaUsuario.getText().equals(usuario)&& claveFinal.equals(contrasena)) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
					Ventana2 llamarVentana2 = new Ventana2();
					llamarVentana2.setVisible(true);				
				}
				else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos", "Ocurrió un error", JOptionPane.ERROR_MESSAGE);
					cajaUsuario.setText("");
					cajaContras.setText("");
				}
			}
		});
		boton01.setBounds(69, 114, 89, 23); 
		contentPane.add(boton01);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalir.setBounds(190, 114, 89, 23);
		contentPane.add(botonSalir);
	}
}
