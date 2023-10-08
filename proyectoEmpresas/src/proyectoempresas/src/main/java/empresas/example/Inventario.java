package empresas.example;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Representa al inventario de la empresa.
 */
public class Inventario {
        private JFrame frame;

    public Inventario() {
        frame = new JFrame("Inventario");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // título
        JLabel titleLabel = new JLabel("Inventario");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // para regresar a la página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            Controlador controlador = new Controlador(); 
            controlador.MainPage(); 
        });

        // estilo y centrar
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
