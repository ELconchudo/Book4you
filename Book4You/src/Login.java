
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
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JButton Login;
	JButton Registrarse;
	JTextField areadetexto = new JTextField("");
	JTextField areadetexto2;
	JLabel usuario;
	JLabel contraseña;
	JLabel Titulo;
	
	ImageIcon Logo = new ImageIcon("Imagenes/Logo3.png");
	
public Login() {
		
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(230, 255, 230));
	
		Font font3 = new Font("Dialog", Font.BOLD ,20);	
		
		Titulo = new JLabel(Logo);
		Titulo.setBounds(260,20,520,200);
		this.add(Titulo);
		Titulo.setVisible(true);
		
		//BOTON LOGIN
		Login = new JButton("Login");
		Login.setBounds(360, 450, 113, 25);
		this.getContentPane().add(Login);
		Login.addActionListener(this);
		Login.setForeground(Color.BLACK);
		Login.setBackground(new Color(242, 242, 242));
		Login.setBorder(new RoundedBorder(22));
		
		//BOTON REGISTRO
		Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(525, 450, 113, 25);
		this.getContentPane().add(Registrarse);
		Registrarse.addActionListener(this);
		Registrarse.setForeground(Color.BLACK);
		Registrarse.setBackground(new Color(242, 242, 242));
		Registrarse.setBorder(new RoundedBorder(22));
		
		usuario = new JLabel("Usuario");
		Font font1 = new Font("Dialog", Font.PLAIN ,20);
		usuario.setFont(font3);
		usuario.setBounds(387, 270, 110, 20);
		usuario.setForeground(Color.BLACK);
		this.getContentPane().add(usuario);
		
		areadetexto.setFont(font1);
		areadetexto.setBounds(515, 267, 120, 30);
		this.getContentPane().add(areadetexto);
		
		contraseña = new JLabel("Contraseña");
		contraseña.setFont(font3);
		contraseña.setBounds(355, 354, 120, 20);
		this.getContentPane().add(contraseña);
		contraseña.setForeground(Color.BLACK);
		
		areadetexto2 = new JPasswordField();
		areadetexto2.setBounds(515, 351, 120, 30);
		this.getContentPane().add(areadetexto2);
		areadetexto2.addActionListener(this);
		
		this.setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
