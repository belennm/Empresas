package empresas.example;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Representa el personal de la empresa.
 */
public class Personal {

    private JFrame frame;
        

    public Personal() {
        frame = new JFrame("Presupuesto");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Personal");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // represar a página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            Controlador controlador = new Controlador(); 
            controlador.MainPage(); 
        });

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
}
