//package proyecto;

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
	JButton Registrarse;
	JButton Volver;
	
	
	
	JLabel avisoNombre = new JLabel();
	JLabel avisoContrasena = new JLabel();
	JLabel avisoRepetir = new JLabel();
	JLabel avisoCorreo = new JLabel();
	
	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	
	
	public Registro () {
	
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(230, 255, 230));
		
		Font font1 = new Font("Dialog", Font.BOLD ,28);
		Font font2 = new Font("Dialog", Font.BOLD ,16);
		Font font3 = new Font("Dialog", Font.PLAIN ,12);
		
		//TITULO REGISTRO
		tituloregistro = new JLabel("Inserte sus datos para registrarse");
		Font font = new Font("Dialog", Font.BOLD ,22);
		tituloregistro.setFont(font1);
		tituloregistro.setBounds(300, 100, 480, 30);
		tituloregistro.setForeground(Color.BLACK);
		this.getContentPane().add(tituloregistro);		

		
		//USUARIO
		usuario = new JLabel("Nombre de usuario");
		usuario.setFont(font2);
		usuario.setBounds(320, 175, 199, 20);
		usuario.setForeground(Color.BLACK);
		this.getContentPane().add(usuario);
		
		textousuario.setFont(font3);
		textousuario.setBounds(562, 175, 141, 20);
		this.getContentPane().add(textousuario);
		
		avisoNombre.setFont(font2);
		avisoNombre.setBounds(730, 175, 199, 20);
		avisoNombre.setForeground(Color.RED);
		this.getContentPane().add(avisoNombre);
		
		
		//CAMPO CONTRASENA
		contrasena = new JLabel("Contrasena");
		contrasena.setFont(font2);
		contrasena.setBounds(320, 225, 120, 20);
		this.getContentPane().add(contrasena);
		contrasena.setForeground(Color.BLACK);
		
		textocontrasena = new JPasswordField();
		textocontrasena.setBounds(562, 225, 141, 20);
		this.getContentPane().add(textocontrasena);
		textocontrasena.addActionListener(this);
		
		avisoContrasena.setFont(font2);
		avisoContrasena.setBounds(730, 225, 199, 20);
		avisoContrasena.setForeground(Color.RED);
		this.getContentPane().add(avisoContrasena);
		
		
		//CAMPO REPETIR CONTRASENA
		contrasena2 = new JLabel("Repetir contrasena");
		contrasena2.setFont(font2);
		contrasena2.setBounds(320, 275, 180, 20);
		this.getContentPane().add(contrasena2);
		contrasena2.setForeground(Color.BLACK);
		
		textocontrasena2 = new JPasswordField();
		textocontrasena2.setBounds(562, 275, 141, 20);
		this.getContentPane().add(textocontrasena2);
		textocontrasena2.addActionListener(this);
	
		avisoRepetir.setFont(font2);
		avisoRepetir.setBounds(730, 275, 199, 20);
		avisoRepetir.setForeground(Color.RED);
		this.getContentPane().add(avisoRepetir);
		
		
		//CAMPOS CORREO
		correo = new JLabel("Correo electronico");
		correo.setFont(font2);
		correo.setBounds(320, 325, 199, 20);
		this.getContentPane().add(correo);
		correo.setForeground(Color.BLACK);
		
		textocorreo.setFont(font3);
		textocorreo.setBounds(562, 325, 141, 20);
		this.getContentPane().add(textocorreo);
		
		avisoCorreo.setFont(font2);
		avisoCorreo.setBounds(730, 325, 199, 20);
		avisoCorreo.setForeground(Color.RED);
		this.getContentPane().add(avisoCorreo);
		
		
		//CAMPOS TELEFONO
		telefono = new JLabel("Telefono");
		telefono.setFont(font2);
		telefono.setBounds(320, 375, 120, 20);
		this.getContentPane().add(telefono);
		telefono.setForeground(Color.BLACK);
		
		textotelefono.setFont(font3);
		textotelefono.setBounds(562, 375, 141, 20);
		this.getContentPane().add(textotelefono);
		
		//CAMPOS DNI
		CIF = new JLabel("CIF/DNI");
		CIF.setFont(font2);
		CIF.setBounds(320, 425, 150, 20);
		this.getContentPane().add(CIF);
		CIF.setForeground(Color.BLACK);
		
		textoCIF.setFont(font3);
		textoCIF.setBounds(562, 425, 141, 20);
		this.getContentPane().add(textoCIF);
		
		
		//BOTON REGISTRARSE
		Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(535, 500, 113, 25);
		this.getContentPane().add(Registrarse);
		Registrarse.addActionListener(this);
		Registrarse.setBorder(new RoundedBorder(22));
		Registrarse.setForeground(Color.BLACK);
		Registrarse.setBackground(new Color(242, 242, 242));
		
		//BOTON VOLVER
		Volver = new JButton("Volver");
		Volver.setBounds(375, 500, 113, 25);
		this.getContentPane().add(Volver);
		Volver.addActionListener(this);
		Volver.setForeground(Color.BLACK);
		Volver.setBackground(new Color(242, 242, 242));
		Volver.setBorder(new RoundedBorder(22));
		
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
		} 
		Registrarse.setEnabled(true);
			
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
		}

	private static Connection conectarBaseDatos() {
        Connection con = null;
        System.out.println("Intentando conectarse a la base de datos");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver " + e);
        } catch (SQLException e) {
            System.out.println("Error en las credenciales o en la URL " + e);
        }
        System.out.println("Conectados a la base de datos");
        return con;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Registrarse) {
			String sql = "INSERT INTO USUARIOS(DNI, USUARIO, CONTRASEÑA, CORREO, TELEFONO, CREDITOS)" + 
			"VALUES('"+ textoCIF.getText() +"', '"+textousuario.getText()+"', '"+ textocontrasena.getText() +"','"+ textocorreo.getText() +"', '"+ textotelefono.getText() +"')";
			try {
				java.sql.Statement st = con.createStatement();
				st.execute(sql);

				JOptionPane.showMessageDialog(null, "Registrado");
				System.out.println("Persona registrada correctamente");
			} catch (Exception e) {
				// TODO: handle exception
			}			
			// TODO Auto-generated method stub
		}
		
	}
}
	
