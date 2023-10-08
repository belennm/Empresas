package empresas.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la información de la empresa.
 */
public class GetInfo {

    private JFrame frame;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JTextField nameEmpresa; 

    // declaración de variables para almacenar respuestas
    private int cantidadProductosInventario;
    private double valorTotalInventario;
    private int cantidadEmpleados;
    private double presupuestoAnual;
    private int costoMantenimientoEquipos;
    private int cantidadEquipos;
    private double presupuestoGastosOperacion;
    private double ingresoMensualPromedio;
    private int presupuestoPersonal;
    private String companyName; 

    // -------- PEDIR INFORMACIÓN ----------
    public GetInfo(){
        frame = new JFrame("Información");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // Título
        JLabel titleLabel = new JLabel("Información");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout()); // Grid para desplegar la info
        GridBagConstraints griid = new GridBagConstraints();
        griid.insets = new Insets(5, 5, 5, 5); // espacio entre casda uno

        labels = new JLabel[9];
        textFields = new JTextField[9];

        Font questionFont = new Font( "Trebuchet MS", Font.BOLD, 16);  // estilo preguntas
        Font textFieldFont = new Font( "Trebuchet MS", Font.PLAIN, 18); // estilo respuestas

        // preguntas
        String[] preguntas ={
            "¿Cuántos productos tiene en su inventario?",
            "¿Cuál es el valor total de su inventario?",
            "¿Cuántos empleados tiene en su empresa?",
            "¿Cuál es su presupuesto anual?",
            "¿Cuál es el costo promedio de mantenimiento de sus equipo por mes?",
            "¿Cuántos equipos o activos físicos importantes posee la empresa?",
            "¿Cuál es su presupuesto asignado para el personal?",
            "¿Cuál es su presupuesto para gastos de operación por mes?",
            "¿Cuál es su ingreso mensual promedio?"
        };

        // field de las respuestas
        for ( int i =  0; i < 9; i++ ) {
            labels[i] = new JLabel(preguntas[i]);
            labels[i].setFont(questionFont);
            labels[i].setForeground(Color.WHITE);

            textFields[i] = new JTextField();
            textFields[i].setBackground(Color.BLACK);
            textFields[i].setForeground(Color.WHITE);
            textFields[i].setFont(textFieldFont) ;
            textFields[i].setPreferredSize(new Dimension(150, 35));
            textFields[i].setMinimumSize(new Dimension(150, 35));
            textFields[i].setMaximumSize(new Dimension(150, 35)) ;

            griid.gridx =  0;
            griid.gridy = i ;
            griid.anchor = GridBagConstraints.EAST;
            inputPanel.add(labels[i], griid );

            griid.gridx  = 1;
            griid.anchor = GridBagConstraints.WEST;
            inputPanel.add(textFields[i] , griid);
        }

        // para el nombre 
        griid.gridx = 0;
        griid.gridy = 9; // se coloca abajo
        griid.anchor = GridBagConstraints.EAST;
        JLabel companyLabel = new JLabel ( "Nombre de la empresa:" );
        companyLabel.setFont(questionFont);
        companyLabel.setForeground(Color.WHITE);
        inputPanel.add(companyLabel, griid);

        griid.gridx = 1;
        griid.anchor = GridBagConstraints.WEST;
        nameEmpresa = new JTextField();
        nameEmpresa.setBackground(Color.BLACK);
        nameEmpresa.setForeground(Color.WHITE);
        nameEmpresa.setFont(textFieldFont);
        nameEmpresa.setPreferredSize(new Dimension(200, 35)); // Tamaño del campo de nombre
        inputPanel.add(nameEmpresa, griid);

        frame.add(inputPanel, BorderLayout.CENTER );

        JButton guardarBoton  = new JButton("Guardar Información" );
        guardarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                saveRespuestas();
            }
        }
    );

        frame.add(guardarBoton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void saveRespuestas(){
        try{
            cantidadProductosInventario = Integer.parseInt(textFields[0].getText());
            valorTotalInventario = Double.parseDouble(textFields[1].getText());
            cantidadEmpleados = Integer.parseInt(textFields[2].getText());
            presupuestoAnual = Double.parseDouble(textFields[3].getText());
            costoMantenimientoEquipos = Integer.parseInt(textFields[4].getText());
            cantidadEquipos = Integer.parseInt(textFields[5].getText());
            presupuestoPersonal = Integer.parseInt(textFields[6].getText());
            presupuestoGastosOperacion = Double.parseDouble(textFields[7].getText());
            ingresoMensualPromedio = Double.parseDouble(textFields[8].getText());

            // Obtener el nombre de la empresa
            companyName = nameEmpresa.getText();

            // Cerrar la ventana
            frame.dispose();

            // abrir mainpage
            Controlador controlador = new Controlador();
            controlador.MainPage();

        } 
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Ingrese datos válidos.", "Error por dato inválido", JOptionPane.ERROR_MESSAGE);
        }
    }


}
