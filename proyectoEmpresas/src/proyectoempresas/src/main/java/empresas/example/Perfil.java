package empresas.example;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

/**
 * Representa al Perfil de la empresa.
 */
public class Perfil {
    private JFrame frame;
    private Controlador controlador;

    public Perfil(Controlador controlador, String currentUsername) {
        this.controlador = controlador;
        String username = controlador.getUsername();

        frame = new JFrame("Perfil");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // título
        JLabel titleLabel = new JLabel("Perfil");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // para regresar a la página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            controlador.MainPage(username);
        });

        // agregar la etiqueta para mostrar los resultados
        JLabel resultLabel = new JLabel();
        String datos = getEmpresa(username);
        if (datos != null) {
            resultLabel.setText(datos);
        } else {
            resultLabel.setText("No se encontraron datos para el usuario: " + username);
        }

        // estilo y centrar
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private String getEmpresa(String username) {
        try (CSVReader reader = new CSVReader(new FileReader("empresa_info.csv"))) {
            List<String[]> datos = reader.readAll();
            for (String[] dato : datos) {
                if (dato.length >= 2 && dato[0].equals(username)) {
                    // Construir una cadena con los datos relevantes del CSV
                    return "Usuario: " + dato[0] + "\nNombre de la Empresa: " + dato[1]
                            + "\nCostos Fijos Totales: " + dato[2] + "\nPrecio por Unidad: " + dato[3]
                            + "\nUnidades a Vender: " + dato[4] + "\nCostos Variables por Unidad: " + dato[5]
                            + "\nResultados: " + dato[6];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
