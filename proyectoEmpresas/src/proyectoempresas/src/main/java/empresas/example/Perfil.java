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
        private String username; 
        private Controlador controlador;


    private void mostrarEmpresa(String username){
        String datos = getEmpresa(username);
        if(datos != null){
            JFrame frame = new JFrame("Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(850, 550);

            JLabel label = new JLabel();
            label.setText(datos);

            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
    private String getEmpresa(String username){
        try(CSVReader reader = new CSVReader(new FileReader("empresa_info.csv"))){
            List<String[]> datos = reader.readAll();
            for (String[] dato : datos){
                if (dato.length>=2 && dato[0].equals(username)){
                    return "Usuario: "+ dato[0] + "Empresa:" + dato[1];
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }catch(CsvException e){
            e.printStackTrace();
        }
        return null;
    }

    public Perfil(Controlador controlador, String username) {
        this.controlador = controlador;
        this.username = username;

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

        // estilo y centrar
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}


