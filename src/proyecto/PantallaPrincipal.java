package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 */

import java.awt.Color;

import java.awt.Font;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class PantallaPrincipal extends JFrame implements ActionListener{
	JButton Opciones;
	JButton MisAnuncios;
	JButton VentanaUsuario;
	JLabel logo;
	JLabel titulo;
	JLabel titulo2;
	JPanel panelLateral;
	JButton botonMenu;
	JButton botonMenu2;
	JButton botonInicio;
	JButton botonAnuncios;
	JButton botonVolver;
	
	
	JLabel label1;
	JLabel label2;
	
	JLabel textoBienvenida;
	
	JLabel textodeabajo;
	JLabel textodeabajo2;
	
	String nombreUsuario;
	int creditos;
	
	ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");
	
	/* 
	private static final String USER = "22_23_KIKOANUNCIOS";
	private static final String PWD = "1234";
	// Si est�is desde casa, la url ser� oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	Connection con = conectarBaseDatos();
	 */
	
	public PantallaPrincipal(String nombreUsuario, int creditos) {
		
		this.nombreUsuario = nombreUsuario;
		
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));
		
		Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 50);
		
		titulo = new JLabel("Bienvenido " + nombreUsuario);
		titulo.setFont(fuente3);
		titulo.setForeground(Color.black);
		titulo.setBounds(250, 75, 1000, 50);
		this.getContentPane().add(titulo);
		
		textoBienvenida = new JLabel("Esta es la aplicacion Book4You");
		textoBienvenida.setFont(fuente2);
		textoBienvenida.setForeground(Color.black);
		textoBienvenida.setBounds(250, 150, 1000, 50);
		this.getContentPane().add(textoBienvenida);
		
	    textodeabajo = new JLabel("Aqui podras gestionar tus reservas");
	    textodeabajo.setBounds(250, 200, 1200, 50);
	    textodeabajo.setFont(fuente2);
	    textodeabajo.setForeground(Color.black);
	    this.getContentPane().add(textodeabajo);
	    
		label1 = new JLabel("Tienes " + creditos + " creditos.");
		label1.setForeground(Color.BLACK);
		label1.setBounds(250, 50, 430, 50);
		label1.setVisible(true);
		this.add(label1);
		
		label2 = new JLabel(generoUsu());
		label2.setForeground(Color.BLACK);
		label2.setBounds(250, 70, 430, 50);
		label2.setVisible(false);
		this.add(label2);
		
		
		//IMATGE D'USUARI
		logo = new JLabel();
		logo.setIcon(new ImageIcon("Imagenes/Logo3.png"));
		logo.setBounds(280,200,500,500);
		this.add(logo);
		
		//CREACIO DEL MENU
	    Border bordeBoton = new LineBorder(Color.BLACK, 1);
	    botonMenu = new JButton();
		botonMenu.setBounds(15, 15, 60, 60);
		this.getContentPane().add(botonMenu);
		botonMenu.addActionListener(this);
		botonMenu.setContentAreaFilled(false);
		botonMenu.setIcon(menuM);
		botonMenu.setFont(fuente2);
		botonMenu.setBorderPainted(false);
		botonMenu.setFocusPainted(false);
		botonMenu.setOpaque(false);
		this.add(botonMenu);
		
		botonMenu2 = new JButton();
		botonMenu2.setBounds(15, 15, 60, 60);
		this.getContentPane().add(botonMenu2);
		botonMenu2.addActionListener(this);
		botonMenu2.setContentAreaFilled(false);
		botonMenu2.setIcon(menuM);
		botonMenu2.setBorderPainted(false);
		botonMenu2.setFocusPainted(false);
		botonMenu.setFont(fuente1);
		botonMenu2.setOpaque(false);
		this.add(botonMenu2);
	    
	    botonVolver = new JButton(icono);
	    botonVolver.setBounds(2, 575, 140, 60);
	    botonVolver.setBackground(new Color(242, 242, 242));
	    botonVolver.setFocusPainted(false);
	    botonVolver.setIcon(volver);
	    botonVolver.setOpaque(false);
	    botonVolver.setBorderPainted(false);
	    botonVolver.setVisible(true);
		botonVolver.addActionListener(this);
		this.getContentPane().add(botonVolver);
		

	    
	    botonInicio = new JButton("USUARIO");
	    botonInicio.setBounds(15, 80, 145, 45);
	    botonInicio.setFont(fuente1);
	    botonInicio.setBorder(bordeBoton);
	    botonInicio.addActionListener(this);
	    botonInicio.setVisible(false);
	    botonInicio.setBorder(new RoundedBorder(30)); 
	    botonInicio.setContentAreaFilled(false);
		this.add(botonInicio);
	    
	    botonAnuncios = new JButton("RESERVAS");
	    botonAnuncios.setBounds(15, 135, 145, 45);
	    botonAnuncios.setFont(fuente1);
	    botonAnuncios.setBorder(bordeBoton);
	    botonAnuncios.addActionListener(this);
	    botonAnuncios.setVisible(false);
	    botonAnuncios.setBorder(new RoundedBorder(30)); 
	    botonAnuncios.setContentAreaFilled(false);
		this.add(botonAnuncios);
	    
	  	panelLateral = new JPanel();
		panelLateral.setBounds(0, 0, 170, 661);
		panelLateral.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(0,128,43)));
		panelLateral.setBackground(new Color(173,235,173));
		this.getContentPane().add(panelLateral);
		panelLateral.setVisible(true);
	  	
	    this.setVisible(true);
		
	    		
	}
	
	/*
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
	 */
	
	public String nombreUsu() {
		
		String nombre = "";
		
		/*
		 * String seleccionNombre ="select nombreusuario from usuarios where DNI_CIF ='"+ nombreUsuario +"'";
		
		try{
			java.sql.Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(seleccionNombre);
			 while(rs.next()){ 
			 nombre = rs.getString(1);
			 }
		}catch(Exception ex) {
			System.out.println(ex);
		}
		 */
		String seleccionNombre ="select nombreusuario from usuarios where DNI_CIF ='"+ nombreUsuario +"'";
		
		return nombre;
	}
	
	public String generoUsu() {
		String genero = "";
		
		String seleccionGenero = "select g�nero from usuarios where DNI_CIF ='"+ nombreUsuario +"'";
		
		/*
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(seleccionGenero);
			
			while(rs.next()){ 
				 g�nero = rs.getString(1);
				 }

		}catch(Exception ex) {
			System.out.println(ex);
		}
		 */
	
		return genero;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonMenu) {
			botonMenu.setVisible(false);
			botonMenu2.setVisible(true);
			botonInicio.setVisible(true);
			botonAnuncios.setVisible(true);
			
		} else if (e.getSource() == botonVolver) {
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
			} else if(e.getSource() == botonMenu2) {
				botonMenu.setVisible(true);
				botonInicio.setVisible(false);
				botonAnuncios.setVisible(false);
			}
		
	}
}
