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
/*
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PantallaUsuario extends JFrame implements ActionListener {

	boolean estaEditando = true;
	JLabel titulo;
	JLabel label1;
	JPanel panelLateral;
	JButton botonMenu;
	JButton botonMenu2;
	JButton botonUsuario;
	JButton botonReservas;
	JButton botonVolver;
    String DNICIF;
    JLabel cif;
    JLabel Texto;
	JLabel Texto2;
	JLabel Texto3;
	JLabel Texto4;
	JLabel Texto5;
	JLabel Texto6;
    JLabel Usuario;
    JButton botonEditar;
	JButton botonGuardar;
	JTextField correoEditar;
	JTextField telefonoEditar;
	JTextField nombreEditar;
	JTextField contraseñaEditar;
	String nombreUsuario;
	int creditos;
	String[] FullUsuario = new String[7];

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

    public PantallaUsuario(String[] sqluser) {

        Font fuente1 = new Font("Dialog", Font.BOLD, 16);
		Font fuente2 = new Font("Dialog", Font.BOLD, 15);
        Font fuente3 = new Font("Dialog", Font.BOLD, 20);
		Font fuente4 = new Font("Dialog", Font.BOLD, 50);
        Font fuente5 = new Font("Dialog", Font.BOLD, 18);

		FullUsuario = sqluser;

		this.creditos = Integer.parseInt(sqluser[6]);

        this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));
		
        //---------------------LABELS-----------------------//
        titulo = new JLabel("Perfil de usuario");
		titulo.setFont(fuente4);
		titulo.setForeground(Color.black);
		titulo.setBounds(440, 125, 1000, 60);
		this.getContentPane().add(titulo);
		
		
		Texto = new JLabel("DNI: ");
		Texto.setFont (fuente1) ;
		Texto.setBounds(555,215,300,20);
		this.add(Texto);
		
		Texto2 = new JLabel("Usuario: " );
		Texto2.setFont (fuente1) ;
		Texto2.setBounds(525,265,300,20);
		this.add(Texto2);

		Texto3 = new JLabel("Contraseña: " );
		Texto3.setFont (fuente1) ;
		Texto3.setBounds(496,315,300,20);
		this.add(Texto3);
		
		Texto4 = new JLabel("Email: " );
		Texto4.setFont (fuente1) ;
		Texto4.setBounds(542,365,300,20);
		this.add(Texto4);
		
		Texto5 = new JLabel("Telefono: " );
		Texto5.setFont (fuente1) ;
		Texto5.setBounds(515,415,300,20);
		this.add(Texto5);


        Border bordeBoton = new LineBorder(Color.BLACK, 3);

        //--------------------BOTON EDITAR PERFIL------------------\\
		botonEditar = new JButton("Editar perfil");
		botonEditar.setFont(fuente2);
		botonEditar.setBounds(540, 465, 150, 45);
	    botonEditar.setBorder(bordeBoton);
	    botonEditar.addActionListener(this);
	    botonEditar.setContentAreaFilled(false);
	    botonEditar.setBorder(new RoundedBorder(30)); 
	    this.add(botonEditar);
	    
	    botonGuardar = new JButton("Guardar");
	    botonGuardar.setFont(fuente2);
	    botonGuardar.setBounds(540, 465, 150, 45);
	    botonGuardar.setBorder(bordeBoton);
	    botonGuardar.addActionListener(this);
	    botonGuardar.setVisible(false);
	    botonGuardar.setBorder(new RoundedBorder(30)); 
	    botonGuardar.setContentAreaFilled(false);
	    this.add(botonGuardar);

        //-----------------DATOS DEL USUARIO---------------\\
        cif = new JLabel(FullUsuario[1]);
	    cif.setFont (fuente5) ;
	    cif.setBounds(600, 209, 150, 30);
		this.add(cif);

        nombreEditar = new JTextField(FullUsuario[2]);
	    nombreEditar.setBounds(600, 260, 150, 30);
	    nombreEditar.setEditable(false);
	    nombreEditar.setVisible(true);
	    this.add(nombreEditar);
	    nombreEditar.getText();

		contraseñaEditar = new JTextField(FullUsuario[3]);
	    contraseñaEditar.setBounds(600, 310, 150, 30);
	    contraseñaEditar.setEditable(false);
	    contraseñaEditar.setVisible(true);
	    this.add(contraseñaEditar);
	    contraseñaEditar.getText();
	    
	    correoEditar = new JTextField(FullUsuario[4]);
	    correoEditar.setBounds(600, 360, 150, 30);
	    correoEditar.setEditable(false);
	    correoEditar.setVisible(true);
	    this.add(correoEditar);
	    correoEditar.getText();
	    
	    telefonoEditar = new JTextField(FullUsuario[5]);
	    telefonoEditar.setBounds(600, 410, 150, 30);
	    telefonoEditar.setEditable(false);
	    telefonoEditar.setVisible(true);
	    this.add(telefonoEditar);
	    telefonoEditar.getText();
       

		//----------------------MENU LATERAL-------------------------\\
        Border borderBoton = new LineBorder(Color.BLACK, 1);
	    botonMenu = new JButton();
		botonMenu.setBounds(15, 15, 60, 60);
		this.getContentPane().add(botonMenu);
		botonMenu.addActionListener(this);
		botonMenu.setContentAreaFilled(false);
		botonMenu.setIcon(menuM);
		botonMenu.setFont(fuente3);
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
		botonMenu.setFont(fuente3);
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
	    
	    botonUsuario = new JButton("USUARIO");
	    botonUsuario.setBounds(15, 80, 145, 45);
	    botonUsuario.setFont(fuente2);
	    botonUsuario.setBorder(bordeBoton);
	    botonUsuario.addActionListener(this);
	    botonUsuario.setVisible(false);
	    botonUsuario.setBorder(new RoundedBorder(30)); 
	    botonUsuario.setContentAreaFilled(false);
		this.add(botonUsuario);
	    
	    botonReservas = new JButton("RESERVAS");
	    botonReservas.setBounds(15, 135, 145, 45);
	    botonReservas.setFont(fuente2);
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



	//-------------------CONEXIÓN BASE DE DATO-------------------\\  
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
		if(e.getSource() == botonEditar) {
			botonGuardar.setVisible(true);
			botonEditar.setVisible(false);
			correoEditar.setEditable(estaEditando);
			telefonoEditar.setEditable(estaEditando);
			contraseñaEditar.setEditable(estaEditando);
			nombreEditar.setEditable(estaEditando);
			botonMenu.setVisible(false);	
		}

		if(e.getSource() == botonGuardar) {
			botonGuardar.setVisible(false);
			botonEditar.setVisible(true);
			correoEditar.setEditable(false);
			telefonoEditar.setEditable(false);
			contraseñaEditar.setEditable(false);
			nombreEditar.setEditable(false);
			botonMenu.setVisible(true);
			
			
			String correo = correoEditar.getText();
			String telefono = telefonoEditar.getText();
			String nombre = nombreEditar.getText();
			String contraseña = contraseñaEditar.getText();
			String dni = cif.getText();
			
			
			try {
				Connection con = conectarBaseDatos();
				String[] FullUsuarioSW  = {FullUsuario[0],FullUsuario[1],nombre,contraseña,correo,telefono,FullUsuario[6]};
				FullUsuario = FullUsuarioSW;
				String query = "UPDATE USUARIOS SET CORREO='"+ FullUsuario[4] +"', CONTRASEÑA='"+ FullUsuario[3] +"', TELEFONO='"+ FullUsuario[5]+"', USUARIO='"+ FullUsuario[2] +"' WHERE DNI='" + FullUsuario[1];
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
			} catch (Exception e2) {
				
				System.out.println(e2);
			}
			
		}


        if(e.getSource() == botonMenu) {
			botonMenu.setVisible(false);
			botonMenu2.setVisible(true);
			botonUsuario.setVisible(true);
			botonReservas.setVisible(true);
			
		} else if (e.getSource() == botonVolver) {
			PantallaPrincipal pp = new PantallaPrincipal(FullUsuario);
			pp.setVisible(true);
			this.dispose();
			} else if(e.getSource() == botonMenu2) {
				botonMenu.setVisible(true);
				botonUsuario.setVisible(false);
				botonReservas.setVisible(false);
			} else if (e.getSource() == botonReservas) {
				MisReservas m = new MisReservas(FullUsuario);
				m.setVisible(true);
				this.dispose();
			}
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
