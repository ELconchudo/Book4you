package proyecto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;



public class MisReservas extends JFrame implements ActionListener {

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

	String nombreUsuario;
	int creditos;
	String[] FullUsuario = new String[7];

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

    public MisReservas(String[] sqluser) {

		FullUsuario = sqluser;

		this.creditos = Integer.parseInt(sqluser[6]);

        this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));


        Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 50);
		Font fuente4 = new Font("Dialog", Font.BOLD, 27);
		Font fuente5 = new Font("Dialog", Font.BOLD, 15);
		
		titulo = new JLabel("Mis reservas");
		titulo.setFont(fuente3);
		titulo.setForeground(Color.black);
		titulo.setBounds(450, 60, 1000, 60);
		this.getContentPane().add(titulo);

		DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
		modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
		modelo.addColumn("Precio");
        modelo.addColumn("Foto");

       
		

		 // Crear el JTable con el modelo de datos
        JTable tabla = new JTable(modelo);

        // Agregar el JTable a un JScrollPane para permitir desplazamiento si hay muchas filas
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(200, 140, 800, 400);  // Ajusta las coordenadas y dimensiones según tus necesidades

        // Agregar el JScrollPane al contenido de la ventana
        getContentPane().add(scrollPane);

		
		//CREDITOS
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

       
        nueva = new JButton("Hacer nueva reserva");
		nueva.setBounds(300, 570, 190, 30);
		this.getContentPane().add(nueva);
		nueva.addActionListener(this);
		nueva.setForeground(Color.BLACK);
		nueva.setBackground(new Color(242, 242, 242));
		nueva.setBorder(new RoundedBorder(22));

        cancelar = new JButton("Cancelar reserva");
		cancelar.setBounds(530, 570, 170, 30);
		this.getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		cancelar.setForeground(Color.BLACK);
		cancelar.setBackground(new Color(242, 242, 242));
		cancelar.setBorder(new RoundedBorder(22));

        modificar = new JButton("Modificar reserva");
		modificar.setBounds(740, 570, 170, 30);
		this.getContentPane().add(modificar);
		modificar.addActionListener(this);
		modificar.setForeground(Color.BLACK);
		modificar.setBackground(new Color(242, 242, 242));
		modificar.setBorder(new RoundedBorder(22));

		//---------------------MENU LATERAL------------------------\\
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

    

	@Override
    public void actionPerformed(ActionEvent e) {

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
		}else if(e.getSource() == botonUsuario){
				PantallaUsuario m = new PantallaUsuario(FullUsuario);
				m.setVisible(true);
				this.dispose();
		}else if(e.getSource() == nueva){
				NuevaReserva n = new NuevaReserva(FullUsuario);
				n.setVisible(true);
				this.dispose();
		}
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
