package proyecto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
/*
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*/
import java.sql.Date;
import java.sql.DriverManager;
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

	String[] seleccionVivienda = new String[5];

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

	Connection con = conectarBaseDatos();

	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

	DefaultTableModel modelo = new DefaultTableModel(){
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};



    public MisReservas(String[] sqluser) {

		FullUsuario = sqluser;

		this.creditos = Integer.parseInt(sqluser[6]);

        this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(242,242,242));


        Font fuente1 = new Font("Dialog", Font.PLAIN, 14);
		Font fuente2 = new Font("Dialog", Font.PLAIN, 20);
		Font fuente3 = new Font("Dialog", Font.BOLD, 47);
		Font fuente4 = new Font("Dialog", Font.BOLD, 27);
		Font fuente5 = new Font("Dialog", Font.BOLD, 15);
		
		titulo = new JLabel("MIS RESERVAS");
		titulo.setFont(fuente3);
		titulo.setForeground(Color.black);
		titulo.setBounds(450, 60, 1000, 60);
		this.getContentPane().add(titulo);


        modelo.addColumn("Codigo Reserva");
		modelo.addColumn("Codigo Vivienda");
        modelo.addColumn("Fecha Entrada");
		modelo.addColumn("Fecha Salida");
		modelo.addColumn("Precio");

		

		 // Crear el JTable con el modelo de datos
        JTable tabla = new JTable(modelo);

		

		allViviendas(con);

        // Agregar el JTable a un JScrollPane para permitir desplazamiento si hay muchas filas
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(220, 140, 800, 400);  // Ajusta las coordenadas y dimensiones según tus necesidades

        // Agregar el JScrollPane al contenido de la ventana
        getContentPane().add(scrollPane);



		//Selector Tabla
		tabla.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
				int filaSeleccionada = tabla.getSelectedRow();
				int columnaSeleccionada = tabla.getSelectedColumn();
		
				if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
					// Si se ha seleccionado una celda válida
					Object valorSeleccionado = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
					System.out.println("Valor seleccionado: " + valorSeleccionado);
					for (int i = 0; i < 5; i++) {
						Object valorSelFor = tabla.getValueAt(filaSeleccionada, i);
						String valorComoString = (valorSelFor != null) ? valorSelFor.toString() : "null";
						System.out.println(valorComoString);
						seleccionVivienda[i] = valorComoString;
					}
				} else if (filaSeleccionada != -1) {
					// Si solo se ha seleccionado una fila completa
					System.out.println("Fila seleccionada: " + filaSeleccionada);
				}
			}
		});

		
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
		nueva.setBounds(410, 570, 190, 30);
		this.getContentPane().add(nueva);
		nueva.addActionListener(this);
		nueva.setForeground(Color.BLACK);
		nueva.setBackground(new Color(242, 242, 242));
		nueva.setBorder(new RoundedBorder(22));

        cancelar = new JButton("Cancelar reserva");
		cancelar.setBounds(660, 570, 170, 30);
		this.getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		cancelar.setForeground(Color.BLACK);
		cancelar.setBackground(new Color(242, 242, 242));
		cancelar.setBorder(new RoundedBorder(22));

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

	private void allViviendas(Connection con) {
		String sql = "SELECT r.* FROM RESERVA r where ID_USUARIO = " + FullUsuario[0];
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Object[] filasql = {rs.getString("CODIGO_RESERVA"), rs.getString("CODIGO_VIVIENDA"), rs.getString("FECHAE"), rs.getString("FECHAS"), rs.getInt("PRECIOR") + " BC"};
					modelo.addRow(filasql);
				};
			} else {
				System.out.println("No he encontrado nada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void borrarvivienda(Connection con) {
		String sql = "DELETE FROM RESERVA WHERE CODIGO_RESERVA = " + seleccionVivienda[0];
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		} else if (e.getSource() == cancelar) {
			borrarvivienda(con);
		}
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
