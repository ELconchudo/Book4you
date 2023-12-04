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

public class MisReservas extends JFrame implements ActionListener {

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
    JButton nueva;
    JButton cancelar;
    JButton modificar;

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

	private String[] sqluser = new String[7];

    public MisReservas() {

        this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));


        Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 50);


       
        nueva = new JButton("Hacer nueva reserva");
		nueva.setBounds(300, 500, 190, 30);
		this.getContentPane().add(nueva);
		nueva.addActionListener(this);
		nueva.setForeground(Color.BLACK);
		nueva.setBackground(new Color(242, 242, 242));
		nueva.setBorder(new RoundedBorder(22));

        cancelar = new JButton("Cancelar reserva");
		cancelar.setBounds(530, 500, 170, 30);
		this.getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		cancelar.setForeground(Color.BLACK);
		cancelar.setBackground(new Color(242, 242, 242));
		cancelar.setBorder(new RoundedBorder(22));

        modificar = new JButton("Modificar reserva");
		modificar.setBounds(740, 500, 170, 30);
		this.getContentPane().add(modificar);
		modificar.addActionListener(this);
		modificar.setForeground(Color.BLACK);
		modificar.setBackground(new Color(242, 242, 242));
		modificar.setBorder(new RoundedBorder(22));


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
			PantallaPrincipal pp = new PantallaPrincipal(sqluser[2], Integer.parseInt(sqluser[6]));
			pp.setVisible(true);
			this.dispose();
			} else if(e.getSource() == botonMenu2) {
				botonMenu.setVisible(true);
				botonUsuario.setVisible(false);
				botonReservas.setVisible(false);
			}
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
