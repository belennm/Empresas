
package empresas.example;

import javax.swing.*;

import com.opencsv.CSVWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


/**
 * Clase que representa la información de la empresa.
 */
public class MainPage {

    private JFrame frame;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JTextField nameEmpresa; 
    private JButton guardarContinueBoton;

    // declaración de variables para almacenar respuestas
    private String companyName; 
    private String username; 

    // Campos para GetInfo
    private GetInfo getInfoPanel;

    // -------- PEDIR INFORMACIÓN ----------
    public MainPage(String username){

        this.username = username;

        frame = new JFrame("Información");
        frame.setSize(900, 600); // size de la pantalla
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout() );
        frame.setLocationRelativeTo(null) ;
        frame.getContentPane().setBackground(Color.BLACK);
        

        // título
        JLabel titleLabel = new JLabel("Información");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout()); // grid para desplegar la info
        GridBagConstraints griid = new GridBagConstraints();
        griid.insets = new Insets(5, 5, 5 , 5 ); // espacio entre casda uno

        labels =  new JLabel[9];
        textFields = new JTextField[9] ;

        Font questionFont = new Font( "Trebuchet MS", Font.BOLD, 16 );  // estilo preguntas
        Font textFieldFont = new Font( "Trebuchet MS", Font.PLAIN , 18); // estilo respuestas

         // campos para GetInfo
         getInfoPanel = new GetInfo(companyName) ;
         getInfoPanel.setVisible(false ); // inicialmente oculto
        

        // para el nombre 
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


        griid.gridy = 10;
        inputPanel.add(getInfoPanel.getInfoPanel(), griid);

        frame.add(inputPanel, BorderLayout.CENTER );
        

        guardarContinueBoton  = new JButton("Continuar" );

        // acción que se realiza al presionar el botón continuar
        guardarContinueBoton.addActionListener(new ActionListener(){

            @Override

            public void actionPerformed( ActionEvent e){
                //saveRespuestas();

                //permite continuar solo si los campos están llenos
                if ( nameEmpresa.getText().trim().isEmpty()  ||  !getInfoPanel.isInfoLleno() ){
                    JOptionPane.showMessageDialog(frame, "Ingrese todos los datos para continuar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                } 
                else{

                    saveDatos_csv();
                    saveRespuestas();
                }
        
            }
        }
    );


        // display del botón para continuar 
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarContinueBoton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
       
    }


    private void saveRespuestas(){

        // try and catch para la obtención de datos
        try{


            // para el nombre de la empresa
            companyName = nameEmpresa.getText();

            // cerrar la ventana
            frame.dispose();

            // abrir mainpage
            Controlador controlador = new Controlador();
            controlador.MainPage();
       
      

        } 
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Ingrese datos válidos.", "Error por dato inválido", JOptionPane.ERROR_MESSAGE );
        }
    }

    private void saveDatos_csv() {
        String fileName = "empresa_info.csv";
        File file = new File(fileName);
        boolean append = file.exists() && file.length() > 0;


        try {
            FileWriter writer = new FileWriter(fileName, true); // True para añadir datos sin sobrescribir
            CSVWriter csvWriter = new CSVWriter(writer);

            if(!append){
                // Encabezados si es necesario (omítelo si ya están en el archivo)
                String[] headers = {"Usuario", "Nombre de la Empresa", "Costos Fijos Totales", "Precio por Unidad", "Unidades a Vender", "Costos Variables por Unidad", "Resultados"};
                csvWriter.writeNext(headers); 
            }


            // NOTA:
            // Para realizar el siguiente fragmento de código se utilizó el apoyo brindado por la IA de ChatGPT.
            // Con el apoyo de la referencia del siguiente código se realizó la estructura lógica para los datos a guardar.
            // OpenAI.: en el csv los datos se guardan de la siguiente forma (los datos son un ejemplo de usuario): "Usuario","Nombre de la Empresa","Costos Fijos Totales","Precio por Unidad","Unidades a Vender","Costos Variables por Unidad"
                        //"aissa","jungla","500","35","80","10","El punto de equilibrio es: 20.0 unidades.
                        //Total de costos fijos: 500.0
                        //Costo variable por unidad: 10.0
                        //Precio por unidad: 35.0
                        //Con 80.0 unidades, usted ALCANZAR� el punto de equilibrio." 
                        //Quisiera que se guardara de la siguiente forma,: "Usuario","Nombre de la Empresa","Costos Fijos Totales","Precio por Unidad","Unidades a Vender","Costos Variables por Unidad","Resultados"
                        //"aissa","jungla","500","35","80","10","El punto de equilibrio es: 20.0 unidades. Total de costos fijos: 500.0 Costo variable por unidad: 10.0 Precio por unidad: 35.0 Con 80.0 unidades, usted ALCANZAR� el punto de equilibrio."
                        //omitir el salto de linea. [consultado el 14/11/2023].

            // private void saveDatos_csv() {
            //     // ... Resto del código para inicializar csvWriter ...
            
            //     // Obtener los resultados y reemplazar saltos de línea
            //     String resultText = getInfoPanel.getResultAreaText().replace("\n", " ");

            //      String[] data = {
            //          username,
            //          nameEmpresa.getText(),
            //          getInfoPanel.getTotalFixedCosts(),
            //          getInfoPanel.getPrecioXUnit(),
            //          getInfoPanel.getUnitsSell(),
            //          getInfoPanel.getVariableCostsXUnidad(),
            //          resultText
            //      };
            
            //     // ... Resto del código ...
            // }
                        
       

            // datos a guardar
            String[] data = {
            username,
                nameEmpresa.getText(),
                getInfoPanel.getTotalFixedCosts(),
                getInfoPanel.getPrecioXUnit(),
                getInfoPanel.getUnitsSell(),
                getInfoPanel.getVariableCostsXUnidad(),
                getInfoPanel.getResultAreaText().replace( "\n", " " )
            };
            csvWriter.writeNext(data);

            csvWriter.close();
            JOptionPane.showMessageDialog(frame, "Datos almacenados.");
        } 
        catch (IOException e ){
            JOptionPane.showMessageDialog( frame, "Error al guardar los datos.");
        }
    }


}
