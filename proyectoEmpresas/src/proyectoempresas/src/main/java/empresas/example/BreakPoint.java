package empresas.example;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Representa el punto de equilibrio de la empresa.
 */
public class BreakPoint {
    private JFrame frame;
    private String username;
    private JTable table;
    private DefaultTableModel model;

    public BreakPoint(String username) {
        this.username = username;

        frame = new JFrame("Punto de Equilibrio");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Punto de Equilibrio");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // para regresar a la página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            Controlador controlador = new Controlador(); 
            controlador.MainPage(); 
        });

        // estilo
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);


        //datos
        cargarDatos();

        frame.setVisible(true);
    }    

    private void cargarDatos() {
        String path = "empresa_info.csv"; 
        String line = "";
    }
    
    
}
