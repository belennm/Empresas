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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Representa el punto de equilibrio de la empresa.
 */
public class Equilibrio {
    private JFrame frame;
    private String username;
    private JTable table;
    private DefaultTableModel model;
    private Controlador controlador;
  
        private String companyName;
    
        private JTextField nameEmpresa;
        private GetInfo getInfoPanel;
        private JTextArea result_area;

    public Equilibrio(Controlador controlador, String username) {
        this.controlador = controlador;
        this.username = username;
        frame = new JFrame("Punto de Equilibrio");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Título
        JLabel titleLabel = new JLabel("Punto de Equilibrio");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        //GetInfo getInfo = new GetInfo(companyName);

        // result_area.setText("El punto de equilibrio es: "  + GetInfo.breakEvenPointUnits +  " unidades.\n");
        //     result_area.append("Total de costos fijos: " + GetInfo.totalFixedCosts  + "\n");
        //     result_area.append("Costo variable por unidad: "   + GetInfo.variableCostsPerUnit + "\n");
        //     result_area.append("Precio por unidad: " + GetInfo.pricePerUnit +    "\n" );


        // para regresar a la página principal
        JButton backButton = new JButton("Regresar");
        backButton.addActionListener(e -> {
            frame.dispose();
            // regresar a mainPage
            controlador.MainPage(username); 
        });
    
    
}
}
