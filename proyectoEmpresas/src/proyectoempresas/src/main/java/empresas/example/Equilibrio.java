package empresas.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.collections4.Get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Representa al inventario de la empresa.
 */
public class Equilibrio {
        private JFrame frame;
        private String companyName;
        private String username;
        private JTextField nameEmpresa;
        private GetInfo getInfoPanel;
        private JTextArea result_area;

    public Equilibrio() {
        frame = new JFrame("Perfil");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // título
        JLabel titleLabel = new JLabel("Perfil");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Font questionFont = new Font( "Trebuchet MS", Font.BOLD, 16 );  // estilo preguntas
        Font textFieldFont = new Font( "Trebuchet MS", Font.PLAIN , 18);

        JPanel inputPanel = new JPanel(new GridBagLayout()); // grid para desplegar la info
        GridBagConstraints griid = new GridBagConstraints();
        griid.insets = new Insets(5, 5, 5 , 5 ); 
        
        getInfoPanel = new GetInfo(companyName) ;
        getInfoPanel.setVisible(false );

        griid.gridx = 0;
        griid.gridy = 9 ; // se coloca abajo
        griid.anchor = GridBagConstraints.EAST;
        JLabel companyLabel =  new JLabel ( "Nombre de la empresa:" );
        companyLabel.setFont(questionFont);
        inputPanel.setBackground(Color.BLACK);
        companyLabel.setForeground(Color.WHITE);
        inputPanel.add(companyLabel , griid );

        griid.gridx = 1;
        griid.anchor = GridBagConstraints.WEST;
        nameEmpresa =  new JTextField();
        nameEmpresa.setBackground( Color.BLACK);
        nameEmpresa.setForeground( Color.WHITE);
        nameEmpresa.setFont(textFieldFont);
        nameEmpresa.setPreferredSize(new Dimension(200, 35)); // tamaño del campo de nombre
        inputPanel.add(nameEmpresa, griid);

        GetInfo getInfo = new GetInfo(companyName);

        result_area.setText("El punto de equilibrio es: "  + GetInfo.breakEvenPointUnits +  " unidades.\n");
            result_area.append("Total de costos fijos: " + GetInfo.totalFixedCosts  + "\n");
            result_area.append("Costo variable por unidad: "   + GetInfo.variableCostsPerUnit + "\n");
            result_area.append("Precio por unidad: " + GetInfo.pricePerUnit +    "\n" );

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
