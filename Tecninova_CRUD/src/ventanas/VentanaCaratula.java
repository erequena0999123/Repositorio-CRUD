package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaCaratula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel etiquetaIcono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCaratula frame = new VentanaCaratula();
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
	public VentanaCaratula() {
		setTitle("Proyecto Integrador");
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 672);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		etiquetaIcono = new JLabel("");
		etiquetaIcono.setBackground(new Color(255, 255, 255));
		etiquetaIcono.setIcon(new ImageIcon("./logo.png"));
		etiquetaIcono.setBounds(30, 11, 96, 102);
		contentPane.add(etiquetaIcono);
		
		JLabel etiquetaCar01 = new JLabel("INSTITUTO SUPERIOR TECNOLÓGICO");
		etiquetaCar01.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		etiquetaCar01.setBounds(136, 28, 340, 22);
		contentPane.add(etiquetaCar01);
		
		JSeparator separator01 = new JSeparator();
		separator01.setForeground(new Color(0, 0, 0));
		separator01.setBounds(131, 48, 345, 2);
		contentPane.add(separator01);
		
		JLabel etiquetaCar02 = new JLabel("SUDAMERICANO");
		etiquetaCar02.setFont(new Font("Times New Roman", Font.BOLD, 40));
		etiquetaCar02.setBounds(136, 48, 337, 37);
		contentPane.add(etiquetaCar02);
		
		JSeparator separator02 = new JSeparator();
		separator02.setForeground(new Color(0, 0, 0));
		separator02.setBounds(136, 82, 345, 2);
		contentPane.add(separator02);
		
		JLabel etiquetaCar03 = new JLabel("QUITO-ECUADOR");
		etiquetaCar03.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		etiquetaCar03.setBounds(376, 83, 108, 22);
		contentPane.add(etiquetaCar03);
		
		JLabel etiquetaCar04 = new JLabel("ESCUELA DE");
		etiquetaCar04.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		etiquetaCar04.setBounds(242, 147, 129, 18);
		contentPane.add(etiquetaCar04);
		
		JLabel etiquetaCar05 = new JLabel("DESARROLLO DE SOFTWARE");
		etiquetaCar05.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar05.setBounds(161, 164, 296, 22);
		contentPane.add(etiquetaCar05);
		
		JLabel etiquetaCar06 = new JLabel("PROYECTO INTEGRADOR");
		etiquetaCar06.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		etiquetaCar06.setBounds(188, 214, 229, 14);
		contentPane.add(etiquetaCar06);
		
		JLabel etiquetaCar07 = new JLabel("PROGRAMACIÓN VISUAL 2");
		etiquetaCar07.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar07.setBounds(161, 227, 268, 22);
		contentPane.add(etiquetaCar07);
		
		JLabel etiquetaCar08 = new JLabel("DISEÑAR Y IMPLEMENTAR UN SISTEMA DE CONEXIÓN");
		etiquetaCar08.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar08.setBounds(30, 290, 548, 22);
		contentPane.add(etiquetaCar08);
		
		JLabel etiquetaCar09 = new JLabel("DE BASE DE DATOS CON JAVA MEDIANTE JDBC");
		etiquetaCar09.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar09.setBounds(61, 307, 470, 22);
		contentPane.add(etiquetaCar09);
		
		JLabel etiquetaCar10 = new JLabel("ALUMNOS:");
		etiquetaCar10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		etiquetaCar10.setBounds(30, 387, 96, 14);
		contentPane.add(etiquetaCar10);
		
		JLabel etiquetaCar11 = new JLabel("REQUENA EMMANUEL");
		etiquetaCar11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar11.setBounds(161, 386, 236, 16);
		contentPane.add(etiquetaCar11);
		
		JLabel etiquetaCar12 = new JLabel("SANDOVAL PILCA JAVIER MAURICIO");
		etiquetaCar12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar12.setBounds(160, 407, 371, 18);
		contentPane.add(etiquetaCar12);
		
		JLabel etiquetaCar13 = new JLabel("VINUEZA ERICK");
		etiquetaCar13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar13.setBounds(161, 428, 199, 18);
		contentPane.add(etiquetaCar13);
		
		JLabel etiquetaCar14 = new JLabel("TUTOR:");
		etiquetaCar14.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		etiquetaCar14.setBounds(30, 488, 96, 18);
		contentPane.add(etiquetaCar14);
		
		JLabel etiquetaCar15 = new JLabel("ING. MONCAYO GUIDO");
		etiquetaCar15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaCar15.setBounds(161, 488, 234, 18);
		contentPane.add(etiquetaCar15);
		
		JLabel etiquetaCar16 = new JLabel("MARZO 2023");
		etiquetaCar16.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		etiquetaCar16.setBounds(263, 563, 108, 14);
		contentPane.add(etiquetaCar16);
		
		JButton botonCar01 = new JButton("Continuar");
		botonCar01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana1 llamarVentana1 = new Ventana1();
				llamarVentana1.setVisible(true);
				dispose();
			}
		});
		botonCar01.setForeground(new Color(0, 0, 0));
		botonCar01.setBackground(new Color(32, 178, 170));
		botonCar01.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonCar01.setBounds(477, 587, 96, 23);
		contentPane.add(botonCar01);
		
		
	}
}
