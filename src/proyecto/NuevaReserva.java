package proyecto;

import java.awt.Color;

import java.awt.Font;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;


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
	
	JDateChooser dateChooser;
	JTextField campoFecha;

    ImageIcon icono =  new ImageIcon("Imagenes/volver.png");
	ImageIcon menuM =  new ImageIcon("Imagenes/IconoMenu.png");
	ImageIcon volver =  new ImageIcon("Imagenes/volver.png");

    String nombreUsuario;
	int creditos;
	String[] FullUsuario = new String[7];
	DefaultTableModel modelo = new DefaultTableModel();
	JTable tabla = new JTable();
	
	String[] seleccionVivienda = new String[6];
	String fechaFormateada;
	
	JLabel avisoNombre = new JLabel();
	JLabel avisoContrasena = new JLabel();
	JLabel avisoRepetir = new JLabel();
	JLabel avisoCorreo = new JLabel();
	Connection con = conectarBaseDatos();

	LocalDate localDate = LocalDate.of(2023, 1, 1); // 1 de enero de 23
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


	
	private static final String USER = "DW2_2324_BOOK4U_KIA_CO";
	private static final String PWD = "AKIA_CO";
	// Si estais desde casa, la url sera oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	
	
	public NuevaReserva (String[] sqluser) {
			// Formatear LocalDate a una cadena
			fechaFormateada = localDate.format(formatter);
			System.out.println("Fecha formateada: " + fechaFormateada);

        FullUsuario = sqluser;
	
		this.setBounds(300, 130, 1080, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(242,242,242));

		modelo.addColumn("ID");
        modelo.addColumn("Nombre");
		modelo.addColumn("Dirección");
        modelo.addColumn("Fecha");
		modelo.addColumn("Fecha Final");
		modelo.addColumn("Precio");
        modelo.addColumn("Foto");

       
		allReservas(con);

		Object[] fila3 = {"5003","Ejemplo", "Calle ejemplo 2",fechaFormateada, fechaFormateada , 4  , "ejemplo.jpg"};
		Object[] fila1 = {"5002","Ejemplo", "Calle ejemplo 542", fechaFormateada, fechaFormateada, 6  , "ejemplo.jpg"};
		Object[] fila2 = {"5001","Ejemplo", "Av. ejemplo 5", fechaFormateada, fechaFormateada, 8  , "ejemplo.jpg"};
        modelo.addRow(fila1);
        modelo.addRow(fila2);
		modelo.addRow(fila3);
		
		 
        tabla = new JTable(modelo);

		tabla.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
				int filaSeleccionada = tabla.getSelectedRow();
				int columnaSeleccionada = tabla.getSelectedColumn();
		
				if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
					// Si se ha seleccionado una celda válida
					Object valorSeleccionado = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
					System.out.println("Valor seleccionado: " + valorSeleccionado);
					for (int i = 0; i < 6; i++) {
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

       
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(220, 140, 800, 400);  

        
        getContentPane().add(scrollPane);


		nueva = new JButton("Reservar");
		nueva.setBounds(520, 570, 190, 30);
		this.getContentPane().add(nueva);
		nueva.addActionListener(this);
		nueva.setForeground(Color.BLACK);
		nueva.setBackground(new Color(242, 242, 242));
		nueva.setBorder(new RoundedBorder(22));

		
		Font fuente1 = new Font("Dialog", Font.BOLD ,28);
		Font fuente2 = new Font("Dialog", Font.BOLD ,16);
		Font fuente3 = new Font("Dialog", Font.BOLD, 15);
		Font fuente4 = new Font("Dialog", Font.BOLD, 47);
		Font fuente5 = new Font("Dialog", Font.BOLD, 27);


		//TITULO
		titulo = new JLabel("RESERVAS DISPONIBLES");
		titulo.setFont(fuente4);
		titulo.setForeground(Color.black);
		titulo.setBounds(330, 60, 1000, 60);
		this.getContentPane().add(titulo);

		//CREDITOS
		label1 = new JLabel(FullUsuario[6]);
		label1.setForeground(Color.BLACK);
		label1.setFont(fuente5);
		label1.setBounds(960, 70, 50, 50);
		label1.setVisible(true);
		this.add(label1);
		logo = new JLabel();
		logo.setIcon(new ImageIcon("Imagenes/BlackCoin.png"));
		logo.setBounds(980,70,50,50);
		this.add(logo);

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
	    botonUsuario.setFont(fuente3);
	    botonUsuario.setBorder(bordeBoton);
	    botonUsuario.addActionListener(this);
	    botonUsuario.setVisible(false);
	    botonUsuario.setBorder(new RoundedBorder(30)); 
	    botonUsuario.setContentAreaFilled(false);
		this.add(botonUsuario);
	    
	    botonReservas = new JButton("RESERVAS");
	    botonReservas.setBounds(15, 135, 145, 45);
	    botonReservas.setFont(fuente3);
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

	private java.util.Date obtenerFechaDesdeChooser() {
        java.util.Date fecha = null;
        if (dateChooser != null && dateChooser.getDate() != null) {
            fecha = dateChooser.getDate();
        }
        return fecha;
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

	private void allReservas(Connection con) {
		String sql = "SELECT v.* FROM VIVIENDA v";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Object[] filasql = {rs.getString("ID_VIVIENDA"), rs.getString("NOMBRE"),rs.getString("LUGAR"), fechaFormateada, fechaFormateada,rs.getInt("PRECIO"), "ejemplo.png"};
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


	public void nuevaReserva(){
		
		int rPrecio = Integer.parseInt(FullUsuario[6]) - Integer.parseInt(seleccionVivienda[5]);

		if (rPrecio > 0) {
			FullUsuario[6] = Integer.toString(rPrecio);
			String sql2 = "UPDATE USUARIOS SET CREDITOS = " + FullUsuario[6] + " WHERE USERID = " + FullUsuario[0];
			try {
				Connection con = conectarBaseDatos();
				java.sql.Statement st = con.createStatement();
				st.execute(sql2);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			String sql = "INSERT INTO RESERVA(ID_USUARIO, CODIGO_VIVIENDA, PRECIOR, FECHAE, FECHAS)" + 
			"VALUES('"+ FullUsuario[0] +"', '"+ seleccionVivienda[0] +"','"+ seleccionVivienda[5] +"', '"+ seleccionVivienda[3] +"', '"+ seleccionVivienda[4] +"')";
			try {
				Connection con = conectarBaseDatos();
				java.sql.Statement st = con.createStatement();
				st.execute(sql);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No tienes suficientes creditos");
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
			else if (e.getSource() == botonReservas) {
				MisReservas m = new MisReservas(FullUsuario);
				m.setVisible(true);
				this.dispose();
			} else if(e.getSource() == nueva) {
				nuevaReserva();
				MisReservas m = new MisReservas(FullUsuario);
				m.setVisible(true);
				this.dispose();
			}
}
}