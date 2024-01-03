package proyecto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JButton Login;
	JButton Registrarse;
	JLabel Titulo;
	JLabel Usuario;
	JLabel Contrasena;
	JTextField areaUsuario = new JTextField("");
	JTextField areaContrasena;
	
	ImageIcon Logo = new ImageIcon("Imagenes/Logo3.png");
	
	String nombreUsuario;
	int creditos;

	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	private String[] sqluser = new String[7];
	private String[] tsqluser = new String[7];
	
	public Login() {
		
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(173,235,173));
	
		Font font3 = new Font("Arial", Font.BOLD ,20);
		

		//LOGO EMPRESA
		Titulo = new JLabel(Logo);
		Titulo.setBounds(260,20,520,200);
		this.add(Titulo);
		Titulo.setVisible(true);
		
		//CAMPOS USUARIOS
		Usuario = new JLabel("Usuario");
		Font font1 = new Font("Dialog", Font.PLAIN ,20);
		Usuario.setFont(font3);
		Usuario.setBounds(410, 270, 110, 20);
		Usuario.setForeground(Color.BLACK);
		this.getContentPane().add(Usuario);
		
		areaUsuario.setFont(font1);
		areaUsuario.setBounds(550, 267, 120, 30);
		this.getContentPane().add(areaUsuario);
		
		//CAMPOS CONTRASENYA
		Contrasena = new JLabel("Contraseña");
		Contrasena.setFont(font3);
		Contrasena.setBounds(400, 354, 120, 20);
		this.getContentPane().add(Contrasena);
		Contrasena.setForeground(Color.BLACK);
		
		areaContrasena = new JPasswordField();
		areaContrasena.setBounds(550, 351, 120, 30);
		this.getContentPane().add(areaContrasena);
		areaContrasena.addActionListener(this);

		//BOTON LOGIN
		Login = new JButton("Login");
		Login.setBounds(400, 450, 113, 25);
		this.getContentPane().add(Login);
		Login.addActionListener(this);
		Login.setForeground(Color.BLACK);
		Login.setBackground(new Color(242, 242, 242));
		Login.setBorder(new RoundedBorder(22));
		
		//BOTON REGISTRO
		Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(560, 450, 113, 25);
		this.getContentPane().add(Registrarse);
		Registrarse.addActionListener(this);
		Registrarse.setForeground(Color.BLACK);
		Registrarse.setBackground(new Color(242, 242, 242));
		Registrarse.setBorder(new RoundedBorder(22));
		
		this.setVisible(true);
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

	private void ulogin(Connection con) {
		String sql = "SELECT u.* FROM USUARIOS u";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					tsqluser[0] = rs.getString("USERID");
					tsqluser[1] = rs.getString("DNI");
					tsqluser[2] = rs.getString("USUARIO");
					tsqluser[3] = rs.getString("CONTRASEÑA");
					tsqluser[4] = rs.getString("CORREO");
					tsqluser[5] = rs.getString("TELEFONO");
					tsqluser[6] = rs.getString("CREDITOS");
					if (areaUsuario.getText().equals(tsqluser[1]) && areaContrasena.getText().equals(tsqluser[3])) {
						sqluser[0] = rs.getString("USERID");
						sqluser[1] = rs.getString("DNI");
						sqluser[2] = rs.getString("USUARIO");
						sqluser[3] = rs.getString("CONTRASEÑA");
						sqluser[4] = rs.getString("CORREO");
						sqluser[5] = rs.getString("TELEFONO");
						sqluser[6] = rs.getString("CREDITOS");
						System.out.println("Habia un usuario");
						JOptionPane.showMessageDialog(null, "Bienvenido "+ sqluser[1]);
						this.setVisible(false);
						PantallaPrincipal pp = new PantallaPrincipal(sqluser);
					} else {
						System.out.println("No he encontrado nada");
					}
				}
			} else {
				System.out.println("No he encontrado nada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Registrarse) {
			Registro r = new Registro();
			this.setVisible(false);
		} else if (e.getSource() == Login) {
			Connection con = conectarBaseDatos();
			System.out.println(con);
			ulogin(con);
			
		}	
	}
}