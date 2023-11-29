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
	JButton botonInicio;
	JButton botonAnuncios;
	JButton botonVolver;
    JButton nueva;
    JButton cancelar;
    JButton modificar;

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

    public MisReservas() {

        this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));


        Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 50);


       
        nueva = new JButton("Hacer nueva reserva");
		nueva.setBounds(350, 450, 190, 30);
		this.getContentPane().add(nueva);
		nueva.addActionListener(this);
		nueva.setForeground(Color.BLACK);
		nueva.setBackground(new Color(242, 242, 242));
		nueva.setBorder(new RoundedBorder(22));

        cancelar = new JButton("Cancelar reserva");
		cancelar.setBounds(560, 450, 170, 25);
		this.getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		cancelar.setForeground(Color.BLACK);
		cancelar.setBackground(new Color(242, 242, 242));
		cancelar.setBorder(new RoundedBorder(22));

        modificar = new JButton("Modificar reserva");
		modificar.setBounds(720, 450, 113, 25);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
