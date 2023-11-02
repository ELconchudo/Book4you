package proyecto;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class login extends JFrame implements ActionListener {
	
	JButton Login;
	JButton Registrarse;
	JTextField areadetexto = new JTextField("");
	JTextField areadetexto2;
	JLabel usuario;
	JLabel contraseña;
	JLabel titulo;
	
public login() {
		
		this.setBounds(500, 220, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242, 242, 242));
		
		Font font3 = new Font("Dialog", Font.PLAIN ,12);
		
		titulo = new JLabel("Inicia sesión o regístrate");
		Font font = new Font("Dialog", Font.BOLD ,28);
		titulo.setFont(font);
		titulo.setBounds(300, 30, 400, 35);
		titulo.setForeground(Color.BLACK);
		this.getContentPane().add(titulo);
		
		Login = new JButton("Login");
		Login.setBounds(350, 400, 113, 25);
		this.getContentPane().add(Login);
		Login.addActionListener(this);
		Login.setForeground(Color.BLACK);
		Login.setBackground(new Color(242, 242, 242));
		Login.setBorder(new RoundedBorder(22));
		
		Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(545, 400, 113, 25);
		this.getContentPane().add(Registrarse);
		Registrarse.addActionListener(this);
		Registrarse.setForeground(Color.BLACK);
		Registrarse.setBackground(new Color(242, 242, 242));
		Registrarse.setBorder(new RoundedBorder(22));
		
		usuario = new JLabel("Usuario");
		Font font1 = new Font("Dialog", Font.PLAIN ,20);
		usuario.setFont(font1);
		usuario.setBounds(365, 167, 110, 20);
		usuario.setForeground(Color.BLACK);
		this.getContentPane().add(usuario);
		
		areadetexto.setFont(font3);
		areadetexto.setBounds(515, 167, 110, 20);
		this.getContentPane().add(areadetexto);
		
		contraseña = new JLabel("Contraseña");
		contraseña.setFont(font1);
		contraseña.setBounds(347, 251, 120, 20);
		this.getContentPane().add(contraseña);
		contraseña.setForeground(Color.BLACK);
		
		areadetexto2 = new JPasswordField();
		areadetexto2.setBounds(515, 251, 110, 20);
		this.getContentPane().add(areadetexto2);
		areadetexto2.addActionListener(this);
		this.setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
