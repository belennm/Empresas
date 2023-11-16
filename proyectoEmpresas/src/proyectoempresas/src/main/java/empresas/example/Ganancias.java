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
        

    public Ganancias() {
        frame = new JFrame("Ganancias");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Ganancias");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Crear un arreglo bidimensional
            int[][] tabla = new int[5][5];
            
    
            // Llenar la tabla
            for (int i = 0; i < tabla.length; i++) {
                for (int j = 0; j < tabla[i].length; j++) {
                    tabla[i][j] = i * j;
                }
            }
    
            // Imprimir la tabla
            for (int i = 0; i < tabla.length; i++) {
                for (int j = 0; j < tabla[i].length; j++) {
                    System.out.print(tabla[i][j] + " ");
                }
                System.out.println();
            }

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
