package proyecto;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class NuevaReserva extends JFrame implements ActionListener {

    JButton Opciones;
	JButton MisAnuncios;
	JButton VentanaUsuario;
	JLabel logo;
	JLabel titulo;
	JLabel titulo2;
	JLabel ejemplo;
	JLabel ejemplo2;
	JLabel ejemplo3;
	JLabel label1;
	JPanel panelLateral;
	JButton botonMenu;
	JButton botonMenu2;
	JButton botonUsuario;
	JButton botonReservas;
	JButton botonVolver;
    JButton nueva;
    JButton cancelar;
    JButton modificar;
	
	JTextField textousuario = new JTextField("");
	JTextField textocontrasena;
	JTextField textocorreo = new JTextField("");
	JTextField textotelefono = new JTextField("");
	JTextField textoCIF = new JTextField("");
	JTextField textodireccion = new JTextField("");
	JTextField textoNumeroCuenta = new JTextField("");
	JTextField textoClaveAcceso = new JTextField("");
	JTextField textocontrasena2;
	
	
	
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

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

    String nombreUsuario;
	int creditos;
	String[] FullUsuario = new String[7];

	
	
	
	JLabel avisoNombre = new JLabel();
	JLabel avisoContrasena = new JLabel();
	JLabel avisoRepetir = new JLabel();
	JLabel avisoCorreo = new JLabel();
	
	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	
	
	public NuevaReserva (String[] sqluser) {

        FullUsuario = sqluser;
	
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(242,242,242));


		DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
		modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
		modelo.addColumn("Precio");
        modelo.addColumn("Foto");

       
		Object[] fila3 = {"Ejemplo", "Calle ejemplo 2", new Date(123, 0, 1), 12 + " Creditos", "ejemplo.jpg"};
		Object[] fila1 = {"Ejemplo", "Calle ejemplo 542", new Date(123, 0, 1), 14 + " Creditos", "ruta_a_foto_ejemplo.jpg"};
		Object[] fila2 = {"Ejemplo", "Av. ejemplo 5", new Date(123, 0, 1), 15 + " Creditos", "ruta_a_foto_ejemplo.jpg"};
        modelo.addRow(fila1);
        modelo.addRow(fila2);
		modelo.addRow(fila3);

        // Crear el JTable con el modelo de datos
        JTable tabla = new JTable(modelo);

        // Agregar el JTable a un JScrollPane para permitir desplazamiento si hay muchas filas
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(200, 80, 800, 400);  // Ajusta las coordenadas y dimensiones según tus necesidades

        // Agregar el JScrollPane al contenido de la ventana
        getContentPane().add(scrollPane);

	
		
		Font fuente1 = new Font("Dialog", Font.BOLD ,28);
		Font fuente2 = new Font("Dialog", Font.BOLD ,16);
		Font fuente3 = new Font("Dialog", Font.PLAIN ,12);

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


        botonUsuario = new JButton("USUARIO");
	    botonUsuario.setBounds(15, 80, 145, 45);
	    botonUsuario.setFont(fuente1);
	    botonUsuario.setBorder(bordeBoton);
	    botonUsuario.addActionListener(this);
	    botonUsuario.setVisible(false);
	    botonUsuario.setBorder(new RoundedBorder(30)); 
	    botonUsuario.setContentAreaFilled(false);
		this.add(botonUsuario);
	    
	    botonReservas = new JButton("RESERVAS");
	    botonReservas.setBounds(15, 135, 145, 45);
	    botonReservas.setFont(fuente1);
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botonMenu) {
			botonMenu.setVisible(false);
			botonMenu2.setVisible(true);
			botonUsuario.setVisible(true);
			botonReservas.setVisible(true);
			
		} else if (e.getSource() == botonVolver) {
			MisReservas pp = new MisReservas(FullUsuario);
			pp.setVisible(true);
			this.dispose();
			} else if(e.getSource() == botonMenu2) {
				botonMenu.setVisible(true);
				botonUsuario.setVisible(false);
				botonReservas.setVisible(false);
			}else if(e.getSource() == botonUsuario){
				PantallaUsuario m = new PantallaUsuario(FullUsuario);
				m.setVisible(true);
				this.dispose();
			}
}
}