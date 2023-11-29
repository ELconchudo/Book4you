package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main2 extends JFrame implements ActionListener {

    private JButton crearButton;
    private JButton modificarButton;
    private JButton cancelarButton;

    public Main2() {
        initializeUI();
        setupComponents();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Gestión de Reservas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 235, 173));
        setLayout(new GridLayout(3, 1));
    }

    private void setupComponents() {
        Font font = new Font("Arial", Font.BOLD, 20);

        crearButton = new JButton("Crear Reserva");
        crearButton.addActionListener(this);
        crearButton.setFont(font);
        add(crearButton);

        modificarButton = new JButton("Modificar Reserva");
        modificarButton.addActionListener(this);
        modificarButton.setFont(font);
        add(modificarButton);

        cancelarButton = new JButton("Cancelar Reserva");
        cancelarButton.addActionListener(this);
        cancelarButton.setFont(font);
        add(cancelarButton);
    }

    private void crearReserva() {
        // Lógica para crear una reserva
    }

    private void modificarReserva() {
        // Lógica para modificar una reserva existente
    }

    private void cancelarReserva() {
        // Lógica para cancelar una reserva
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearButton) {
            crearReserva();
        } else if (e.getSource() == modificarButton) {
            modificarReserva();
        } else if (e.getSource() == cancelarButton) {
            cancelarReserva();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main2::new);
    }
}