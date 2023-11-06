import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Registro extends JFrame implements ActionListener {
	
	JTextField textousuario = new JTextField("");
	JTextField textocontrasena;
	JTextField textocorreo = new JTextField("");
	JTextField textotelefono = new JTextField("");
	JTextField textoCIF = new JTextField("");
	JTextField textodireccion = new JTextField("");
	JTextField textoNumeroCuenta = new JTextField("");
	JTextField textoClaveAcceso = new JTextField("");
	JTextField textocontrasena2;
	
	
	String [] MetodoDePago = {"Tarjeta", "Paypal"};
	JComboBox ListaMetodo = new JComboBox (MetodoDePago);
	
	String [] Generos = {"Hombre", "Mujer"};
	JComboBox ListaGeneros = new JComboBox (Generos);

	
	JLabel usuario;
	JLabel contrasena;
	JLabel contrasena2;
	JLabel repetir;
	JLabel tituloregistro;
	JLabel correo;
	JLabel telefono;
	JLabel CIF;
	JLabel direccion;
	JLabel metodo;
	JLabel numeroCuenta;
	JLabel ClaveAcceso;
	JLabel genero;
	JButton Registrarse;
	JButton Volver;
	
	
	
	JLabel avisoNombre = new JLabel();
	JLabel avisoContrasena = new JLabel();
	JLabel avisoRepetir = new JLabel();
	JLabel avisoCorreo = new JLabel();
	
	private static final String USER = "22_23_KIKOANUNCIOS";
	private static final String PWD = "1234";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	
	
	
	
	public Registro () {
	
		this.setBounds(600, 220, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242, 242, 242));
		
		
		tituloregistro = new JLabel("Inserte sus datos para registrarse");
		Font font = new Font("Dialog", Font.BOLD ,22);
		tituloregistro.setFont(font);
		tituloregistro.setBounds(300, 30, 480, 30);
		tituloregistro.setForeground(Color.BLACK);
		this.getContentPane().add(tituloregistro);
		
		
		usuario = new JLabel("Nombre de usuario");
		Font font1 = new Font("Dialog", Font.PLAIN ,16);
		Font font3 = new Font("Dialog", Font.PLAIN ,12);
		usuario.setFont(font1);
		usuario.setBounds(270, 100, 199, 20);
		usuario.setForeground(Color.BLACK);
		this.getContentPane().add(usuario);
		
		
		
		
		
		
		
		avisoNombre.setFont(font1);
		avisoNombre.setBounds(730, 100, 199, 20);
		avisoNombre.setForeground(Color.RED);
		this.getContentPane().add(avisoNombre);
		
		
		avisoContrasena.setFont(font1);
		avisoContrasena.setBounds(730, 150, 199, 20);
		avisoContrasena.setForeground(Color.RED);
		this.getContentPane().add(avisoContrasena);
		
		avisoRepetir.setFont(font1);
		avisoRepetir.setBounds(730, 200, 199, 20);
		avisoRepetir.setForeground(Color.RED);
		this.getContentPane().add(avisoRepetir);
		
		avisoCorreo.setFont(font1);
		avisoCorreo.setBounds(730, 250, 199, 20);
		avisoCorreo.setForeground(Color.RED);
		this.getContentPane().add(avisoCorreo);	
		
		textousuario.setFont(font3);
		textousuario.setBounds(562, 100, 141, 20);
		this.getContentPane().add(textousuario);
		
		contrasena = new JLabel("Contrasena");
		contrasena.setFont(font1);
		contrasena.setBounds(270, 150, 120, 20);
		this.getContentPane().add(contrasena);
		contrasena.setForeground(Color.BLACK);
		
		textocontrasena = new JPasswordField();
		textocontrasena.setBounds(562, 150, 141, 20);
		this.getContentPane().add(textocontrasena);
		textocontrasena.addActionListener(this);
		
		contrasena2 = new JLabel("Repetir contrasena");
		contrasena2.setFont(font1);
		contrasena2.setBounds(270, 200, 180, 20);
		this.getContentPane().add(contrasena2);
		contrasena2.setForeground(Color.BLACK);
		
		textocontrasena2 = new JPasswordField();
		textocontrasena2.setBounds(562, 200, 141, 20);
		this.getContentPane().add(textocontrasena2);
		textocontrasena2.addActionListener(this);
		
		
		Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(565, 600, 113, 25);
		this.getContentPane().add(Registrarse);
		Registrarse.addActionListener(this);
		Registrarse.setBorder(new RoundedBorder(22));
		Registrarse.setForeground(Color.BLACK);
		Registrarse.setBackground(new Color(242, 242, 242));
		
		Volver = new JButton("Volver");
		Volver.setBounds(320, 600, 113, 25);
		this.getContentPane().add(Volver);
		Volver.addActionListener(this);
		Volver.setForeground(Color.BLACK);
		Volver.setBackground(new Color(242, 242, 242));
		Volver.setBorder(new RoundedBorder(22));
		
		correo = new JLabel("Correo electronico");
		correo.setFont(font1);
		correo.setBounds(270, 250, 199, 20);
		this.getContentPane().add(correo);
		correo.setForeground(Color.BLACK);
		
		
		textocorreo.setFont(font3);
		textocorreo.setBounds(562, 250, 141, 20);
		this.getContentPane().add(textocorreo);
		
		telefono = new JLabel("Telefono");
		telefono.setFont(font1);
		telefono.setBounds(270, 300, 120, 20);
		this.getContentPane().add(telefono);
		telefono.setForeground(Color.BLACK);
		
		textotelefono.setFont(font3);
		textotelefono.setBounds(562, 300, 141, 20);
		this.getContentPane().add(textotelefono);
		
		CIF = new JLabel("CIF/DNI");
		CIF.setFont(font1);
		CIF.setBounds(270, 350, 150, 20);
		this.getContentPane().add(CIF);
		CIF.setForeground(Color.BLACK);
		
		textoCIF.setFont(font3);
		textoCIF.setBounds(562, 350, 141, 20);
		this.getContentPane().add(textoCIF);
		
		direccion = new JLabel("Direccion residencial");
		direccion.setFont(font1);
		direccion.setBounds(270, 400, 180, 20);
		this.getContentPane().add(direccion);
		direccion.setForeground(Color.BLACK);
		
		textodireccion.setFont(font3);
		textodireccion.setBounds(562, 400, 141, 20);
		this.getContentPane().add(textodireccion);
		
		metodo = new JLabel("Metodo de pago");
		metodo.setFont(font1);
		metodo.setBounds(270, 450, 180, 20);
		this.getContentPane().add(metodo);
		metodo.setForeground(Color.BLACK);
		
		ListaMetodo.setFont(font3);
		ListaMetodo.setBounds(562, 450, 141, 20);
		this.getContentPane().add(ListaMetodo);
		
		genero = new JLabel("Genero");
		genero.setFont(font1);
		genero.setBounds(270, 500, 180, 20);
		this.getContentPane().add(genero);
		genero.setForeground(Color.BLACK);
		
		
		ListaGeneros.setFont(font3);
		ListaGeneros.setBounds(562, 500, 141, 20);
		this.getContentPane().add(ListaGeneros);
		
		this.setVisible(true);
		
	}

	
	
	
	public void comprobarCampos() {
		
		if(textousuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es obligatorio");
		} else if (textocontrasena.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "La contrasena es obligatoria");
		}else if(textocontrasena2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Repetir la contrasena es obligatorio");
		} else if(textocorreo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El correo electronico es obligatorio");
		} else if(textotelefono.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El numero de telefono es obligatorio");
		} else if (textoCIF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El CIF/DNI es obligatorio");
		} else if (textodireccion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La direccion residencial es obligatoria");
		} else {
		Registrarse.setEnabled(true);
			
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
