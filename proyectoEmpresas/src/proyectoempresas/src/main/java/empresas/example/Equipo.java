package empresas.example;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Representa al Equipo de la empresa.
 */
public class Equipo {
    private JFrame frame;

    public Equipo() {
        frame = new JFrame("Equipo");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Equipo");
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

        frame.setVisible(true);
    }    
}
