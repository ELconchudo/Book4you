package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	JButton botonUsuario;
	JButton botonReservas;
	JButton botonVolver;
	JButton botonComprar;

	JPanel comprar = new JPanel();
	JTextField monedasc = new JTextField(3);
	
	
	JLabel label1;
	JLabel label2;
	
	JLabel textoBienvenida;
	
	JLabel textodeabajo;
	JLabel textodeabajo2;
	
	String nombreUsuario;
	int creditos;
	String[] FullUsuario = new String[7];

	int monedat;
	
	ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");
	ImageIcon BlackCoin = new ImageIcon("Imagenes/BlackCoin.png");
	
	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	
	public PantallaPrincipal(String[] sqluser) {
		
		this.nombreUsuario = sqluser[2];
		this.creditos = Integer.parseInt(sqluser[6]);
		FullUsuario = sqluser;
		
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));
		
		//------------------------FUENTES-------------------------\\
		Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 50);
		Font fuente4 = new Font("Dialog", Font.BOLD, 32);
		Font fuente5 = new Font("Dialog", Font.BOLD, 15);
		
		titulo = new JLabel("Bienvenido " + nombreUsuario);
		titulo.setFont(fuente3);
		titulo.setForeground(Color.black);
		titulo.setBounds(250, 60, 1000, 80);
		this.getContentPane().add(titulo);
		
		textoBienvenida = new JLabel("Esta es la aplicacion Book4You");
		textoBienvenida.setFont(fuente2);
		textoBienvenida.setForeground(Color.black);
		textoBienvenida.setBounds(250, 135, 1000, 50);
		this.getContentPane().add(textoBienvenida);
		
	    textodeabajo = new JLabel("Aqui podras gestionar tus reservas");
	    textodeabajo.setBounds(250, 185, 1200, 50);
	    textodeabajo.setFont(fuente2);
	    textodeabajo.setForeground(Color.black);
	    this.getContentPane().add(textodeabajo);
	    
		//------------------CREDITOS USUARIO------------------\\
		label1 = new JLabel(creditos + "");
		label1.setForeground(Color.BLACK);
		label1.setFont(fuente4);
		label1.setBounds(950, 60, 50, 50);
		label1.setVisible(true);
		this.add(label1);

		logo = new JLabel();
		logo.setIcon(new ImageIcon("Imagenes/BlackCoin.png"));
		logo.setBounds(970,60,50,50);
		this.add(logo);

		//Boton Comprar
		botonComprar = new JButton();
		botonComprar.setBounds(925,120,100,25);
		botonComprar.setVisible(true);
		this.getContentPane().add(botonComprar);
		botonComprar.setText("Comprar");
		botonComprar.addActionListener(this);
		
		//--------------PANEL CREDITOS----------------\\
		comprar.add(new JLabel("Numero Tarjeta:"));
		comprar.add(new JTextField(16));
		comprar.add(new JLabel("Fecha:"));
		comprar.add(new JTextField(8));
		comprar.add(new JLabel("CCV:"));
		comprar.add(new JTextField(3));
		comprar.add(new JLabel("Monedas:"));
		comprar.add(monedasc);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon("Imagenes/Logo3.png"));
		logo.setBounds(280,200,500,500);
		this.add(logo);



		
		//---------------------MENU LATERAL------------------------\\
	    Border bordeBoton = new LineBorder(Color.BLACK, 1);
	    botonMenu = new JButton();
		botonMenu.setBounds(15, 15, 60, 60);
		this.getContentPane().add(botonMenu);
		botonMenu.addActionListener(this);
		botonMenu.setContentAreaFilled(false);
		botonMenu.setIcon(menuM);
		botonMenu.setFont(fuente5);
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
		botonMenu.setFont(fuente5);
		botonMenu2.setOpaque(false);
		this.add(botonMenu2);
	    
	    botonVolver = new JButton(volver);
	    botonVolver.setBounds(2, 575, 140, 60);
	    botonVolver.setBackground(new Color(242, 242, 242));
	    botonVolver.setFocusPainted(false);
	    botonVolver.setIcon(volver);
	    botonVolver.setOpaque(false);
	    botonVolver.setBorderPainted(false);
	    botonVolver.setVisible(true);
		botonVolver.addActionListener(this);
		this.getContentPane().add(botonVolver);
	    
	    botonUsuario = new JButton("USUARIO");
	    botonUsuario.setBounds(15, 80, 145, 45);
	    botonUsuario.setFont(fuente5);
	    botonUsuario.setBorder(bordeBoton);
	    botonUsuario.addActionListener(this);
	    botonUsuario.setVisible(false);
	    botonUsuario.setBorder(new RoundedBorder(30)); 
	    botonUsuario.setContentAreaFilled(false);
		this.add(botonUsuario);
	    
	    botonReservas = new JButton("RESERVAS");
	    botonReservas.setBounds(15, 135, 145, 45);
	    botonReservas.setFont(fuente5);
	    botonReservas.setBorder(bordeBoton);
	    botonReservas.addActionListener(this);
	    botonReservas.setVisible(false);
	    botonReservas.setBorder(new RoundedBorder(30)); 
	    botonReservas.setContentAreaFilled(false);
		this.add(botonReservas);
	    
	  	panelLateral = new JPanel();
		panelLateral.setBounds(0, 0, 170, 661);
		panelLateral.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(0,128,43)));
		panelLateral.setBackground(new Color(173,235,173));
		this.getContentPane().add(panelLateral);
		panelLateral.setVisible(true);
	  	
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
	
	public void addocoin() {

		Connection con = conectarBaseDatos();
		monedat = Integer.parseInt(FullUsuario[6]) + Integer.parseInt(monedasc.getText());
		FullUsuario[6] = Integer.toString(monedat);

		String sql = "UPDATE USUARIOS set CREDITOS = '"+ FullUsuario[6] +"'' where userid = '"+ FullUsuario[0] +"'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonMenu) {
			botonMenu.setVisible(false);
			botonMenu2.setVisible(true);
			botonUsuario.setVisible(true);
			botonReservas.setVisible(true);
			System.out.println(FullUsuario[2]);
			
		} else if (e.getSource() == botonVolver) {
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
		} else if(e.getSource() == botonMenu2) {
			botonMenu.setVisible(true);
			botonUsuario.setVisible(false);
			botonReservas.setVisible(false);
		} else if (e.getSource() == botonReservas) {
			MisReservas m = new MisReservas(FullUsuario);
			m.setVisible(true);
			this.dispose();
		}else if(e.getSource() == botonUsuario){
			PantallaUsuario m = new PantallaUsuario(FullUsuario);
			m.setVisible(true);
			this.dispose();
		} else if (e.getSource() == botonComprar) {
			int input = JOptionPane.showConfirmDialog(rootPane, comprar, "Comprar Monedas", JOptionPane.YES_NO_OPTION);
			if(input == 0) {
				addocoin();
			}
		}
		
	}
	
}
