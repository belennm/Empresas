package empresas.example;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;  

/**
 * Representa el personal de la empresa.
 */
public class Ganancias {

    private JFrame frame;
    private String username; 
    private Controlador controlador;
        

    public Ganancias(Controlador controlador, String username) {
        this.controlador = controlador;
        this.username = username;
        frame = new JFrame("Ganancias");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Ganancias");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

       

        // represar a página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            controlador.MainPage(username); 
        });

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
}