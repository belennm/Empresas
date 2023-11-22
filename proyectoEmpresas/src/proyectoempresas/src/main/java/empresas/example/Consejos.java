package empresas.example;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Presenta algunos consejos para el usuario.
 */
public class Consejos {

    private JFrame frame;
    private String username; 
    private Controlador controlador;

    public Consejos(Controlador controlador, String username) {
        this.controlador = controlador;
        this.username = username;
        frame = new JFrame("Consejos");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // NOTA:
        // Se utilizó el apoyo brindado por la IA de Chat Bing para dar formato a la información colocada en la sección de consejos.
        // como el color de la fuente <font>, lineas en blanco <br>, formato de párrafo <html> y viñetas, además de cómo establecer un margen en la ventana.

        // Consejos sobre el alcance del punto de equilibrio
        JLabel textLabel = new JLabel("<html><font color='blue'>¿Qué pasa si alcanzo el punto de equlibrio?:</font><br>Una vez alcanzado el punto de equilibrio empiezas a ganar, sin embargo, debes tener en cuenta que no todo lo que ingresa es lucro. Tienes que recordar que el costo variable aumenta, por lo tanto, debes de tener esto siempre presente para no tener una idea equivocada del valor de tu ganancia. Podría ser momento de:<br><br>- Buscar un buen trato con proveedores<br> - Capacitar más a tu personal<br>- Mejorar tus procesos<br> - Construir o mejorar las alianzas con otras empresas o inversionistas<br><br><font color='blue'>¿Qué pasa si no alcanzo el punto de equlibrio?:</font><br>Si no se llega al punto de equilibrio tu negocio es más vulnerable a perdidas, lo cual indica que también no es estable por lo que sería buena idea:<br><br> - Mostrar qué hace diferente a tu negocio de los demás<br> - Sube los precios teniendo en cuenta cómo lo hace la competencia y a quienes les funciona<br> - Revisa si tu marketing podría ser mejor<br> - Elimina procesos innecesarios<br> - Ten paciencia</html>");
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBorder(new EmptyBorder(30, 30, 30, 30)); // agrega un margen de 10 pixeles en todos los lados

        // para regresar a la página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            controlador.MainPage(username);  
        });

        frame.setLayout(new BorderLayout());
        frame.add(textLabel , BorderLayout.CENTER);
        frame.add(backButton , BorderLayout.SOUTH);

        frame.setVisible(true);
    }    
}
